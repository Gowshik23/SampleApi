package com.omrbranch.pojo.categorylist;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildCatList 
{
    public int id;
    public String category_code;
    public String name;
    public String image;
    public String banner;
    public int parent_id;
    public String description;
    public String status;
    public String created_at;
    public String updated_at;
    public ArrayList<Object> child_cat_list;

}
