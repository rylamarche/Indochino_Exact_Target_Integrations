package com.indochino.FTP;

import java.io.File;
import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;

import com.jcraft.jsch.*;

public class FileUpload {
	public String uploadFeed(String server, 
							int port, 
							String user, 
							String password, 
							String fileLocation,
							String fileName,
							String fileDestination) throws Exception{
		
		String message = null;
       
		JSch jsch = new JSch();
        Session session = null;
        ChannelSftp channelSftp = null;
        
		try{
			session = jsch.getSession(user, server, port);
            session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;

            File file = new File(fileLocation);
            channelSftp.cd(fileDestination);
            channelSftp.put(new FileInputStream(file), file.getName(), null, ChannelSftp.OVERWRITE);

			String category = fileLocation.toLowerCase().contains("customers") ? "Customers" : "Subscribers";
			System.out.println("Exact Tagerget " + category + " Feed Upload Successful!");
			message = "Exact Tagerget " + category + " Feed Upload Successful!";
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
			message = "ERROR: " + ex.getMessage();
			throw ex;
		} finally {
			try{
				channelSftp.exit();
				session.disconnect();
			} catch (Exception ex) {
				ex.printStackTrace();
				message = "ERROR: " + ex.getMessage();
				throw ex;
			}
		}
		return message;
	}
}
