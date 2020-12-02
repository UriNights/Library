package org.openjfx.libraryclient.controller;

import java.io.IOException;

import org.openjfx.libraryclient.App;
import org.openjfx.libraryclient.model.User;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainWinController {

	private User user;
	
	@FXML private Label userName;
	
	@FXML private void initialize() {
		this.user = App.getUser();
		userName.setText(this.user.getName() + " " + this.user.getMidName() + " " + this.user.getLastName());
	}
	
    @FXML
    private void switchToPrimary() throws IOException {
    }
}