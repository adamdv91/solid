package com.adamdevilliers.solid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.adamdevilliers.solidlib.SolidSDK;
import com.adamdevilliers.solidlib.SolidCallback;
import com.adamdevilliers.solidlib.models.City;
import com.adamdevilliers.solidlib.models.Mall;
import com.adamdevilliers.solidlib.models.Shop;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<City> city = new ArrayList<>();
    ArrayList<Mall> mall = new ArrayList<>();
    ArrayList<Shop> shops = new ArrayList<>();

    Shop singleShop = new Shop();
    City singleCity = new City();
    Mall singleMall = new Mall();

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SolidSDK solidSdk = new SolidSDK.Builder().build();

        solidSdk.getCities(new SolidCallback<List<City>>() {
            @Override
            public void onSuccess(List<City> data) {
                city.clear();
                city.addAll(data);

                //Add city to spinner or RecyclerView
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        solidSdk.getCity(1, new SolidCallback<City>() {
            @Override
            public void onSuccess(City data) {
                singleCity = data;
                //Single data can be displayed in a string; singleCity.getName();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        solidSdk.getMalls(101, new SolidCallback<List<Mall>>() {
            @Override
            public void onSuccess(List<Mall> data) {
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

        solidSdk.getMall(1, 1, new SolidCallback<Mall>() {
            @Override
            public void onSuccess(Mall data) {
                singleMall = data;
                //Single data can be displayed in a string; singleMall.getName();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        solidSdk.getShop(1, 1, new SolidCallback<Shop>() {
            @Override
            public void onSuccess(Shop data) {
                singleShop = data;
                //Single data can be displayed in a string; singleShop.getName();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        solidSdk.getShops(1, new SolidCallback<List<Shop>>() {
            @Override
            public void onSuccess(List<Shop> data) {
                shops.clear();
                shops.addAll(data);

                //Add shops to spinner or RecyclerView

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        solidSdk.getShopsForCity(1, new SolidCallback<List<Shop>>() {
            @Override
            public void onSuccess(List<Shop> data) {
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
