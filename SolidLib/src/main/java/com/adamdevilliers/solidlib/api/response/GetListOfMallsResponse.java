package com.adamdevilliers.solidlib.api.response;

import com.adamdevilliers.solidlib.api.response.models.Cities;

import java.util.List;

/*
    Solid sdk GetListOfMalls model is used to grab and direct all responses from the api
 */

public class GetListOfMallsResponse {

    private List<Cities> cities;

    public List<Cities> getCities() {
        return cities;
    }

    public void setCities(List<Cities> cities) {
        this.cities = cities;
    }
}
