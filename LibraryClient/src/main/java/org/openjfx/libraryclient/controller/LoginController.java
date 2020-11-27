package org.openjfx.libraryclient.controller;

import java.io.IOException;

import org.openjfx.libraryclient.App;
import org.openjfx.libraryclient.service.LoginService;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {
	
	private LoginService loginService;

	@FXML private TextField userTxtField;
	@FXML private TextField passwordTxtField;
	
	@FXML private Button login;
	@FXML private Button exit;
	
	@FXML private void initialize() {
		this.loginService = new LoginService();
	}
	
    @FXML
    private void login() throws IOException {
    	
    	if(!this.userTxtField.getText().isBlank() && !this.passwordTxtField.getText().isBlank()) {
    		
    		this.loginService.checkUserAndPassword(this.userTxtField.getText(), this.passwordTxtField.getText());
    		
    		App.setRoot("mainWin");
    	}
    }
    
    @FXML
    private void exit() throws IOException {
        Platform.exit();
    }
}