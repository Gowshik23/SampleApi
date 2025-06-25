package com.omrbranch.pojo.createorder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Acountry 
{
	public int id;
    public String code;
    public String name;
    public int phonecode;
    public String currency_name;
    public String currency_symbol;
    public String currency_code;
    public String status;
}
