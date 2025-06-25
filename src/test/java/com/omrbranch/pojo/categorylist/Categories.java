package com.omrbranch.pojo.categorylist;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Categories 
{
	  public int id;
	    public String name;
	    public String image;
	    public int subcategory_count;
	    public ArrayList<ChildCatList> child_cat_list;
}
