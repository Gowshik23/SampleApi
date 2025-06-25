package com.omrbranch.pojo.login;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostmanBasicAuthLogin_Output_Pojo
{
	private int status;
	private String message;
	private com.omrbranch.pojo.login.Data data;
	private String refer_msg;
	private int cart_count;
	private String role;
}
