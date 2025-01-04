package com.bun.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginForm.fxml")));
        primaryStage.setTitle("LINCOLN NATIONAL HIGH SCHOOL");
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo_llu.png")))); // Adjust the path
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.setMaximized(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}