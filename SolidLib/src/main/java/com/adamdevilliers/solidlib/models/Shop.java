package com.adamdevilliers.solidlib.models;

/*
    Solid sdk Shop model is used to grab the shops response from the api
 */
public class Shop {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
