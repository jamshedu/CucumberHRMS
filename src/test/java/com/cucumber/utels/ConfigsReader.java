package com.cucumber.utels;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
	
	
	public static Properties prop;
	
	/**
	 * This method will read proparties files
	 * @param filePath
	 */
	
	public static void readProparties(String filePath) {
		
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop=new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
      /**
       * 
       * This method will return value specified
       * @param String key 
       * @param String value
       */
	
	public static String getProparty(String key) {
		return prop.getProperty(key);
	}
	
	
	
	
	
	
	
}
