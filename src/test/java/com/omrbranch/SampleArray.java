package com.omrbranch;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SampleArray 
{
	 public  void parse1() throws IOException, ParseException {
			FileReader fileReader= new FileReader("C:\\Users\\D E L L\\eclipse-workspace\\cucumber\\ApiTesting\\src\\test\\resources\\Json\\Response2.json");
			
			JSONParser jsonParser=new JSONParser();
			Object object = jsonParser.parse(fileReader);
			JSONObject jsonObject=(JSONObject) object;
			System.out.println(jsonObject.get("page"));
			System.out.println(jsonObject.get("per_page"));
			System.out.println(jsonObject.get("total"));
			System.out.println(jsonObject.get("total_pages"));
Object object2 = jsonObject.get("data");
//
	JSONArray array = (JSONArray) object2;
         for (int i = 0; i < array.size(); i++) {
				   Object object3 = array.get(i);
			  JSONObject jsonObject2 = (JSONObject) object3;

				System.out.println(jsonObject2.get("id"));
				System.out.println(jsonObject2.get("flightName"));
				System.out.println(jsonObject2.get("Country"));
				System.out.println(jsonObject2.get("Destinations"));
				System.out.println(jsonObject2.get("URL"));

			}
	Object object3 = jsonObject.get("support");
			JSONObject jsonObject2 = (JSONObject) object3;
			System.out.println(jsonObject2.get("url"));
			System.out.println(jsonObject2.get("text"));

		
	}

	 public  void parse2() throws IOException, ParseException {
			FileReader fileReader= new FileReader("C:\\Users\\D E L L\\eclipse-workspace\\cucumber\\ApiTesting\\src\\test\\resources\\Json\\Response3.json");
			
			JSONParser jsonParser=new JSONParser();
			Object object = jsonParser.parse(fileReader);
			JSONObject jsonObject=(JSONObject) object;
			System.out.println(jsonObject.get("page"));
			System.out.println(jsonObject.get("per_page"));
			System.out.println(jsonObject.get("total"));
			System.out.println(jsonObject.get("total_pages"));
Object object2 = jsonObject.get("data");
//
	JSONArray array = (JSONArray) object2;
         for (int i = 0; i < array.size(); i++) {
				   Object object3 = array.get(i);
			  JSONObject jsonObject2 = (JSONObject) object3;

				System.out.println(jsonObject2.get("id"));
				System.out.println(jsonObject2.get("flightName"));
				System.out.println(jsonObject2.get("Country"));
				System.out.println(jsonObject2.get("Destinations"));
				System.out.println(jsonObject2.get("URL"));

			}
	Object object3 = jsonObject.get("support");
			JSONObject jsonObject2 = (JSONObject) object3;
			System.out.println(jsonObject2.get("url"));
			System.out.println(jsonObject2.get("text"));

		
	}
	 public static void main(String[] args) throws IOException, ParseException {
		 SampleArray array=new SampleArray();
		 array.parse1();
		 array.parse2();
		
	}
}
