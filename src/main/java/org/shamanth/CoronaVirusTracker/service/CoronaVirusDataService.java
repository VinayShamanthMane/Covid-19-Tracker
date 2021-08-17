package org.shamanth.CoronaVirusTracker.service;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.shamanth.CoronaVirusTracker.model.StatsModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CoronaVirusDataService {

	@Value("${statewise_virus_data}")
	private String virus_data_url;

	private List<StatsModel> allStats = new ArrayList<>();

	public List<StatsModel> getAllStats() {
		return allStats;
	}

	@PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	public void fetchStatewiseVirusInfo() {

		List<StatsModel> newStats = new ArrayList<>();

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(virus_data_url)).build();

		try {

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			StringReader csvReader = new StringReader(response.body());

			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
			for (CSVRecord record : records) {

				StatsModel statsModel = new StatsModel();
				statsModel.setState(record.get("State"));
				statsModel.setConfirmedCases(record.get("Confirmed"));
				statsModel.setRecoveredCases(record.get("Recovered"));
				statsModel.setDeaths(record.get("Deaths"));
				statsModel.setActiveCases(record.get("Active"));
				statsModel.setLastUpdatedTime(record.get("Last_Updated_Time"));
				newStats.add(statsModel);

			}

			this.allStats = newStats;

		} catch (IOException e) {

			System.out.println("An IOException occured : " + e.getMessage());
		} catch (InterruptedException e) {

			System.out.println("An InterruptedException occured : " + e.getMessage());
		}

	}

}
