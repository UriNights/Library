package org.openjfx.libraryclient.service;

import java.io.IOException;
import java.util.List;

import org.openjfx.libraryclient.model.Author;
import org.openjfx.libraryclient.model.IsModel;
import org.openjfx.libraryclient.model.Library;
import org.openjfx.libraryclient.model.User;
import org.openjfx.libraryclient.utilities.JSonMapper;
import org.openjfx.libraryclient.utilities.NetClient;

import javafx.collections.ObservableList;

public class MainWinService {

	public List<? extends IsModel> getActiveLending(User user) throws IOException {

		String jSonString = "{\"_id\":\"" + user.get_id() + "\"}";
		return NetClient.POST_RequestList("/user/active_lendings", jSonString, "user");
	}
	
	
	// USERS
	public IsModel addNewUser(User user) throws IOException {

		String jSonString = JSonMapper.ModelToJSonString(user);
		return NetClient.POST_Request("/new_user", jSonString, null);
	}

	public IsModel deleteUser(User user) throws IOException {

		String jSonString = JSonMapper.ModelToJSonString(user);
		return NetClient.POST_Request("/delete_user", jSonString, null);
	}
	
	public void listUsers(ObservableList<User> observListUsers) throws IOException {

		List<? extends IsModel> users = NetClient.GET_RequestList("/users", "user");
		
		if (users != null) {
			users.forEach(user -> observListUsers.add((User) user));
		}
	}

	
	// LIBRARIES
	public IsModel addNewLibrary(Library library) throws IOException {
		
		String jSonString = JSonMapper.ModelToJSonString(library);
		return NetClient.POST_Request("/new_library", jSonString, null);
	}
	
	public IsModel deleteLibrary(Library library) throws IOException {

		String jSonString = JSonMapper.ModelToJSonString(library);
		return NetClient.POST_Request("/delete_library", jSonString, null);
	}

	public void listLibraries(ObservableList<Library> observListLibraries) throws IOException {

		List<? extends IsModel> libraries = NetClient.GET_RequestList("/library", "library");
		
		if (libraries != null) {
			libraries.forEach(library -> observListLibraries.add((Library) library));
		}
	}

	// AUTHORS
	public IsModel addNewAuthor(Author author) throws IOException {
		
		String jSonString = JSonMapper.ModelToJSonString(author);
		return NetClient.POST_Request("/new_author", jSonString, null);
	}
	
	public IsModel deleteAuthor(Author author) throws IOException {

		String jSonString = JSonMapper.ModelToJSonString(author);
		return NetClient.POST_Request("/delete_author", jSonString, null);
	}
	
	public void listAuthors(ObservableList<Author> observListAuthors) throws IOException {

		List<? extends IsModel> authors = NetClient.GET_RequestList("/author", "author");
		
		if (authors != null) {
			authors.forEach(author -> observListAuthors.add((Author) author));
		}
	}
}
