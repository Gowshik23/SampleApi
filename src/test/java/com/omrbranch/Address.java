package com.omrbranch;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.pojo.addaddress.AddUserAddress_Input_Pojo;
import com.omrbranch.pojo.addaddress.AddUserAddress_Output_Pojo;
import com.omrbranch.pojo.addaddress.CityList_Input_Pojo;
import com.omrbranch.pojo.addaddress.DeleteUserAddress_Input_Pojo;
import com.omrbranch.pojo.addaddress.StateList_CityList_Output_Pojo;
import com.omrbranch.pojo.addaddress.UpdateUserAddress_Input_Pojo;
import com.omrbranch.pojo.login.PostmanBasicAuthLogin_Output_Pojo;
import com.omrbranch.pojo.searchproduct.SearchProduct;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Address extends BaseClass
{
	String logtoken ;
	String address_id;
	int cityId;
	int stateIdNum;
	String stateIdText;

	@Test(priority = 2)
	public void getCityList() {
		// 1. Headers
		List<Header> lstHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h3 = new Header("Content-Type", "application/json");
		lstHeader.add(h1);
		lstHeader.add(h3);
		Headers headers = new Headers(lstHeader);

		addHeaders(headers);

		// 2. payload
		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(stateIdText);
		addPayload(cityList_Input_Pojo);

		// 3. Req
		Response response = addRequest("POST", "https://omrbranch.com/api/cityList");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status Code");

		StateList_CityList_Output_Pojo stateList_CityList_Output_Pojo = response
				.as(StateList_CityList_Output_Pojo.class);
		ArrayList<com.omrbranch.pojo.addaddress.StateList_CityList> cityList = stateList_CityList_Output_Pojo.getData();

		// Find the city id of Yercaud
		for (com.omrbranch.pojo.addaddress.StateList_CityList eachCityList : cityList) {
			String cityname = eachCityList.getName();
			if (cityname.equals("Yercaud")) {
				cityId = eachCityList.getId();
				System.out.println(cityId);
				break;
			}
		}

	}

	@Test(priority = 1)
	public <StateList_CityList> void getStateList() {
//1. Header
		addHeader("accept", "application/json");

		// 2. Add Req type
		Response response = addRequest("GET", "https://omrbranch.com/api/stateList");

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status Code");

		StateList_CityList_Output_Pojo stateList_Output_Pojo = response.as(StateList_CityList_Output_Pojo.class);

		// Find the state id of TN
		ArrayList<com.omrbranch.pojo.addaddress.StateList_CityList> stateList = stateList_Output_Pojo.getData();
		for (com.omrbranch.pojo.addaddress.StateList_CityList eachStateList : stateList) {
			String stateName = eachStateList.getName();
			if (stateName.equals("Tamil Nadu")) {
				stateIdNum = eachStateList.getId();
				System.out.println(stateIdNum);
				stateIdText = String.valueOf(stateIdNum);
				break;
			}
		}

	}

	@Test(priority = 0)
	public void login() 
	{
		addHeader("accept", "application/json");
		addBasicAuth("gowshik927@gmail.com", "Greens@22");
		Response response = addRequest("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");
		 int code = getStatusCode(response);
		 System.out.println(code);
		 Assert.assertEquals(code, 200,"Verified code");
		 PostmanBasicAuthLogin_Output_Pojo pojo = response.as(PostmanBasicAuthLogin_Output_Pojo.class);
		  logtoken = pojo.getData().getLogtoken();
    }
	
	@Test(priority = 2)
	public void addAddress() 
	{
		List<Header> header=new ArrayList<>(); 
		   Header h1=new Header("accept","application/json");
		   Header h2= new Header("Authorization","Bearer "+logtoken);
		   Header h3=new Header("Content-Type", "application/json");
		   header.add(h1);
		   header.add(h2);
		   header.add(h3);
		   Headers headers=new Headers(header);
		   addHeaders(headers);
		   AddUserAddress_Input_Pojo address=new AddUserAddress_Input_Pojo("Gowshik", "A S", "9566917127", "Amman Nager", 33, 3378, 101, "600035", "Sri Vilas", "home");
		   addPayload(address);
		   Response response = addRequest("POST","https://omrbranch.com/api/addUserAddress");
		   int code = getStatusCode(response);
			 System.out.println(code);
			 Assert.assertEquals(code, 200,"Verified code");
			 System.out.println(getResBodyAsPrettyString(response));
			 AddUserAddress_Output_Pojo pojo = response.as(AddUserAddress_Output_Pojo.class);
			 int  addressid = pojo.getAddress_id();
			 address_id=String.valueOf(addressid);
	}
	
	@Test(priority = 3)
	
	public void updateAddress() 
	{
		List<Header> header=new ArrayList<>(); 
		   Header h1=new Header("accept","application/json");
		   Header h2= new Header("Authorization","Bearer "+logtoken);
		   Header h3=new Header("Content-Type", "application/json");
		   header.add(h1);
		   header.add(h2);
		   header.add(h3);
		   Headers headers=new Headers(header);
		   addHeaders(headers);
		   UpdateUserAddress_Input_Pojo update=new UpdateUserAddress_Input_Pojo(address_id, "Gowshik", "A S", "9566917127", "Blue State Apparment", 33, 3378, 101, "641035", "Sri Vilas", "home");
           addPayload(update);
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
		   Header h2= new Header("Authorization","Bearer "+ logtoken);
		   Header h3=new Header("Content-Type", "application/json");
		   header.add(h1);
		   header.add(h2);
		   header.add(h3);
		   Headers headers=new Headers(header);
		   addHeaders(headers);
		   DeleteUserAddress_Input_Pojo delete=new DeleteUserAddress_Input_Pojo(address_id);
		   addPayload(delete);
		   Response response = addRequest("DELETE","https://omrbranch.com/api/deleteAddress");
		   int code = getStatusCode(response);
			 System.out.println(code);
			 Assert.assertEquals(code, 200,"Verified code");
			 System.out.println(getResBodyAsPrettyString(response));
	}
	
	@Test(priority = 5)
	public void search() 
	{
		List<Header> header=new ArrayList<>(); 
		   Header h1=new Header("accept","application/json");
		   Header h3=new Header("Content-Type", "application/json");
		   header.add(h1);
		   header.add(h3);
		   Headers headers=new Headers(header);
		   addHeaders(headers);
		   SearchProduct P=new SearchProduct("Nuts");
		   addPayload(P);
		   Response response = addRequest("POST","https://omrbranch.com/api/searchProduct");
		   int code = getStatusCode(response);
			 System.out.println(code);
			 Assert.assertEquals(code, 200,"Verified code");
			 System.out.println(getResBodyAsPrettyString(response));
	}
}
