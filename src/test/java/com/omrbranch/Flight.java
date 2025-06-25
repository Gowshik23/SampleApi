package com.omrbranch;

import org.testng.annotations.Test;

import com.omrbranch.baseclass.BaseClass;

import io.restassured.response.Response;

public class Flight extends BaseClass
{
	Object id;
	@Test(priority = 1)
	public void createFlight()
	{
		addHeader("content-Type","application/json");
		addPayload("{\r\n"
				+ "    \"flightName\": \"Qatat\",\r\n"
				+ "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": \"87\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"
				+ "}");
		Response response = addRequest("POST","https://www.omrbranch.com/api/flights");
		System.out.println(getStatusCode(response));
		System.out.println(getResBodyAsPrettyString(response));
		id = response.jsonPath().get("data.id");
		System.out.println(id);
		
	}
	
	@Test(priority = 2)
	public void getFlight()
	{
		addHeader("content-Type", "application/json");
		Response response = addRequest("GET", "https://www.omrbranch.com/api/flight/"+id+"");
		System.out.println(getStatusCode(response));
		System.out.println(getResBodyAsPrettyString(response));	
	}
	
	@Test(priority = 3)
	public void putFlight() 
	{
		addHeader("content-Type", "application/json");
		addPayload("{\r\n"
				+ "    \"flightName\": \"AirAsia\",\r\n"
				+ "    \"Country\": \"Austrila\",\r\n"
				+ "    \"Destinations\": 25,\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_Asia\"\r\n"
				+ "}");
		Response response = addRequest("PUT", "https://www.omrbranch.com/api/flight/"+id+"");
		System.out.println(getStatusCode(response));
		System.out.println(getResBodyAsPrettyString(response));
	}
	@Test(priority = 4)
	public void patchFlight() 
	{
		addHeader("content-Type", "application/json");
		addPayload("{\r\n"
				+ "    \"Destinations\": 77\r\n"
				+ "}");
		Response response = addRequest("PATCH", "https://www.omrbranch.com/api/flight/"+id+"");
		System.out.println(getStatusCode(response));
		System.out.println(getResBodyAsPrettyString(response));
	}
	@Test(priority = 5)
	public void deleteFlight() 
	{
		addHeader("content-Type", "application/json");
		Response response = addRequest("DELETE", "https://www.omrbranch.com/api/flight/"+id+"");
		System.out.println(getStatusCode(response));
	}
	@Test(priority = 6)
	public void listFlight() 
	{
		addHeader("content-Type", "application/json");
		Response response = addRequest("GET", "https://www.omrbranch.com/api/flights?page=1");
		System.out.println(getStatusCode(response));
		System.out.println(getResBodyAsPrettyString(response));
	}
}
