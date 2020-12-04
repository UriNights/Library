package org.openjfx.libraryclient.controller;

import java.io.IOException;

import org.openjfx.libraryclient.App;
import org.openjfx.libraryclient.model.User;
import org.openjfx.libraryclient.model.User.Rol;
import org.openjfx.libraryclient.service.MainWinService;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class MainWinController {

	private User user;
	private MainWinService mainWinService;

	@FXML private Button isAdmin;
	@FXML private Pane adminBtns;

	@FXML private JFXButton activeLendingBtn;
	@FXML private JFXButton pastLendingBtn;
	@FXML private Pane lendPanel;
	@FXML private TableView lendTable;

	@FXML private JFXButton newLendingBtn;
	@FXML private Pane newLendPanel;
	@FXML private TableView findedBooksTable;

	@FXML private JFXButton usersBtn;
	@FXML private Pane usersPanel;
	@FXML private JFXTextField txtUserName;
	@FXML private JFXTextField txtUserMidname;
	@FXML private JFXTextField txtUserLastname;
	@FXML private JFXTextField txtUserDni;
	@FXML private JFXTextField txtUserAge;
	@FXML private JFXTextField txtUserNick;
	@FXML private JFXTextField txtUserPassword;
	@FXML private ChoiceBox<Rol> rolList;
	@FXML private TableView<User> usersTable;

	@FXML private Label userName;

	private JFXButton activeBtn;
	private Pane activePanel;

	@FXML
	private void initialize() {

		this.mainWinService = new MainWinService();

		this.user = App.getUser();
		userName.setText(this.user.getName() + " " + this.user.getMidName() + " " + this.user.getLastName());

		if (this.user.getRol().ordinal() == User.Rol.ADMIN.ordinal()) {
			this.isAdmin.setVisible(true);
			this.adminBtns.setVisible(true);
		}

		this.activeBtn = this.activeLendingBtn;
		this.activePanel = this.lendPanel;
		this.lendPanel.setViewOrder(0);
		this.newLendPanel.setViewOrder(1);
		this.usersPanel.setViewOrder(1);
		
		ObservableList<Rol> observListRols = FXCollections.observableArrayList(User.Rol.list());
		this.rolList.setItems(observListRols);
	}

	private void menuBtnAction(JFXButton btn, Pane panel) {

		if (btn != this.activeBtn) {
			this.activeBtn = btn;
		}

		if (panel != this.activePanel) {
			panel.setViewOrder(0);
			this.activePanel.setViewOrder(1);
			this.activePanel = panel;

		}
	}

	@FXML
	private void activeLendingClick() {
		this.menuBtnAction(activeLendingBtn, lendPanel);
	}

	@FXML
	private void pastLendingClick() {
		this.menuBtnAction(pastLendingBtn, lendPanel);
	}

	@FXML
	private void newLendingClick() {
		this.menuBtnAction(newLendingBtn, newLendPanel);
	}

	@FXML
	private void usersClick() throws IOException {
		this.menuBtnAction(usersBtn, usersPanel);
		this.mainWinService.listUsers(this.usersTable);
	}

	@FXML
	private void addNewUser() throws IOException {

		if (this.txtUserName.getText().isBlank() ||
				this.txtUserMidname.getText().isBlank() ||
				this.txtUserLastname.getText().isBlank() ||
				this.txtUserDni.getText().isBlank() ||
				this.txtUserAge.getText().isBlank() ||
				this.txtUserNick.getText().isBlank() ||
				this.txtUserPassword.getText().isBlank() ||
				this.rolList.getValue() == null) {
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Some camp/s are empty!");
			alert.setHeaderText("Please, fill all the fields.");
			alert.showAndWait();
		} else {
			
			User user = new User(this.txtUserName.getText(),
					this.txtUserMidname.getText(),
					this.txtUserLastname.getText(),
					this.txtUserNick.getText(),
					this.txtUserPassword.getText(),
					this.txtUserDni.getText(),
					Integer.valueOf(this.txtUserAge.getText()),
					null);

			user.setRol(this.rolList.getValue());
			
			this.mainWinService.addNewUser(user);
		}
	}
}