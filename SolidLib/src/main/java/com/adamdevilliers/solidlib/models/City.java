package com.adamdevilliers.solidlib.models;

import java.util.List;

/*
    Solid sdk City model is used to grab the cities response from the api
 */

public class City {

    private int id;
    private String name;
    private List<Mall> malls;

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

    public List<Mall> getMalls() {
        return malls;
    }

    public void setMalls(List<Mall> malls) {
        this.malls = malls;
    }
}
