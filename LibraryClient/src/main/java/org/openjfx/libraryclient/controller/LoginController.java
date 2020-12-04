package org.openjfx.libraryclient.controller;

import java.io.IOException;

import org.openjfx.libraryclient.App;
import org.openjfx.libraryclient.model.User;
import org.openjfx.libraryclient.service.LoginService;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {
	
	private LoginService loginService;

	@FXML private TextField userTxtField;
	@FXML private TextField passwordTxtField;
	
	@FXML private Button login;
	@FXML private Button exit;
	
	@FXML private void initialize() {
		loginService = new LoginService();
		login.setDefaultButton(true);
	}
	
    @FXML
    private void login() throws IOException {
    	
    	if(!this.userTxtField.getText().isBlank() && !this.passwordTxtField.getText().isBlank()) {
    		
    		User user = loginService.checkUser(this.userTxtField.getText(), this.passwordTxtField.getText());
    		
    		if (user.getName() != null) {
    			
    			App.setUser(user);
    			App.setRoot("mainWin");
    		} else {
    			
    			Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Bad login");
    			alert.setHeaderText("Wrong user or password.");
    			alert.showAndWait();
    		}
    	}
    }
    
    @FXML
    private void exit() throws IOException {
        Platform.exit();
    }
}