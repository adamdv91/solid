package com.adamdevilliers.solidlib.api.response.models;

import java.util.List;

/*
    Solid sdk Cities model is used to grab the cities response from the api
 */

public class Cities {

    private int id;
    private String name;
    private List<Malls> malls;

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

    public List<Malls> getMalls() {
        return malls;
    }

    public void setMalls(List<Malls> malls) {
        this.malls = malls;
    }
}
