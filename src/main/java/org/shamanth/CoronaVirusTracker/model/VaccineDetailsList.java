package org.shamanth.CoronaVirusTracker.model;

import java.util.List;

public class VaccineDetailsList {

	public VaccineDetailsList() {

	}

	private List<VaccineDetailsModel> sessions;

	public List<VaccineDetailsModel> getSessions() {
		return sessions;
	}

	public void setSessions(List<VaccineDetailsModel> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "VaccineDetailsJsonList [sessions=" + sessions + ", getAllSessionsAvailable()=" + getSessions()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
