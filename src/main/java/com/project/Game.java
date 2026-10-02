package com.project;

public class Game {

    private String name;
    private int year;
    private String type;
    private String plot;
    private String image;

    public Game() {
    }

    public Game(String name, int year, String type, String plot, String image) {
        this.name = name;
        this.year = year;
        this.type = type;
        this.plot = plot;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}