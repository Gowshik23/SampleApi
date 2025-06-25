package com.omrbranch;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.omrbranch.baseclass.BaseClass;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Simples extends BaseClass
{
	 String jsontoken;
	 String adressid;
		@Test(priority = 1)
		public void login()
		{
			addHeader("accept", "application/json");
			addBasicAuth("gowshik927@gmail.com", "Greens@22");
			Response response = addRequest("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");
			 int code = getStatusCode(response);
			 System.out.println(code);
			 Assert.assertEquals(code, 200,"Verified code");
			 Object jsonToken = response.jsonPath().get("data.logtoken");
			  jsontoken = (String) jsonToken;
			  
        }
		@Test(priority = 2)
		public void addAddr() 
		{
		   List<Header> header=new ArrayList<>(); 
		   Header h1=new Header("accept","application/json");
		   Header h2= new Header("Authorization","Bearer "+ jsontoken);
		   Header h3=new Header("Content-Type", "application/json");
		   header.add(h1);
		   header.add(h2);
		   header.add(h3);
		   Headers headers=new Headers(header);
		   addHeaders(headers);
		   addPayload("{\r\n"
		   		+ "  \"first_name\": \"Gowshik\",\r\n"
		   		+ "  \"last_name\": \"A S\",\r\n"
		   		+ "  \"mobile\": \"9566917127\",\r\n"
		   		+ "  \"apartment\": \"logistics\",\r\n"
		   		+ "  \"state\": 33,\r\n"
		   		+ "  \"city\": 3378,\r\n"
		   		+ "  \"country\": 101,\r\n"
		   		+ "  \"zipcode\": \"202020\",\r\n"
		   		+ "  \"address\": \"64/63 partap nagar\",\r\n"
		   		+ "  \"address_type\": \"home\"\r\n"
		   		+ "}");
		   Response response = addRequest("POST","https://omrbranch.com/api/addUserAddress");
		   int code = getStatusCode(response);
			 System.out.println(code);
			 Assert.assertEquals(code, 200,"Verified code");
			 System.out.println(getResBodyAsPrettyString(response)); 
			 Object object = response.jsonPath().getString("address_id");
			  adressid=(String) object;
			  System.out.println(object);
	 	}
		@Test(priority = 3)
		public void updateAddress() 
		{
			  List<Header> header=new ArrayList<>(); 
			   Header h1=new Header("accept","application/json");
			   Header h2= new Header("Authorization","Bearer "+ jsontoken);
			   Header h3=new Header("Content-Type", "application/json");
			   header.add(h1);
			   header.add(h2);
			   header.add(h3);
			   Headers headers=new Headers(header);
			   addHeaders(headers);
			   addPayload("{\r\n"
			   		+ "  \"address_id\": \""+adressid+"\",\r\n"
			   		+ "  \"first_name\": \"Gowshik\",\r\n"
			   		+ "  \"last_name\": \"A S\",\r\n"
			   		+ "  \"mobile\": \"9566917127\",\r\n"
			   		+ "  \"apartment\": \"ammannager\",\r\n"
			   		+ "  \"state\": 33,\r\n"
			   		+ "  \"city\": 3378,\r\n"
			   		+ "  \"country\": 101,\r\n"
			   		+ "  \"zipcode\": \"202020\",\r\n"
			   		+ "  \"address\": \"64/63 partap nagar\",\r\n"
			   		+ "  \"address_type\": \"home\"\r\n"
			   		+ "}");
			   Response response = addRequest("PUT","https://omrbranch.com/api/updateUserAddress");
			   int code = getStatusCode(response);
				 System.out.println(code);
				 Assert.assertEquals(code, 200,"Verified code");
				 System.out.println(getResBodyAsPrettyString(response));	
		}
		@Test(priority = 4)
		public void deleteAddress() 
		{
			List<Header> header=new ArrayList<>(); 
			   Header h1=new Header("accept","application/json");
			   Header h2= new Header("Authorization","Bearer "+ jsontoken);
			   Header h3=new Header("Content-Type", "application/json");
			   header.add(h1);
			   header.add(h2);
			   header.add(h3);
			   Headers headers=new Headers(header);
			   addHeaders(headers);
			   addPayload("{\r\n"
			   		+ "  \"address_id\": \""+adressid+"\"\r\n"
			   		+ "}");
			   Response response = addRequest("DELETE","https://omrbranch.com/api/deleteAddress");
			   int code = getStatusCode(response);
				 System.out.println(code);
				 Assert.assertEquals(code, 200,"Verified code");
				 System.out.println(getResBodyAsPrettyString(response));	
		}
}
