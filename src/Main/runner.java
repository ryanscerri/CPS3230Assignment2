//package main;
//import java.io.*;
//import java.net.*;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//public class runner 
//{
//	//Main Class
//	public static void main(String[] args) throws IOException 
//	{
//        runner runner = new runner();
//        runner.login();
//	}
//	
//	//Incorrect Login
//	public void incorrectLogin()
//	{
//		System.out.println("Incorrect Login");
//		//return loginState;
//	}
//	
//	//Correct Login
//	public void correctLogin()
//	{	
//		System.out.println("Correct Login");
//		//return loginState;
//	}
//	
//	//View alertsEvent
//	public void viewalertsEvent(int alertsEvent)
//	{
//		System.out.println(alertsEvent);
//	}
//	
//	//Login
//    public void login() throws IOException
//    {
//    	//Variables
//        BufferedReader reader;
//        String line;
//        StringBuilder GetResponse = new StringBuilder();
//        Boolean LoggedIn = false;
//        int alertsEvent = 0;
//        String message = "";
//        String urlString = "https://api.marketalertum.com/EventsLog/65c4902d-14bc-43af-87e0-f5e737ea8333";
//               
//        URL url = new URL(urlString);
//        URLConnection conn = url.openConnection();
//
//        //Read from API
//        try 
//    	{
//	        reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//	        while ((line = reader.readLine()) != null) 
//	        {
//	        	GetResponse.append(line);
//	        }
//	        
//	        reader.close();
//    	} 
//        
//        //In case reading from the API was not successful
//    	catch (IOException e) 
//    	{
//	        message = e.getMessage();
//	        if(message.indexOf("4") == 36 && message.indexOf("0") == 37 && message.indexOf("1") == 38)
//	        {
//	        	System.out.println("Incorrect Login");
//	        }
//	        
//	        System.out.println(e.getMessage());
//	        
//	        LoggedIn = false;
//	        return;
//    	}
//	        
//        //Get the response from the API and turn it into a String
//        String jsonString = GetResponse.toString();
//        
//        //Create an array of type JSONArray and pass the API's response in string format
//        JSONArray JSONArray = new JSONArray(jsonString);
//	
//        //Traverse the array 
//        for (int i=0; i<JSONArray.length(); i++)
//        {
//            JSONObject currentObject = JSONArray.getJSONObject(i); 
//            
//            //Get the login status by going inside 'systemState' and finding the state of 'loggedIn'
//            LoggedIn = currentObject.getJSONObject("systemState").getBoolean("loggedIn");
//            
//            //Get the alertsEvent by going inside 'systemState' and finding the contents inside of 'alertsEvent'
//            alertsEvent = currentObject.getInt("eventLogType");
//        }
//        
//        if(LoggedIn == false)
//        {
//        	incorrectLogin();
//        }
//        
//        if(LoggedIn == true)
//        {
//        	correctLogin();
//        	viewalertsEvent(alertsEvent);
//        }
//    }
//    
//  
//  
//}
//

package Main;
import java.io.*;
import java.net.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class runner 
{
	
	public static void main(String[] args) throws IOException 
	{
        runner runner = new runner();
        runner.login();
	}
	

	public void incorrectLogin()
	{
		System.out.println("Incorrect Login");
		
	}
	
	
	public void correctLogin()
	{	
		System.out.println("Correct Login");
		
	}
	
	public void LoggedOut()
	{
		System.out.println("LoggedOut");
	}
	

	public void viewAlerts()
	{
		System.out.println("alertsEvent are bieng viewed!");
	}
	
	
    public void login() throws IOException
    {
    	// variables
        BufferedReader reader;
        String line;
        StringBuilder GetResponse = new StringBuilder();
        int alertsEvent = 0;
        String message = "";
        String urlString = "https://api.marketalertum.com/EventsLog/65c4902d-14bc-43af-87e0-f5e737ea8333";
        int Logoutcount = 0;
        int viewCount = 0; 
        int LoginCount = 0;
               
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();

       //API run for correct logins
        try 
    	{
	        reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        while ((line = reader.readLine()) != null) 
	        {
	        	GetResponse.append(line);
	        }
	        
	       
	        
	        reader.close();
    	} 
        
        //catch for the incorrect login
    	catch (IOException e) 
    	{
	        message = e.getMessage();
	        if(message.indexOf("4") == 36 && message.indexOf("0") == 37 && message.indexOf("1") == 38)
	        {
	        	System.out.println("Incorrect Login");
	        }
	        
	        System.out.println(e.getMessage());
	        
	        return;
    	}
	        
        
        
        // getting response and saving it as a string and further as an Array
        String jsonString = GetResponse.toString();
        
        System.out.println(jsonString);
        
 
        JSONArray JSONArray = new JSONArray(jsonString);
	
        // looping through the array
        for (int i=0; i<JSONArray.length(); i++)
        {
            JSONObject currentObject = JSONArray.getJSONObject(i); 
            alertsEvent = currentObject.getInt("eventLogType");
            
		    if(alertsEvent == 6){
		    	Logoutcount++;
		    } else if(alertsEvent == 7){
		    	viewCount++;
		    } else if(alertsEvent == 5){
		    	LoginCount++;
		    }
        }
        
        
        if(LoginCount >= 1 && viewCount >= 1 && Logoutcount >= 1)
        {
        	correctLogin();
        	viewAlerts();
        	LoggedOut();
        } else {
        	
        	if (!(LoginCount >= 1)){
        		incorrectLogin();
        	}
        	
		    	if (!(viewCount >= 1)) {
		    	System.out.println("Alerts were not viewed!");
		    	
			}
		    	if (!(Logoutcount >= 1)) {
		    	System.out.println("User DID NOT LOGOUT!");
		    	
			}
        	
        	
        }
        

        
	
        
    }
  
  
}



