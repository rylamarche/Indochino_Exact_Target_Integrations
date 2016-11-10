package com.indochino.csv;

public class ExactTargetSubscriber {
	public String email;
	public String signUpdate;
	
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String e){
		email = e;
	}
	
	public String getSignupDate(){
		return this.signUpdate;
	}
	
	public void setSignupDate(String d){
		signUpdate = d;
	}
}