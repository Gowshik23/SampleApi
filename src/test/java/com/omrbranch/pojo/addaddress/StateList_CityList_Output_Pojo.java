package com.omrbranch.pojo.addaddress;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 

public class StateList_CityList_Output_Pojo
{
	 public int status;
	    public String message;
	    public ArrayList<StateList_CityList> data;
}
