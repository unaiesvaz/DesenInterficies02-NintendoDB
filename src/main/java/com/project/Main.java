package com.project;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {

        this.stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(
            Main.class.getResource("/assets/ViewDesktop.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("NintendoDB");

        // Tamaño inicial de la ventana
        stage.setWidth(900);
        stage.setHeight(600);

        stage.setScene(scene);
        stage.show();

        // Detectamos cambios de anchura
        scene.widthProperty().addListener((obs, anterior, actual) -> { //Listener a la propiedad de la anchura

            if (actual.doubleValue() < 700) { // Esta parte controla que depende del tamaño de la ventana cambie entre las vistas
                cambiarVista("ViewMobile.fxml");
            } else {
                cambiarVista("ViewDesktop.fxml");
            }
        });
    }


    private void cambiarVista(String fxml) { //Funcion para cambiar la vista

        try {
            Parent root = FXMLLoader.load(
                Main.class.getResource("/assets/" + fxml)
            );
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        launch();
    }
}