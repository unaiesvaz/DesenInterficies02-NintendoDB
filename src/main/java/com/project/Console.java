package com.project;

public class Console {

    private String name;
    private String date;
    private String procesador;
    private String color;
    private int units_sold;
    private String image;

    public Console() {
    }

    public Console(String name, String date, String procesador,
                   String color, int units_sold, String image) {
        this.name = name;
        this.date = date;
        this.procesador = procesador;
        this.color = color;
        this.units_sold = units_sold;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getUnits_sold() {
        return units_sold;
    }

    public void setUnits_sold(int units_sold) {
        this.units_sold = units_sold;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
