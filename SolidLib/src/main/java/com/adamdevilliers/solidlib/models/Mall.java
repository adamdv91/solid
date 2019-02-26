package com.adamdevilliers.solidlib.models;

import java.util.List;

/*
    Solid sdk malls model is used to grab the malls response from the api
 */


public class Mall {
    private int id;
    private String name;
    private List<Shop> shops;

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

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
}
