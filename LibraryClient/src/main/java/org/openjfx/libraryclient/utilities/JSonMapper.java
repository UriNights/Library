package org.openjfx.libraryclient.utilities;

import java.io.IOException;
import java.io.InputStream;

import org.openjfx.libraryclient.model.Author;
import org.openjfx.libraryclient.model.Book;
import org.openjfx.libraryclient.model.IsModel;
import org.openjfx.libraryclient.model.Lending;
import org.openjfx.libraryclient.model.Library;
import org.openjfx.libraryclient.model.User;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JSonMapper {

	public static IsModel JSonInStreamToModel(InputStream input, String model) throws JsonParseException, JsonMappingException, IOException {
		
		if (input.available() == 0) {
			return null;
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		IsModel object = null;
		
		switch (model) {
			case "author":
				object = objectMapper.readValue(input, Author.class);
				break;
				
			case "book":
				object = objectMapper.readValue(input, Book.class);
				break;
				
			case "lending":
				object = objectMapper.readValue(input, Lending.class);
				break;
				
			case "library":
				object = objectMapper.readValue(input, Library.class);
				break;
				
			case "user":
				object = objectMapper.readValue(input, User.class);
				break;
		}

		return object;
	}

	public static String ModelToJSonString(IsModel object) throws JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();
		
		// Converts object to JSon string
		return objectMapper.writeValueAsString(object);
	}
}
