package com.omrbranch;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.omrbranch.baseclass.BaseClass;

import io.restassured.response.Response;

public class Samples extends BaseClass
{
	@Test
	public void login()
	{
		addHeader("accept", "application/json");
		addBasicAuth("gowshik927@gmail.com", "Greens@22");
		Response response = addRequest("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");
		 int code = getStatusCode(response);
		 System.out.println(code);
		 Assert.assertEquals(code, 200,"Verified code");
		 System.out.println(getResBodyAsPrettyString(response));
}
}
