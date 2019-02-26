package com.adamdevilliers.solidlib.api.response.models;

/*
    Solid sdk Shops model is used to grab the shops response from the api
 */
public class Shops {

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
