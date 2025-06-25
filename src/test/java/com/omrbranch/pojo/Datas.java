package com.omrbranch.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Datas {

    private int id;
    private String flightName;
    @JsonProperty("Country") 
    private String country;
    @JsonProperty("Destinations") 
    private String destinations;
    @JsonProperty("URL") 
    private String uRL;
    @JsonProperty("Created_Date") 
    private String created_Date;
    @JsonProperty("Updated_Date") 
    private String updated_Date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDestinations() {
		return destinations;
	}
	public void setDestinations(String destinations) {
		this.destinations = destinations;
	}
	public String getuRL() {
		return uRL;
	}
	public void setuRL(String uRL) {
		this.uRL = uRL;
	}
	public String getCreated_Date() {
		return created_Date;
	}
	public void setCreated_Date(String created_Date) {
		this.created_Date = created_Date;
	}
	public String getUpdated_Date() {
		return updated_Date;
	}
	public void setUpdated_Date(String updated_Date) {
		this.updated_Date = updated_Date;
	}
}
