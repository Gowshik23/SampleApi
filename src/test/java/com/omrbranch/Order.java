package com.omrbranch;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.pojo.addToCart.AddToCart_Input_Pojo;
import com.omrbranch.pojo.addaddress.AddUserAddress_Input_Pojo;
import com.omrbranch.pojo.addaddress.AddUserAddress_Output_Pojo;
import com.omrbranch.pojo.addaddress.CityList_Input_Pojo;
import com.omrbranch.pojo.addaddress.StateList_CityList_Output_Pojo;
import com.omrbranch.pojo.cancelorder.CancelOrder_Input_Pojo;
import com.omrbranch.pojo.categorylist.Categories;
import com.omrbranch.pojo.categorylist.CategoryList_Output_pojo;
import com.omrbranch.pojo.categorylist.ChildCatList;
import com.omrbranch.pojo.createorder.CreateOrder_Input_pojo;
import com.omrbranch.pojo.createorder.CreateOrder_Output_Pojo;
import com.omrbranch.pojo.getCartItem.GetCart;
import com.omrbranch.pojo.getCartItem.GetCartItem_OutPut_Pojo;
import com.omrbranch.pojo.login.PostmanBasicAuthLogin_Output_Pojo;
import com.omrbranch.pojo.productlist.ProductList;
import com.omrbranch.pojo.productlist.ProductList_Input_Pojo;
import com.omrbranch.pojo.productlist.ProductList_Output_Pojo;
import com.omrbranch.pojo.productlist.Variation;
import com.omrbranch.pojo.setaddress.SetAddress_Input_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Order extends BaseClass
{
	String logtoken;
	String CategoryId;
	String veriationId;
	String prod_id;
	String CartId;
	String address_id;
	int cityId;
	int stateIdNum;
	String stateIdText;
	String OrderId;

	@Test(priority = 0)
	public void login() 
	{
		addHeader("accept", "application/json");
		addBasicAuth("gowshik927@gmail.com", "Greens@22");
		Response response = addRequest("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");
		 int code = getStatusCode(response);
		 System.out.println(code);
		 Assert.assertEquals(code, 200,"Verified code");
		 PostmanBasicAuthLogin_Output_Pojo pojo = response.as(PostmanBasicAuthLogin_Output_Pojo.class);
		  logtoken = pojo.getData().getLogtoken();
    }
	
	@Test(priority = 1)
	public void categoryList() 
	{
		addHeader("accept", "application/json");
		Response response = addRequest("GET", "https://omrbranch.com/api/categoryList");
		 int code = getStatusCode(response);
		 System.out.println(code);
		 Assert.assertEquals(code, 200,"Verified code");
		 CategoryList_Output_pojo output_pojo=response.as(CategoryList_Output_pojo.class);
		 ArrayList<Categories> data = output_pojo.getData();
		 for (Categories categories : data) 
		 {
			 ArrayList<ChildCatList> child_cat_list = categories.getChild_cat_list();
			 for (ChildCatList ChildCatList : child_cat_list) 
		    {
		        String name = ChildCatList.getName();
		    if(name.equals("Fruit & Nuts"))
		    {
		    	int id = ChildCatList.getId();
		    	System.out.println("Category id:"+id);
		    	 CategoryId = String.valueOf(id);
		    	 break;
		    }
		    }
		}
	}
	
	@Test(priority = 2)
	public void productList() 
	{
		List<Header> header=new ArrayList<>(); 
		   Header h1=new Header("accept","application/json");
		   Header h3=new Header("Content-Type", "application/json");
		   header.add(h1);
		   header.add(h3);
		   Headers headers=new Headers(header);
		   addHeaders(headers);
		   ProductList_Input_Pojo input_Pojo=new ProductList_Input_Pojo(CategoryId,"0");
		   addPayload(input_Pojo);
		   Response response = addRequest("POST","https://omrbranch.com/api/productList");
		   int code = getStatusCode(response);
			 System.out.println(code);
			 Assert.assertEquals(code, 200,"Verified code");
		   ProductList_Output_Pojo output_Pojo=	 response.as(ProductList_Output_Pojo.class);
		   ArrayList<ProductList> data = output_Pojo.getData();
		   for (ProductList productList : data)
		   {
			   String name = productList.getName();
			   if(name.equals("Dry Fruit Hub Brazil Nuts"))
			   {
			   int product_id = productList.getId();
				 System.out.println("Product Id:"+product_id);
				  prod_id = String.valueOf(product_id);
			   }
			 ArrayList<Variation> variations = productList.getVariations();
			 for (Variation variation : variations)
		   {
				 int id = variation.getProduct_id();
				 String valueOf = String.valueOf(id);
				 String specifications = variation.getSpecifications();
				 if(valueOf.equals(prod_id)&&specifications.contentEquals("1 kg")) 
				 {
				int Veriatoin_id = variation.getId();
				System.out.println("Variation Id:"+Veriatoin_id);
				 veriationId = String.valueOf(Veriatoin_id);	
				 }
				 break;
		  }
		   }
	}
	@Test(priority = 3)
	public void addToCart() 
	{

		List<Header> header=new ArrayList<>(); 
		   Header h1=new Header("accept","application/json");
		   Header h2= new Header("Authorization","Bearer "+ logtoken);
		   Header h3=new Header("Content-Type", "application/json");
		   header.add(h1);
		   header.add(h2);
		   header.add(h3);
		   Headers headers=new Headers(header);
		   addHeaders(headers);
		   AddToCart_Input_Pojo input_Pojo=new AddToCart_Input_Pojo(prod_id, veriationId, "plus");
		   addPayload(input_Pojo);
		   Response response = addRequest("POST", "https://omrbranch.com/api/addToCart");
		   int code = getStatusCode(response);
			 System.out.println(code);
			 Assert.assertEquals(code, 200,"Verified code");
	}
	@Test(priority = 4)
	public void getCartItem()
	{
		List<Header> header=new ArrayList<>(); 
		   Header h1=new Header("accept","application/json");
		   Header h2= new Header("Authorization","Bearer "+ logtoken);
		   header.add(h1);
		   header.add(h2);
		   Headers headers=new Headers(header);
		   addHeaders(headers);
		   Response response = addRequest("GET", "https://omrbranch.com/api/getCartItems");
		   int code = getStatusCode(response);
			 System.out.println(code);
			 Assert.assertEquals(code, 200,"Verified code");
		 GetCartItem_OutPut_Pojo outPut_Pojo=response.as(GetCartItem_OutPut_Pojo.class);
		 ArrayList<GetCart> list = outPut_Pojo.getData();
		 for (GetCart getCart : list) 
		 {
		   int cart_id = getCart.getCart_id();
		   System.out.println("Cart Id:"+cart_id);
		    CartId = String.valueOf(cart_id);
		 }
	 }
	@Test(priority = 6)
	public void getCityList() {
		// 1. Headers
		List<Header> lstHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h3 = new Header("Content-Type", "application/json");
		lstHeader.add(h1);
		lstHeader.add(h3);
		Headers headers = new Headers(lstHeader);

		addHeaders(headers);

		// 2. payload
		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(stateIdText);
		addPayload(cityList_Input_Pojo);

		// 3. Req
		Response response = addRequest("POST", "https://omrbranch.com/api/cityList");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status Code");
		StateList_CityList_Output_Pojo stateList_CityList_Output_Pojo = response.as(StateList_CityList_Output_Pojo.class);
		ArrayList<com.omrbranch.pojo.addaddress.StateList_CityList> cityList = stateList_CityList_Output_Pojo.getData();

		// Find the city id of Yercaud
		for (com.omrbranch.pojo.addaddress.StateList_CityList eachCityList : cityList) {
			String cityname = eachCityList.getName();
			if (cityname.equals("Yercaud")) {
				cityId = eachCityList.getId();
				System.out.println("City Id:"+cityId);
				break;
			}
		}

	}

	@Test(priority = 5)
	public void getStateList() 
	{
//1. Header
		addHeader("accept", "application/json");

		// 2. Add Req type
		Response response = addRequest("GET", "https://omrbranch.com/api/stateList");

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status Code");

		StateList_CityList_Output_Pojo stateList_Output_Pojo = response.as(StateList_CityList_Output_Pojo.class);

		// Find the state id of TN
		ArrayList<com.omrbranch.pojo.addaddress.StateList_CityList> stateList = stateList_Output_Pojo.getData();
		for (com.omrbranch.pojo.addaddress.StateList_CityList eachStateList : stateList) {
			String stateName = eachStateList.getName();
			if (stateName.equals("Tamil Nadu")) {
				stateIdNum = eachStateList.getId();
				System.out.println("State Id:"+stateIdNum);
				stateIdText = String.valueOf(stateIdNum);
				break;
			}
		}

	}
	@Test(priority = 7)
	public void addAddress() 
	{
		List<Header> header=new ArrayList<>(); 
		   Header h1=new Header("accept","application/json");
		   Header h2= new Header("Authorization","Bearer "+logtoken);
		   Header h3=new Header("Content-Type", "application/json");
		   header.add(h1);
		   header.add(h2);
		   header.add(h3);
		   Headers headers=new Headers(header);
		   addHeaders(headers);
		   AddUserAddress_Input_Pojo address=new AddUserAddress_Input_Pojo("Gowshik", "A S", "9566917127", "Amman Nager", 33, 3378, 101, "600035", "Sri Vilas", "home");
		   addPayload(address);
		   Response response = addRequest("POST","https://omrbranch.com/api/addUserAddress");
		   int code = getStatusCode(response);
			 System.out.println(code);
			 Assert.assertEquals(code, 200,"Verified code");
			 AddUserAddress_Output_Pojo pojo = response.as(AddUserAddress_Output_Pojo.class);
			 int  addressid = pojo.getAddress_id();
			 System.out.println("Address Id:"+addressid);
			 address_id=String.valueOf(addressid);
	}
	@Test(priority = 8)
	public void setAddress_id() 
	{
		List<Header> header=new ArrayList<>(); 
		   Header h1=new Header("accept","application/json");
		   Header h2= new Header("Authorization","Bearer "+logtoken);
		   Header h3=new Header("Content-Type", "application/json");
		   header.add(h1);
		   header.add(h2);
		   header.add(h3);
		   Headers headers=new Headers(header);
		   addHeaders(headers);
		   SetAddress_Input_Pojo input_Pojo=new SetAddress_Input_Pojo(address_id, CartId);
		   addPayload(input_Pojo);
		   Response response = addRequest("POST", "https://omrbranch.com/api/setAddress");
		   int code = getStatusCode(response);
			 System.out.println(code);
			 Assert.assertEquals(code, 200,"Verified code");
	}
	@Test(priority = 9)
	public void createOrder() 
	{
		List<Header> header=new ArrayList<>(); 
		   Header h1=new Header("accept","application/json");
		   Header h2= new Header("Authorization","Bearer "+logtoken);
		   Header h3=new Header("Content-Type", "application/json");
		   header.add(h1);
		   header.add(h2);
		   header.add(h3);
		   Headers headers=new Headers(header);
		   addHeaders(headers);
		   CreateOrder_Input_pojo input_pojo=new CreateOrder_Input_pojo("debit_card", "5555555555552222", "visa", "2028","03","123");
		   addPayload(input_pojo);
		   Response response = addRequest("POST", "https://omrbranch.com/api/createOrder");
		   int code = getStatusCode(response);
			 System.out.println(code);
			 Assert.assertEquals(code, 200,"Verified code");
			 CreateOrder_Output_Pojo output_Pojo=response.as(CreateOrder_Output_Pojo.class);
			 int order_id = output_Pojo.getOrder_id();
			 System.out.println("Order Id:"+order_id);
			  OrderId = String.valueOf(order_id);
	}
	@Test(priority = 10)
	public void cancelOrder() 
	{
		List<Header> header=new ArrayList<>(); 
		   Header h1=new Header("accept","application/json");
		   Header h2= new Header("Authorization","Bearer "+logtoken);
		   Header h3=new Header("Content-Type", "application/json");
		   header.add(h1);
		   header.add(h2);
		   header.add(h3);
		   Headers headers=new Headers(header);
		   addHeaders(headers);
		   CancelOrder_Input_Pojo input_Pojo=new CancelOrder_Input_Pojo(OrderId);
		   addPayload(input_Pojo);
		   Response response = addRequest("POST","https://omrbranch.com/api/cancelOrder");
		   int code = getStatusCode(response);
			 System.out.println(code);
			 Assert.assertEquals(code, 200,"Verified code");
	}
}
