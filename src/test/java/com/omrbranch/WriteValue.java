package com.omrbranch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omrbranch.pojo.EnterData;
import com.omrbranch.pojo.EnterSupport;
import com.omrbranch.pojo.Root;

public class WriteValue
{
   public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
	File file=new File("C:\\Users\\D E L L\\eclipse-workspace\\cucumber\\ApiTesting\\src\\test\\resources\\Json\\Test.json");
	ObjectMapper mapper=new ObjectMapper();
	ArrayList<EnterData> data=new ArrayList<EnterData>();
	EnterData d1=new EnterData(001,"Air India","India","86","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
	EnterData d2=new EnterData(002, "Air Canada", "Canada", "19", "\"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_Canada\"");
	data.add(d1);
	data.add(d2);
	EnterSupport support=new EnterSupport("https:\\/\\/omrbranch.com","For Joining Automation Course, Please Contact-Velmurugan 9944152058");
	Root root=new Root(1,3,15555,2244,data,support);
    mapper.writeValue(file, root);
    System.out.println("***********DONE*************");
   }
}