package com.inetBanking.utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	
	String path="D:\\Java\\inetBankingV1\\Configuration\\config.properties";
	
	//constructor
	
 public	ReadConfig()
	{
		try {
			 
			properties =new Properties();
			
			FileInputStream fileInput=new FileInputStream(path);
			properties.load(fileInput);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
      public String getBaseURL()
      {
    	  String value= properties.getProperty("baseURL");
    	  
    	  if(value!=null)
    		  
    		  return value;
    	  
    	  else 
			    throw new RuntimeException("url not specified in config file");
		
      }
      
      public String getUserName()
      {
    	  String value= properties.getProperty("username");
    	  
    	  if(value!=null)
    		  
    		  return value;
    	  
    	  else 
			    throw new RuntimeException("username not specified in config file");
		
      }
      public String getPassword()
      {
    	  String value= properties.getProperty("password");
    	  
    	  if(value!=null)
    		  
    		  return value;
    	  
    	  else 
			    throw new RuntimeException("password not specified in config file");
		
      }
      public String getbrowser()
      {
    	  String value= properties.getProperty("browser");
    	  
    	  if(value!=null)
    		  
    		  return value;
    	  
    	  else 
			    throw new RuntimeException("browser not specified in config file");
		
      }

}
