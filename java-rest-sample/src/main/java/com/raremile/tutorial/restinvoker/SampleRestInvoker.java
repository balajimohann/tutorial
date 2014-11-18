package com.raremile.tutorial.restinvoker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SampleRestInvoker {

	public static void invokeRest(String urlStr){
		
		try{
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
 
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
 
		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
 
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
 
		conn.disconnect();
 
	  } catch (MalformedURLException ex) {
 
		ex.printStackTrace();
 
	  } catch (IOException ex2) {
 
		ex2.printStackTrace();
 
	  }

	}
	public static void main(String args[]){
		
		System.out.println("Invoking rest...");
		
		SampleRestInvoker.invokeRest("http://graph.facebook.com/balaji.mx");
		
	}

	
}
