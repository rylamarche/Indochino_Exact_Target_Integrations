/***************************************
 * 
 **************************************/
package com.indochino.csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.ObjectMapper;

import com.csvreader.CsvWriter;
import com.indochino.csv.ExactTargetSubscriber;
import com.indochino.csv.ExactTargetCustomer;

public class CSVWriter {
	
	public String exactTargetSubscriberWriter(ArrayList<?> data, String fileLocation){
		
		String outputFile = fileLocation;
		String returnMessage = null;
		
		try {
			CsvWriter writer = new CsvWriter(new FileWriter(outputFile), '|');
			
			writer.write("Email");
			writer.write("SignUpDate");
			writer.endRecord();
			
			ObjectMapper mapper = new ObjectMapper();
					
			for(Object f: data){
				ExactTargetSubscriber feed = mapper.readValue(f.toString(), ExactTargetSubscriber.class);
				
				writer.write(feed.email);
				writer.write(feed.signUpdate);
				writer.endRecord();
			}

			writer.close();
			returnMessage = "Subscriber CSV file saved!";
			
		} catch(IOException ex) {
			
			System.out.println("ERROR: " + ex.getMessage());
			returnMessage = "ERROR: " + ex.getMessage();
			
		}
		
		return returnMessage;
		
	}
	
	public String exactTargetCustomerWriter(ArrayList<?> data, String fileLocation){
		
		String outputFile = fileLocation;
		String returnMessage = null;
		
		try {
			CsvWriter writer = new CsvWriter(new FileWriter(outputFile), '|');
			
			writer.write("customer_id");
			writer.write("customer_email");
			writer.write("customer_name");
			writer.write("is_active");
			writer.write("is_fraudster");
			writer.write("is_VIP");
			writer.write("subscribed_to_newsletter");
			writer.write("registration_date");
			writer.write("city");
			writer.write("state");
			writer.write("zip");
			writer.write("country");
			writer.write("address_order_id");
			writer.endRecord();
			
			ObjectMapper mapper = new ObjectMapper();
					
			for(Object f: data){
				ExactTargetCustomer feed = mapper.readValue(f.toString(), ExactTargetCustomer.class);
				
				writer.write(feed.customer_id);
				writer.write(feed.customer_email);
				writer.write(feed.customer_name);
				writer.write(feed.is_active);
				writer.write(feed.is_fraudster);
				writer.write(feed.is_VIP);
				writer.write(feed.subscribed_to_newsletter);
				writer.write(feed.registration_date);
				writer.write(feed.city);
				writer.write(feed.state);
				writer.write(feed.zip);
				writer.write(feed.country);
				writer.write(feed.address_order_id);
				writer.endRecord();
			}

			writer.close();
			returnMessage = "Customer CSV file saved!";
			
		} catch(IOException ex) {
			
			System.out.println("ERROR: " + ex.getMessage());
			returnMessage = "ERROR: " + ex.getMessage();
			
		}
		
		return returnMessage;
		
	}
	
	public void moveFile(String init_location, String move_location, String filename, String extension){
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HH-MM-SS"); 
		
		File source = new File(init_location + filename + "." + extension);
		File destination = new File(move_location + filename + "_" + sdf.format(date) + "." + extension);
		
		try {
			
			FileUtils.moveFile(source, destination);
		
		} catch (IOException ex) {
		
			System.out.println("ERROR: " + ex.getMessage());
			
		}
	}
}