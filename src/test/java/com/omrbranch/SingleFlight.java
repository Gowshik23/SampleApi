package com.omrbranch;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SingleFlight {
	RequestSpecification requestSpecification;

	public void createFlight() {

		 requestSpecification = RestAssured.given();
		 requestSpecification = requestSpecification.header("content-Type","application/json");
	     requestSpecification.body("{\r\n"
	     		+ "    \"flightName\": \"Discool\",\r\n"
	     		+ "    \"Country\": \"Austrila\",\r\n"
	     		+ "    \"Destinations\": \"99\",\r\n"
	     		+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Qatar\"\r\n"
	     		+ "}");
	     Response post = requestSpecification.post("https://www.omrbranch.com/api/flights");
	     int statusCode = post.getStatusCode();
	     System.out.println(statusCode);
	     String prettyString = post.asPrettyString();
	     System.out.println(prettyString);
	     }
	public void getfligt() {
		
		 requestSpecification = RestAssured.given();
		 requestSpecification = requestSpecification.header("content-Type","application/json");
         Response get = requestSpecification.get("https://www.omrbranch.com/api/flight/49989");
        System.out.println(get.getStatusCode());
        System.out.println(get.asPrettyString());
         

	}
	public static void main(String[] args) {
		SingleFlight flight=new SingleFlight();
		flight.createFlight();
		flight.getfligt();
	}
}
