package com.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

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

        dkListView.getSelectionModel().selectedItemProperty().addListener((obs, anterior, actual) -> { //Listener de el listview
            if (actual != null) { //Actualizamos la informacion si tenemos algo seleccionado
                dkLabel.setText(actual);
                dkInfo.setText("Informacion de: " + actual);
            }

            }
        );

        cargarGames();
        System.out.println(games.size());
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

    private List<Game> games = new ArrayList<>();
    private void cargarGames() { //Esta funcion sirve para leer los archivos .json y guardarlos en un array

    try {

        String contenido = Files.readString(
            Paths.get("assets/games.json")
        );

        JSONArray array = new JSONArray(contenido);

        for (int i = 0; i < array.length(); i++) {

            JSONObject objeto = array.getJSONObject(i);

            Game game = new Game(
                objeto.getString("name"),
                objeto.getInt("year"),
                objeto.getString("type"),
                objeto.getString("plot"),
                objeto.getString("image")
            );

            games.add(game);
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    }


}