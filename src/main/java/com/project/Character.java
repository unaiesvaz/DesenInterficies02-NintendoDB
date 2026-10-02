package com.project;

public class Character {

    private String name;
    private String image;
    private String color;
    private String game;

    public Character() {
    }

    public Character(String name, String image, String color, String game) {
        this.name = name;
        this.image = image;
        this.color = color;
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
}