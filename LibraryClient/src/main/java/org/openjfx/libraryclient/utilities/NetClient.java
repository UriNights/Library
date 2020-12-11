package org.openjfx.libraryclient.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openjfx.libraryclient.model.IsModel;

public class NetClient {

	public static List<? extends IsModel> GET_RequestList(String URI, String modelToReturn) throws IOException {
		
		URL obj = new URL("http://localhost:8080/webapi" + URI);
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("GET");
		postConnection.setRequestProperty("User-Agent", "myLibrary");
		postConnection.setRequestProperty("UserHostName", "NotDefined");
		postConnection.setRequestProperty("Content-Type", "application/json");
		
		if (postConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

			InputStream input = postConnection.getInputStream();
			
			List<? extends IsModel> objectList = JSonMapper.JSonInStreamToModelList(input, modelToReturn);
			input.close();
			
			return objectList;

		} else {

			System.out.println("POST NOT WORKED");
			return null;
		}
	}

	public static IsModel POST_Request(String URI, String jSonToSend, String modelToReturn) throws IOException {

		URL obj = new URL("http://localhost:8080/webapi" + URI);
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
		postConnection.setRequestProperty("User-Agent", "myLibrary");
		postConnection.setRequestProperty("UserHostName", "NotDefined");
		postConnection.setRequestProperty("Content-Type", "application/json");
		postConnection.setDoOutput(true);

		OutputStream os = postConnection.getOutputStream();
		os.write(jSonToSend.getBytes());
		os.flush();
		os.close();
		
		if (postConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

			InputStream input = postConnection.getInputStream();
			IsModel object = JSonMapper.JSonInStreamToModel(input, modelToReturn);
			input.close();

			return object;

		} else {

			System.out.println("POST NOT WORKED");
			return null;
		}
	}
	
	public static List<? extends IsModel> POST_RequestList(String URI, String jSonToSend, String modelToReturn) throws IOException {

		URL obj = new URL("http://localhost:8080/webapi" + URI);
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
		postConnection.setRequestProperty("User-Agent", "myLibrary");
		postConnection.setRequestProperty("UserHostName", "NotDefined");
		postConnection.setRequestProperty("Content-Type", "application/json");
		postConnection.setDoOutput(true);

		OutputStream os = postConnection.getOutputStream();
		os.write(jSonToSend.getBytes());
		os.flush();
		os.close();
		
		if (postConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

			InputStream input = postConnection.getInputStream();
			List<? extends IsModel> objectList = JSonMapper.JSonInStreamToModelList(input, modelToReturn);
			input.close();
			
			return objectList;

		} else {

			System.out.println("POST NOT WORKED");
			return null;
		}
	}
}