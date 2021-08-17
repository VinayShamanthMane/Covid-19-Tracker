package org.shamanth.CoronaVirusTracker.model;

import java.util.List;

public class VaccineDetailsModel {

	private String center_id;
	private String name;
	private String address;
	private String state_name;
	private String district_name;
	private String pincode;
	private String from;
	private String to;
	private String date;
	private String available_capacity;
	private String available_capacity_dose1;
	private String available_capacity_dose2;
	private String fee;
	private String min_age_limit;
	private String vaccine;
	private List<String> slots;

	public VaccineDetailsModel(String center_id, String name, String address, String state_name, String district_name,
			String pincode, String from, String to, String date, String available_capacity,
			String available_capacity_dose1, String available_capacity_dose2, String fee, String min_age_limit,
			String vaccine, List<String> slots) {
		this.center_id = center_id;
		this.name = name;
		this.address = address;
		this.state_name = state_name;
		this.district_name = district_name;
		this.pincode = pincode;
		this.from = from;
		this.to = to;
		this.date = date;
		this.available_capacity = available_capacity;
		this.available_capacity_dose1 = available_capacity_dose1;
		this.available_capacity_dose2 = available_capacity_dose2;
		this.fee = fee;
		this.min_age_limit = min_age_limit;
		this.vaccine = vaccine;
		this.slots = slots;
	}

	public VaccineDetailsModel() {

	}

	public String getCenter_id() {
		return center_id;
	}

	public void setCenter_id(String center_id) {
		this.center_id = center_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAvailable_capacity() {
		return available_capacity;
	}

	public void setAvailable_capacity(String available_capacity) {
		this.available_capacity = available_capacity;
	}

	public String getAvailable_capacity_dose1() {
		return available_capacity_dose1;
	}

	public void setAvailable_capacity_dose1(String available_capacity_dose1) {
		this.available_capacity_dose1 = available_capacity_dose1;
	}

	public String getAvailable_capacity_dose2() {
		return available_capacity_dose2;
	}

	public void setAvailable_capacity_dose2(String available_capacity_dose2) {
		this.available_capacity_dose2 = available_capacity_dose2;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getMin_age_limit() {
		return min_age_limit;
	}

	public void setMin_age_limit(String min_age_limit) {
		this.min_age_limit = min_age_limit;
	}

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	public List<String> getSlots() {
		return slots;
	}

	public void setSlots(List<String> slots) {
		this.slots = slots;
	}

}
