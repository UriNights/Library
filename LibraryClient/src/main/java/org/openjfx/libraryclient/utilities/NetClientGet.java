package org.openjfx.libraryclient.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetClientGet {
	
    public static void create() {
    	
        try {
            URL url = new URL("http://localhost:8080/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            
            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + connection.getResponseCode());
            }
            
            InputStreamReader in = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            connection.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
    }
}