package com.adamdevilliers.solidlib.api;

import com.adamdevilliers.solidlib.api.response.GetListOfMallsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

interface SolidService {

    @GET("/v2/5b7e8bc03000005c0084c210/")
    Call<GetListOfMallsResponse> getListOfMalls();

    @GET("/v2/5b7e8bc03000005c0084c210/")
    Call<GetListOfMallsResponse> getCities();

    @GET("/v2/5b7e8bc03000005c0084c210/")
    Call<GetListOfMallsResponse> getMalls();

    @GET("/v2/5b7e8bc03000005c0084c210/")
    Call<GetListOfMallsResponse> getShops();
}
