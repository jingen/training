package com.training;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		Properties p = new Properties();
		String fileName = "C:\\TRG\\fitsweb\\tomcat6\\fitsconf\\Fits.properties";
		p.load(new FileInputStream(fileName));
		System.out.println(p.getProperty("PentahoURL"));
		System.out.println("end");
	}
}
