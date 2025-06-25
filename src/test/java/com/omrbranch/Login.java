package com.omrbranch;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.pojo.login.PostmanBasicAuthLogin_Output_Pojo;

import io.restassured.response.Response;

public class Login extends BaseClass
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
}
