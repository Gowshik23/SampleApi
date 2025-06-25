
package com.omrbranch.pojo.getCartItem;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetCartItem_OutPut_Pojo 
{
	public int status;
    public String message;
    public String currency;
    public ArrayList<GetCart> data;
    public int cart_count;
    public String payment;
    public String wallet;
    public String total_amount;
    public String coupon_discount;
    public String shipping_fee;
    public String grand_total;
    public String savings;
    public int credit_usage;
    public String credits_used;
    public String payment_key;
    public Address address;
}
