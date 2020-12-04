package org.openjfx.libraryclient.service;

import java.io.IOException;

import org.openjfx.libraryclient.model.User;
import org.openjfx.libraryclient.utilities.NetClient;

public class LoginService {

	public User checkUser(String nick, String password) throws IOException {
		
		String jSonString = "{\"nick\":\"" + nick + "\",\"password\":\"" + password + "\"}";
		return (User) NetClient.POST_Request("/login", jSonString, "user");
	}
}
