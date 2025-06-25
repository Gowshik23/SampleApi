package com.omrbranch.pojo.createorder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrder_Input_pojo 
{
	 public String payment_method;
	    public String card_no;
	    public String card_type;
	    public String year;
	    public String month;
	    public String cvv;
}
