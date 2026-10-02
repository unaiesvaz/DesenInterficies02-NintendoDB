package com.project;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ControllerDesktop {

    @FXML
    private VBox dkVboxcent;

    @FXML
    private ImageView dkImage;

    @FXML
    private Label dkLabel;

    @FXML
    private Text dkInfo;

    @FXML
    private VBox dkVboxLat;

    @FXML
    private ComboBox<String> dkComboBox;

    @FXML
    private ListView<String> dkListView;

    @FXML
    private Text dkTitle;


    @FXML
    private void initialize() { //Esta funcion se ejecuta al iniciar el controlador

        dkComboBox.getItems().addAll(
            "Jocs",
            "Personatges",
            "Consoles"
        );

        dkComboBox.setValue("Jocs"); //Seteamos el valor inicial a Jocs

        carregarLlista("Jocs");

        dkComboBox.valueProperty().addListener((obs, anterior, actual) -> { //Agregamos un listener al combobox

            carregarLlista(actual);

        });
    }


    private void carregarLlista(String categoria) { //Esta funcion nos sirve para que cada vez que se modifica el combobox, cargar el list view

    if (categoria.equals("Jocs")) {

        dkListView.getItems().setAll(
            "Super Mario Bros",
            "The Legend of Zelda",
            "Pokémon"
        );

    } else if (categoria.equals("Personatges")) {

        dkListView.getItems().setAll(
            "Mario",
            "Link",
            "Pikachu"
        );

    } else if (categoria.equals("Consoles")) {

        dkListView.getItems().setAll(
            "Nintendo Switch",
            "Nintendo Wii",
            "Nintendo DS"
        );

    }

}


}