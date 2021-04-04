package com.sura.seguros;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApplication  
{  
    public static void main(String[] args)  throws URISyntaxException
    {
    	
    	
    	String sEnv = System.getenv("DATABASE_URL");
    	URI dbUri = null;
    	if(sEnv==null)
    	{
    		  dbUri = new URI("postgres://iolgtiocldpyil:rwrwerwerwetwt.aws@ec2-54-91-178-234.compute-1.amazonaws.com:5532/fsfdsfs");
       	}
    	else
    	{
    		  dbUri = new URI(System.getenv("DATABASE_URL"));
    	}
    	
    	System.setProperty("spring.datasource.username",dbUri.getUserInfo().split(":")[0]);
   	    System.setProperty("spring.datasource.password",dbUri.getUserInfo().split(":")[1]);
   	    System.setProperty("spring.datasource.url","jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require");
   		System.setProperty("spring.datasource.driver-class-name", "org.postgresql.Driver");
   			 

    	
        SpringApplication.run(StartApplication.class, args);
    }     
}