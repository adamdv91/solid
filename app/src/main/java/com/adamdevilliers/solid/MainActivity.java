package com.adamdevilliers.solid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.adamdevilliers.solidlib.SolidSDK;
import com.adamdevilliers.solidlib.SolidCallback;
import com.adamdevilliers.solidlib.api.response.models.Cities;
import com.adamdevilliers.solidlib.api.response.models.Malls;
import com.adamdevilliers.solidlib.api.response.models.Shops;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Cities> city = new ArrayList<>();
    ArrayList<Malls> mall = new ArrayList<>();
    ArrayList<Shops> shops = new ArrayList<>();

    Shops singleShop = new Shops();
    Cities singleCity = new Cities();
    Malls singleMall = new Malls();

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SolidSDK solidSdk = new SolidSDK.Builder().build();

        solidSdk.getCities(new SolidCallback<List<Cities>>() {
            @Override
            public void onSuccess(List<Cities> data) {
                city.clear();
                city.addAll(data);

                //Add city to spinner or RecyclerView
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        solidSdk.getCity(1, new SolidCallback<Cities>() {
            @Override
            public void onSuccess(Cities data) {
                singleCity = data;
                //Single data can be displayed in a string; singleCity.getName();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        solidSdk.getMalls(101, new SolidCallback<List<Malls>>() {
            @Override
            public void onSuccess(List<Malls> data) {
                mall.clear();
                mall.addAll(data);

                for(int i = 0; i < mall.size(); i++){
                    Log.d(TAG, "This is mall: " + mall.get(i));
                }

                //Add mall to spinner or RecyclerView
            }

            @Override
            public void onFailure(Throwable t) {
            }
        });

        solidSdk.getMall(1, 1, new SolidCallback<Malls>() {
            @Override
            public void onSuccess(Malls data) {
                singleMall = data;
                //Single data can be displayed in a string; singleMall.getName();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        solidSdk.getShop(1, 1, new SolidCallback<Shops>() {
            @Override
            public void onSuccess(Shops data) {
                singleShop = data;
                //Single data can be displayed in a string; singleShop.getName();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        solidSdk.getShops(1, new SolidCallback<List<Shops>>() {
            @Override
            public void onSuccess(List<Shops> data) {
                shops.clear();
                shops.addAll(data);

                //Add shops to spinner or RecyclerView

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        solidSdk.getShopsForCity(1, new SolidCallback<List<Shops>>() {
            @Override
            public void onSuccess(List<Shops> data) {
                shops.clear();
                shops.addAll(data);

                //Add shops to spinner or RecyclerView
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }
}
