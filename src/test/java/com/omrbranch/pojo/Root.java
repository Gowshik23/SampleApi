package com.omrbranch.pojo;

import java.util.ArrayList;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Root
{
	
//	public Root(int page, int per_page, int total, int total_pages, ArrayList<EnterData> data, EnterSupport support) {
//		super();
//		this.page = page;
//		this.per_page = per_page;
//		this.total = total;
//		this.total_pages = total_pages;
//		this.data = data;
//		this.support = support;
//	}
//	public int getPage() {
//		return page;
//	}
//	public void setPage(int page) {
//		this.page = page;
//	}
//	public int getPer_page() {
//		return per_page;
//	}
//	public void setPer_page(int per_page) {
//		this.per_page = per_page;
//	}
//	public int getTotal() {
//		return total;
//	}
//	public void setTotal(int total) {
//		this.total = total;
//	}
//	public int getTotal_pages() {
//		return total_pages;
//	}
//	public void setTotal_pages(int total_pages) {
//		this.total_pages = total_pages;
//	}
//	public ArrayList<EnterData> getData() {
//		return data;
//	}
//	public void setData(ArrayList<EnterData> data) {
//		this.data = data;
//	}
//	public EnterSupport getSupport() {
//		return support;
//	}
//	public void setSupport(EnterSupport support) {
//		this.support = support;
//	}
	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private ArrayList<EnterData> data;
	private EnterSupport support;
}
