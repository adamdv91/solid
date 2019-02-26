package com.adamdevilliers.solidlib.api;

import com.adamdevilliers.solidlib.api.response.MockyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

interface SolidService {

    @GET("/v2/5b7e8bc03000005c0084c210/")
    Call<MockyResponse> getCities();
}
