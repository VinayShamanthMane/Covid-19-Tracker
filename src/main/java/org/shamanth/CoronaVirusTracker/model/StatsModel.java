package org.shamanth.CoronaVirusTracker.model;

public class StatsModel {
	
	private String state;
	private String confirmedCases;
	private String recoveredCases;
	private String deaths;
	private String activeCases;
	private String lastUpdatedTime;
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getConfirmedCases() {
		return confirmedCases;
	}
	public void setConfirmedCases(String confirmedCases) {
		this.confirmedCases = confirmedCases;
	}
	public String getRecoveredCases() {
		return recoveredCases;
	}
	public void setRecoveredCases(String recoveredCases) {
		this.recoveredCases = recoveredCases;
	}
	public String getDeaths() {
		return deaths;
	}
	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}
	public String getActiveCases() {
		return activeCases;
	}
	public void setActiveCases(String activeCases) {
		this.activeCases = activeCases;
	}
	public String getLastUpdatedTime() {
		return lastUpdatedTime;
	}
	public void setLastUpdatedTime(String lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
	
	
	@Override
	public String toString() {
		return "StatsModel [state=" + state + ", confirmedCases=" + confirmedCases + ", recoveredCases="
				+ recoveredCases + ", Deaths=" + deaths + ", activeCases=" + activeCases + ", lastUpdatedTime="
				+ lastUpdatedTime + "]";
	}

}
