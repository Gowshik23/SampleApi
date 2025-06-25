package com.omrbranch;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omrbranch.pojo.Data;
import com.omrbranch.pojo.Datas;
import com.omrbranch.pojo.Datum;
import com.omrbranch.pojo.Flight2;
import com.omrbranch.pojo.Fligt;
import com.omrbranch.pojo.SingleFlight;
import com.omrbranch.pojo.Support;
import com.omrbranch.pojo.Supports;

public class Mapper 
{
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		File file=new File("C:\\Users\\D E L L\\eclipse-workspace\\cucumber\\ApiTesting\\src\\test\\resources\\Json\\Response2.json");
		File files=new File("C:\\Users\\D E L L\\eclipse-workspace\\cucumber\\ApiTesting\\src\\test\\resources\\Json\\Response3.json");
		File file1= new File("C:\\Users\\D E L L\\eclipse-workspace\\cucumber\\ApiTesting\\src\\test\\resources\\Json\\Response.json");
		ObjectMapper mapper=new ObjectMapper();
		SingleFlight singleFlight = mapper.readValue(file1, SingleFlight.class);
		System.out.println("SingleFlight");
		Datas datas = singleFlight.getData();
		System.out.println("DATA");
		System.out.println("Id : "+datas.getId());
		System.out.println("Flight Name : "+datas.getFlightName());
		System.out.println("Country : "+datas.getCountry());
		System.out.println("Destination: "+datas.getDestinations());
		System.out.println("Url: "+datas.getuRL());
		System.out.println("Created Date: "+datas.getCreated_Date());
		System.out.println("Updated Date: "+datas.getUpdated_Date());
		Support support2 = singleFlight.getSupport();
		System.out.println("SUPPORT");
		System.out.println("URL: "+support2.getUrl());
		System.out.println("Text: "+support2.getText());
		System.out.println("***************************************");
		Fligt value = mapper.readValue(file,Fligt.class);
		System.out.println("List of Flight1");
		System.out.println("Page: "+value.getPage());
		System.out.println("Per Page: "+value.getPer_page());
		System.out.println("Total: "+value.getTotal());
		System.out.println("Total Pages"+value.getTotal_pages());
		ArrayList<Data> data = value.getData();
		for (Data details : data) {
			System.out.println("DATA");
			System.out.println("ID: "+details.getId());
			System.out.println("Flight Name: "+details.getFlightName());
			System.out.println("Country: "+details.getCountry());
			System.out.println("Destination: "+details.getDestinations());
			System.out.println("URL: "+details.getuRL());
		}
		Support support = value.getSupport();
		System.out.println("SUPPORT");
		System.out.println("URL: "+support.getUrl());
		System.out.println("Text: "+support.getText());
          
		System.out.println("**************************************");
		System.out.println("List Of Flight2");
		Flight2 value2 = mapper.readValue(files, Flight2.class);
        System.out.println("Page: "+value2.getPage());
        System.out.println("Per Page: "+value2.getPer_page());
        System.out.println("Total: "+value2.getTotal());
	    System.out.println("Total pages: "+value2.getTotal_pages());
	    ArrayList<Datum> data2 = value2.getData();
	    for (Datum detail : data2) {
			System.out.println("DATA");
			System.out.println("ID: "+detail.getId());
			System.out.println("Flight Name: "+detail.getFlightName());
			System.out.println("Country: "+detail.getCountry());
			System.out.println("Destination: "+detail.getDestinations());
			System.out.println("URL: "+detail.getuRL());
		}
		Supports supports = value2.getSupport();
		System.out.println("SUPPORT");
		System.out.println("URL: "+supports.getUrl());
		System.out.println("Text: "+supports.getText());	
	}
}
