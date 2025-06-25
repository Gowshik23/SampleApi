package com.omrbranch.pojo.getallorder;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetAllOrder_Output_Pojo 
{
	public int status;
    public String message;
    public String currency;
    public ArrayList<GetALlOrder> data;
}
