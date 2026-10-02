package com.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application { // .\run.ps1 com.project.Main

    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(
                Main.class.getResource("/assets/viewDesktop.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Nintendo DB");
        stage.setScene(scene);
        stage.show();
    }

    public static void cambiarVista(String fxml) throws IOException { //Metodo para alternar entre FXMLs
        Parent root = FXMLLoader.load(Main.class.getResource("/assets/" + fxml) );
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}