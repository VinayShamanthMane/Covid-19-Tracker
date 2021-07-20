package org.shamanth.CoronaVirusTracker.controller;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;



import org.shamanth.CoronaVirusTracker.model.VaccineDetailsList;
import org.shamanth.CoronaVirusTracker.model.VaccineFinderDetails;
import org.shamanth.CoronaVirusTracker.service.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomePageController {

	
	@Autowired
	CoronaVirusDataService coronaVirusDataService;
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${vaccine_Details_Url}")
	private String vaccineDetailsUrl;
	
	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("CoronaVirusStats", coronaVirusDataService.getAllStats());
		model.addAttribute("vaccineDetails", new VaccineFinderDetails());
		return "home";
	}
	
	
	 @PostMapping("/vaccineDetails")
	  public String VaccineDetailsFinder(@ModelAttribute("vaccineDetails") VaccineFinderDetails vaccineFinderDetails, Model model) {
		 
			// model.addAttribute("vaccineDetails", vaccineFinderDetails);
			/*
			 * System.out.println(vaccineDetailsUrl + vaccineFinderDetails.getPincode() +
			 * "&date=" + vaccineFinderDetails.getDate() );
			 * 
			 * VaccineDetailsJsonList vaccineDetailsJsonList =
			 * restTemplate.getForObject(vaccineDetailsUrl +
			 * vaccineFinderDetails.getPincode() + "&date=" + vaccineFinderDetails.getDate()
			 * , VaccineDetailsJsonList.class);
			 * 
			 * List<VaccineDetailsModel> vaccineDetails =
			 * vaccineDetailsJsonList.getAllSessionsAvailable();
			 * 
			 * System.out.println(vaccineDetailsJsonList);
			 * System.out.println(vaccineDetails);
			 * 
			 * for (VaccineDetailsModel vaccineDetailsModel : vaccineDetails) {
			 * System.out.println(vaccineDetailsModel.getAddress() + " " +
			 * vaccineDetailsModel.getPincode()); }
			 */
				/*
				 * ResponseEntity<VaccineDetailsModel[]> responseEntity =
				 * restTemplate.getForEntity(vaccineDetailsUrl, VaccineDetailsModel[].class);
				 * VaccineDetailsModel[] userArray = responseEntity.getBody();
				 * System.out.println(Arrays.stream(userArray)
				 * .map(VaccineDetailsModel::getName) .collect(Collectors.toList()));
				 */
		 
		 

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
									.uri(URI.create(vaccineDetailsUrl + vaccineFinderDetails.getPincode() + 
											"&date=" + vaccineFinderDetails.getDate())).build();
			
			 
			try {
				
				HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
							
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				VaccineDetailsList vaccineDetailsList = mapper.readValue(response.body(), VaccineDetailsList.class);
				
					model.addAttribute("vaccineDetailsList", vaccineDetailsList.getSessions());
					
					
				/*
				 * for (VaccineDetailsModel vaccineDetails :
				 * vaccineDetailsJsonList.getSessions()) {
				 * System.out.println(vaccineDetails.getAddress() + " " +
				 * vaccineDetails.getPincode()); }
				 */
				
			} catch (IOException e) {	
				
				System.out.println("An IOException occured : " + e.getMessage());
				
			} catch (InterruptedException e) {
				
				System.out.println("An InterruptedException occured : " + e.getMessage());
				
			}
				
			
		 
	   return "vaccine";
	  }
	
}
