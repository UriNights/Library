package org.openjfx.libraryclient.service;

import java.io.IOException;
import java.util.List;

import org.openjfx.libraryclient.model.IsModel;
import org.openjfx.libraryclient.model.User;
import org.openjfx.libraryclient.utilities.JSonMapper;
import org.openjfx.libraryclient.utilities.NetClient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class MainWinService {

	public List<? extends IsModel> getActiveLending(User user) throws IOException {

		String jSonString = "{\"_id\":\"" + user.get_id() + "\"}";
		return NetClient.POST_RequestList("/user/active_lendings", jSonString, "user");
	}

	
	public void getNewUser() throws IOException {

	}

	public IsModel addNewUser(User user) throws IOException {

		String jSonString = JSonMapper.ModelToJSonString(user);
		return NetClient.POST_Request("/new_user", jSonString, null);
	}


	public void listUsers(TableView usersTable) throws IOException {

		List<? extends IsModel> users = NetClient.GET_RequestList("/users", "user");
		
		ObservableList<User> observListUser = (ObservableList<User>) FXCollections.observableArrayList(users);
		usersTable.setItems(observListUser);
	}
}
