package org.openjfx.libraryclient.controller;

import java.io.IOException;

import org.openjfx.libraryclient.App;
import org.openjfx.libraryclient.model.Author;
import org.openjfx.libraryclient.model.Book;
import org.openjfx.libraryclient.model.Genre;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class MainWinController {

	private User user;
	private MainWinService mainWinService;
	
	@FXML private Label userName;
	@FXML private Label isAdmin;
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
	@FXML private ComboBox<Rol> rolList;
	@FXML private TableView<User> usersTable;
	@FXML private JFXButton addUserBtn;
	
	@FXML private JFXButton librariesBtn;
	@FXML private Pane librariesPanel;
	@FXML private JFXTextField txtLibName;
	@FXML private JFXTextField txtLibLocation;
	@FXML private JFXButton addLibBtn;
	
	@FXML private JFXButton booksBtn;
	@FXML private Pane booksPanel;
	@FXML private JFXTextField txtTitle;
	@FXML private ComboBox<Author> authorsList;
	@FXML private JFXTextField txtISBN;
	@FXML private JFXTextField txtPages;
	@FXML private ComboBox<Genre> genreList;
	@FXML private TableView<Book> booksTable;
	@FXML private JFXButton addBookBtn;
	
	@FXML private JFXButton authorsBtn;
	@FXML private Pane authorsPanel;
	@FXML private JFXTextField txtAuthorName;
	@FXML private JFXTextField txtAuthorMidname;
	@FXML private JFXTextField txtAuthorLastname;
	@FXML private JFXButton addAuthorBtn;

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
		this.librariesPanel.setViewOrder(1);
		this.booksPanel.setViewOrder(1);
		this.authorsPanel.setViewOrder(1);
				
		ObservableList<Rol> observListRols = FXCollections.observableArrayList(User.Rol.list());
		this.rolList.setItems(observListRols);
		
		ObservableList<Genre> observListGenres = FXCollections.observableArrayList(Genre.list());
		this.genreList.setItems(observListGenres);
	}

	
	// Menu buttons
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
	private void librariesClick() throws IOException {
		this.menuBtnAction(librariesBtn, librariesPanel);
	}
	
	@FXML
	private void booksClick() throws IOException {
		this.menuBtnAction(booksBtn, booksPanel);
	}

	@FXML
	private void authorsClick() throws IOException {
		this.menuBtnAction(authorsBtn, authorsPanel);
	}
	
	// User menu
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