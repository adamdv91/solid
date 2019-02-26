package com.adamdevilliers.solidlib.api;

import com.adamdevilliers.solidlib.api.response.GetListOfMallsResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class SolidClient {

    private SolidService service;
    private Retrofit retrofit;

    private SolidService createService() {
        return getRetrofit().create(SolidService.class);
    }

    private Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(getOkHttp())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .baseUrl("http://www.mocky.io/")
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getOkHttp() {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    private SolidService getService() {
        return service == null ? service = createService() : service;
    }


    public void getListOfMalls(Callback<GetListOfMallsResponse> cb) {
        getService().getListOfMalls().enqueue(cb);
    }

    public void getCities(Callback<GetListOfMallsResponse> cb){
        getService().getCities().enqueue(cb);
    }

    public void getMalls(Callback<GetListOfMallsResponse> cb){
        getService().getMalls().enqueue(cb);
    }

    public void getShops(Callback<GetListOfMallsResponse> cb){
        getService().getShops().enqueue(cb);
    }
}