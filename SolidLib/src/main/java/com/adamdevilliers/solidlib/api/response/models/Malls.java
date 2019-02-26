package com.adamdevilliers.solidlib.api.response.models;

import java.util.List;

/*
    Solid sdk malls model is used to grab the malls response from the api
 */


public class Malls {
    private int id;
    private String name;
    private List<Shops> shops;

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

    public List<Shops> getShops() {
        return shops;
    }

    public void setShops(List<Shops> shops) {
        this.shops = shops;
    }
}
