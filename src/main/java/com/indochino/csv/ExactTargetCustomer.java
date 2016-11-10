package com.indochino.csv;

public class ExactTargetCustomer {
	public String customer_id;
	public String customer_email;
	public String customer_name;
	public String is_active;
	public String is_fraudster;
	public String is_VIP;
	public String subscribed_to_newsletter;
	public String registration_date;
	public String city;
	public String state;
	public String zip;
	public String country;
	public String address_order_id;
	
	public String getCustomerID(){
		return this.customer_id;
	}
	
	public void setCustomerID(String ID){
		customer_id = ID;
	}
	
	public String getCustomerEmail(){
		return this.customer_email;
	}
	
	public void setCustomerEmail(String e){
		customer_email = e;
	}
	
	public String getCustomerName(){
		return this.customer_name;
	}
	
	public void setCustomerName(String n){
		customer_name = n;
	}
	
	public String getIsActive(){
		return this.is_active;
	}
	
	public void setIsActive(String d){
		is_active= d;
	}
	
	public String getIsFraudster(){
		return this.is_fraudster;
	}
	
	public void setIsFraudster(String f){
		is_fraudster = f;
	}
	
	public String getIsVIP(){
		return this.is_VIP;
	}
	
	public void setIsVIP(String v){
		is_VIP = v;
	}
	
	public String getSubscribedToNewsletter(){
		return this.subscribed_to_newsletter;
	}
	
	public void setSubscribedToNewsletter(String sn){
		subscribed_to_newsletter = sn;
	}
	
	public String getRegistrationDate(){
		return this.registration_date;
	}
	
	public void setRegistrationDate(String r){
		registration_date = r;
	}
	
	public String getCity(){
		return this.city;
	}
	
	public void setCity(String c){
		city = c;
	}
	
	public String getState(){
		return this.state;
	}
	
	public void setState(String s){
		state = s;
	}
	
	public String getZip(){
		return this.zip;
	}
	
	public void setZip(String z){
		zip = z;
	}
	
	public String getCountry(){
		return this.country;
	}
	
	public void setCountry(String co){
		country = co;
	}
	
	public String getAddressOrderID(){
		return this.address_order_id;
	}
	
	public void setAddressOrderID(String ao){
		address_order_id = ao;
	}
}