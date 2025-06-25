package com.omrbranch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.pojo.login.PostmanBasicAuthLogin_Output_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ChangeProfilePic extends BaseClass
{
	String logtoken;
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
	@Test(priority = 1)
	public void ChangeProfile() 
	{
		List<Header> header=new ArrayList<>(); 
		   Header h1=new Header("accept","application/json");
		   Header h2= new Header("Authorization","Bearer "+ logtoken);
		   Header h3=new Header("Content-Type", "multipart/form-data");
		   header.add(h1);
		   header.add(h2);
		   header.add(h3);
		   Headers headers=new Headers(header);
		   addHeaders(headers);
		   addPayload("profile_picture", new File(System.getProperty("user.dir")+"\\src\\test\\resources\\WhatsApp Image 2025-06-16 at 23.13.07_e8c1b64c.jpg") );
		   Response response = addRequest("POST", "https://omrbranch.com/api/changeProfilePic");
		   int statusCode = getStatusCode(response);
		   System.out.println(statusCode);
		   Assert.assertEquals(statusCode, 200,"Verified code");
	}
}
