package com.omrbranch.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class EnterData
{
//		public EnterData(int id, String flightName, String country, String destinations, String uRL) {
//		this.id = id;
//		this.flightName = flightName;
//		this.country = country;
//		this.destinations = destinations;
//		this.uRL = uRL;
//	}
			private int id;
		    private String flightName;
		    @JsonProperty("Country") 
		    private String country;
		    @JsonProperty("Destinations") 
		    private String destinations;
		    @JsonProperty("URL")
		    private String uRL;
//			public int getId() {
//				return id;
//			}
//			public void setId(int id) {
//				this.id = id;
//			}
//			public String getFlightName() {
//				return flightName;
//			}
//			public void setFlightName(String flightName) {
//				this.flightName = flightName;
//			}
//			public String getCountry() {
//				return country;
//			}
//			public void setCountry(String country) {
//				this.country = country;
//			}
//			public String getDestinations() {
//				return destinations;
//			}
//			public void setDestinations(String destinations) {
//				this.destinations = destinations;
//			}
//			public String getuRL() {
//				return uRL;
//			}
//			public void setuRL(String uRL) {
//				this.uRL = uRL;
//			}
}
