package org.openjfx.libraryclient.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.openjfx.libraryclient.model.Author;
import org.openjfx.libraryclient.model.Book;
import org.openjfx.libraryclient.model.IsModel;
import org.openjfx.libraryclient.model.Lending;
import org.openjfx.libraryclient.model.Library;
import org.openjfx.libraryclient.model.User;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
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
	
	public static List<? extends IsModel> JSonInStreamToModelList(InputStream input, String model) throws JsonParseException, JsonMappingException, IOException {
		
		if (input.available() == 0) {
			return null;
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		switch (model) {
			case "author":
				List<Author> authorList = (List<Author>) objectMapper.readValue(input, new TypeReference<List<Author>>(){});
				return authorList;
				
			case "book":
				List<Book> bookList = objectMapper.readValue(input, new TypeReference<List<Book>>(){});
				return bookList;
				
			case "lending":
				List<Lending> lendingList = objectMapper.readValue(input, new TypeReference<List<Lending>>(){});
				return lendingList;
				
			case "library":
				List<Library> libraryList = objectMapper.readValue(input, new TypeReference<List<Library>>(){});
				return libraryList;
				
			case "user":
				List<User> userList = objectMapper.readValue(input, new TypeReference<List<User>>(){});
				return userList;
			
			default:
				return null;
		}
	}

	public static String ModelToJSonString(IsModel object) throws JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();
		
		// Converts object to JSon string
		return objectMapper.writeValueAsString(object);
	}
}
