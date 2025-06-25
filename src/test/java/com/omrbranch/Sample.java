package com.omrbranch;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Sample
{
 public static void main(String[] args) throws IOException, ParseException {
	FileReader fileReader= new FileReader("C:\\Users\\D E L L\\eclipse-workspace\\cucumber\\ApiTesting\\src\\test\\resources\\Json\\Response.json");
	
	JSONParser jsonParser=new JSONParser();
	Object object = jsonParser.parse(fileReader);
	JSONObject jsonObject=(JSONObject) object;
	Object data= jsonObject.get("data");
	JSONObject jsonObject2= (JSONObject) data;
	Object id = jsonObject2.get("id");
	Object flightName = jsonObject2.get("flightName");
	Object Country = jsonObject2.get("Country");
	Object Destinations = jsonObject2.get("Destinations");
	Object Url = jsonObject2.get("URL");
	Object CreatedDate = jsonObject2.get("Created_Date");
	Object UpdatedDate = jsonObject2.get("Uptaded_Date");
	System.out.println("Id:"+id);
	System.out.println("Flight Name:"+flightName);
	System.out.println("Country:"+Country);
	System.out.println("Destinations:"+Destinations);
	System.out.println("URL:"+Url);
	System.out.println("Created Date:"+ CreatedDate);
	System.out.println("Updated Date"+ UpdatedDate);
	Object support = jsonObject.get("support");
	JSONObject jsonObject3=(JSONObject) support;
	Object url = jsonObject3.get("url");
	Object text = jsonObject3.get("text");
	System.out.println("URL:"+url);
	System.out.println("Text:"+text);	
}
}
