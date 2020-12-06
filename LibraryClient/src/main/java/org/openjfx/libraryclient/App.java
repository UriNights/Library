package org.openjfx.libraryclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import org.openjfx.libraryclient.model.User;

public class App extends Application {

	private static Stage stage;
    private static Scene scene;
    
    private static User user;

    @Override
    public void start(Stage stage) throws IOException {
    	
        scene = new Scene(loadFXML("login"));
        App.stage = stage;
        stage.setScene(scene);
        stage.setTitle("myLibrary - Login");
        stage.getIcons().add(new Image(App.class.getResourceAsStream("book.png")));
        stage.setResizable(false);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        stage.setTitle("myLibrary - " + user.getNick());
        stage.sizeToScene();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void setUser(User user) {
    	App.user = user;
    }
    
    public static User getUser() {
    	return App.user;
    }

    public static void main(String[] args) {
        launch();
    }
}