package com.omrbranch.pojo.categorylist;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryList_Output_pojo
{
	 public int status;
	    public String message;
	    public ArrayList<Categories> data;
}
