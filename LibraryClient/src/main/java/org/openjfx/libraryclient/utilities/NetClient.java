package org.openjfx.libraryclient.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openjfx.libraryclient.model.IsModel;
import org.openjfx.libraryclient.model.User;

import com.fasterxml.jackson.databind.ObjectMapper;

public class NetClient {

/*	public static void GET_request() {

		try {
			URL url = new URL("http://localhost:8080/login");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");

			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + connection.getResponseCode());
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
	}*/

	public static IsModel POST_Request(String userName, String jSonToSend, String modelToReturn) throws IOException {

		URL obj = new URL("http://localhost:8080/webapi/login");
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
		postConnection.setRequestProperty("User-Agent", "myLibrary");
		postConnection.setRequestProperty("UserHostName", userName);
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
}