package com.adamdevilliers.solidlib.api.response;

import com.adamdevilliers.solidlib.models.City;

import java.util.List;

/*
    Solid sdk GetListOfMalls model is used to grab and direct all responses from the api
 */

public class MockyResponse {

    private List<City> cities;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
