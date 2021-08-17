package org.shamanth.CoronaVirusTracker.model;

public class VaccineFinderDetails {

	private String pincode;

	private String date;

	@Override
	public String toString() {
		return "VaccineDetailsModel [pincode=" + pincode + ", date=" + date + "]";
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
