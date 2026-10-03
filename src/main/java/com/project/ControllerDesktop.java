package com.project;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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
import javafx.scene.image.Image;
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

        cargarGames();
        cargarCharacters();
        cargarConsoles();

        dkComboBox.getItems().addAll(
            "Jocs",
            "Personatges",
            "Consoles"
        );

        dkComboBox.setValue("Jocs"); //Seteamos el valor inicial a Jocs

        carregarLlista("Jocs");

        dkComboBox.valueProperty().addListener((obs, anterior, actual) -> { //Agregamos un listener al combobox

            dkLabel.setText(""); //Estas lineas son para que al cambiar entre categorias, se borre la info 
            dkInfo.setText("");
            dkImage.setImage(null);

            carregarLlista(actual);

        });

        dkListView.getSelectionModel().selectedIndexProperty().addListener((obs, anterior, actual) -> { //Listener de el listview//Actualizamos la informacion si tenemos algo seleccionado
                
            if (actual.intValue() >= 0) { //actual representa el indice de la lista de info del json
                    mostrarSeleccion(actual.intValue()); 
                }

            }
        );

    }


    private void carregarLlista(String categoria) { //Esta funcion nos sirve para que cada vez que se modifica el combobox, cargar el list view

    dkListView.getItems().clear();

    if (categoria.equals("Jocs")) {

        for (Game game : games) { // Recorremos los arrays de los archivos json y los agregamos a la listview
            dkListView.getItems().add(game.getName());
        }

    } else if (categoria.equals("Personatges")) {

        for (Character character : characters) {
            dkListView.getItems().add(character.getName());
        }

    } else if (categoria.equals("Consoles")) {

        for (Console console : consoles) {
            dkListView.getItems().add(console.getName());
        }
    }
    }

    private List<Game> games = new ArrayList<>();
    private void cargarGames() { //Esta funcion sirve para leer los archivos .json y guardarlos en un array

    try (InputStream input = getClass().getResourceAsStream("/assets/games.json")) {

        if (input == null) {
            throw new IOException("No se ha encontrado games.json");
        }

        String contenido = new String(
            input.readAllBytes(),
            StandardCharsets.UTF_8
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

    private List<Character> characters = new ArrayList<>();
    private void cargarCharacters() {

    try (InputStream input = getClass().getResourceAsStream("/assets/characters.json")) {

        if (input == null) {
            throw new IOException("No se ha encontrado characters.json");
        }

        String contenido = new String(
            input.readAllBytes(),
            StandardCharsets.UTF_8
        );

        JSONArray array = new JSONArray(contenido);

        for (int i = 0; i < array.length(); i++) {

            JSONObject objeto = array.getJSONObject(i);

            Character character = new Character(
                objeto.getString("name"),
                objeto.getString("image"),
                objeto.getString("color"),
                objeto.getString("game")
            );

            characters.add(character);
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private List<Console> consoles = new ArrayList<>();
    private void cargarConsoles() {

    try (InputStream input = getClass().getResourceAsStream("/assets/consoles.json")) {

        if (input == null) {
            throw new IOException("No se ha encontrado consoles.json");
        }

        String contenido = new String(
            input.readAllBytes(),
            StandardCharsets.UTF_8
        );

        JSONArray array = new JSONArray(contenido);

        for (int i = 0; i < array.length(); i++) {

            JSONObject objeto = array.getJSONObject(i);

            Console console = new Console(
                objeto.getString("name"),
                objeto.getString("date"),
                objeto.getString("procesador"),
                objeto.getString("color"),
                objeto.getInt("units_sold"),
                objeto.getString("image")
            );

            consoles.add(console);
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    private void cargarImagen(String nombreImagen) {

    InputStream input = getClass().getResourceAsStream(
        "/assets/images/" + nombreImagen
    );

    if (input != null) {
        dkImage.setImage(new Image(input));
    }
    }
    private void mostrarSeleccion(int indice) { //Esta funcion nos sirve para recibir un indice de la lista de valores del json
    // y mire que categoria esta seleccionada para poder actualizar la informacion 

    String categoria = dkComboBox.getValue();

    if (categoria.equals("Jocs")) {

        Game game = games.get(indice);

        dkLabel.setText(game.getName());

        dkInfo.setText(
            "Any: " + game.getYear() +
            "\nTipus: " + game.getType() +
            "\n\n" + game.getPlot()
        );

        cargarImagen(game.getImage());

    } else if (categoria.equals("Personatges")) {

        Character character = characters.get(indice);

        dkLabel.setText(character.getName());

        dkInfo.setText(
            "Color: " + character.getColor() +
            "\nJoc: " + character.getGame()
        );

        cargarImagen(character.getImage());

    } else if (categoria.equals("Consoles")) {

        Console console = consoles.get(indice);

        dkLabel.setText(console.getName());

        dkInfo.setText(
            "Data: " + console.getDate() +
            "\nProcessador: " + console.getProcesador() +
            "\nColor: " + console.getColor() +
            "\nUnitats venudes: " + console.getUnits_sold()
        );

        cargarImagen(console.getImage());
    }
}
}