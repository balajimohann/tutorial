package com.raremile.poc.sendgrid;

import org.apache.james.jspf.core.SPF1Record;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!!" );

		System.out.println("App starts...");
	
		SPF1Record record =new SPF1Record();
		System.out.println("record : "+record.getRecord());
		
        
    }
}
