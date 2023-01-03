package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class Alertsrunner {

	// variables
	int count = 0;
	int AlertsCreated = 0;
    BufferedReader reader;
    String line;
    StringBuilder GetResponse = new StringBuilder();
    String Errormessage = "";
    String urlString = "https://api.marketalertum.com/EventsLog/65c4902d-14bc-43af-87e0-f5e737ea8333";
    JSONArray alerts = new JSONArray();	        
    int alertTypeCounter = 0;
    int headingCounter = 0;
    int descriptionCounter = 0;
    int urlCounter = 0;
    int imageURLCounter = 0;
    int priceInCentsCounter = 0;
    int DeleteCount = 0;
		
	    public void Alerts() throws IOException
	    {

	        
	               
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
		        Errormessage = e.getMessage();
		        if(Errormessage.indexOf("4") == 36 && Errormessage.indexOf("0") == 37 && Errormessage.indexOf("1") == 38)
		        {
		        	System.out.println("Incorrect setup at RUNTIME");
		        }
		        
		        System.out.println(e.getMessage());
		        
		   
		        return;
	    	}
		        
	        String jsonString = GetResponse.toString();

	        JSONArray JSONArray = new JSONArray(jsonString);
	
            for (int i=0; i<JSONArray.length(); i++)
	        {
	            JSONObject currentObject = JSONArray.getJSONObject(i); 
	            
	            
	            AlertsCreated = currentObject.getInt("eventLogType");
	            
	            alerts = currentObject.getJSONObject("systemState").getJSONArray("alerts");
	            
		        
			    if(AlertsCreated == 0){
			    	count++;
			    }
			    else if(AlertsCreated == 1){
			    	DeleteCount++;
			    	
			    }
			    
	        }
            
			if(count == 3 && DeleteCount == 1){
	        	
				DeleteAndPostedSuccesfully();
				checkAlertProperties(alerts);
				
			} else {
				PostedIncorrectly();
			}
			    
			

	        
	    }
	    
	    public void checkAlertProperties(JSONArray alerts){
	    	
	    	for (int j = 0; j <= alerts.length()-1; j++) {
		         // get the current alert object as a JSONObject
		         JSONObject alert = alerts.getJSONObject(j);
		            
		          // access the fields of the alert object
		            int alertType = alert.getInt("alertType");
		            String heading = alert.getString("heading");
		            String description = alert.getString("description");
		            String Posturl = alert.getString("url");
		            String imageURL = alert.getString("imageURL");
		            int priceInCents = alert.getInt("priceInCents");
		            
		           
		          
		           if (alertType != 0) {
		               alertTypeCounter++;
		           }
		           if (!Posturl.isEmpty()) {
		        	   urlCounter++;
		           }
		           if (!heading.isEmpty()) {
		               headingCounter++;
		           }
		           if (!description.isEmpty()) {
		               descriptionCounter++;
		           }
		           if (!imageURL.isEmpty()) {
		               imageURLCounter++;
		           }
		           if (priceInCents != 0) {
		               priceInCentsCounter++;
		           }
		        	
		        }
			
			
			if (alertTypeCounter == 3 && headingCounter == 3 && descriptionCounter == 3 && urlCounter == 3 && imageURLCounter == 3 && priceInCentsCounter == 3) {
	        	 
	        	 ContainsAllInfo();
	        	} 
	         	else 
	         	{
	        	// At least one counter is not equal to 3
	        	if (alertTypeCounter != 3) {
		        	System.out.println("alertType counter is not equal to 3");
		        	
		        	MissingInfo("alertType");
	        	}
		        	if (headingCounter != 3) {
		        	System.out.println("heading counter is not equal to 3");
		        	MissingInfo("Heading");
	        	}
		        	if (descriptionCounter != 3) {
		        	System.out.println("description counter is not equal to 3");
		        	MissingInfo("Description");
	        	}
		        	if (urlCounter != 3) {
		        	System.out.println("url counter is not equal to 3");
		        	MissingInfo("url");
	        	}
		        	if (imageURLCounter != 3) {
		        	System.out.println("imageURL counter is not equal to 3");
		        	MissingInfo("ImageUrl");
	        	}
		        	if (priceInCentsCounter != 3) {
		        	System.out.println("priceInCents counter is not equal to 3");
		        	MissingInfo("PriceInCents");
	        	}
	         }
	    }
	    
	    public void DeleteAndPostedSuccesfully(){
	    	
	    	System.out.println("DELETE Was run Sucesfully and Correct number of alerts have been posted");
	    	
	    }
	     


	    public void PostedIncorrectly(){
	    	
	    	System.out.println("ERROR: InCorrect number of alerts have been posted");
	    }
	    
	    public void ContainsAllInfo(){
	    	
	    	System.out.println("All alerts are populated as required");
	    }
	    
	    public void MissingInfo(String alertType){
	    	
	    	System.out.println("All alerts are missing the following component : " + alertType);
	    	
	    }
	    
	    public static void main(String[] args) throws IOException{
	    	
	    	Alertsrunner run = new Alertsrunner();
	    	run.Alerts();

	}

}
