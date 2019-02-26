package com.adamdevilliers.solid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.adamdevilliers.solid.R;
import com.adamdevilliers.solid.fragment.DisplayCitiesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.screen_content, new DisplayCitiesFragment())
                .commit();

//        SolidSDK solidSdk = new SolidSDK.Builder().build();
//
//        solidSdk.getCities(new SolidCallback<List<City>>() {
//            @Override
//            public void onSuccess(List<City> data) {
//                city.clear();
//                city.addAll(data);
//
//                //Add city to spinner or RecyclerView
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });
//
//        solidSdk.getCity(1, new SolidCallback<City>() {
//            @Override
//            public void onSuccess(City data) {
//                singleCity = data;
//                //Single data can be displayed in a string; singleCity.getName();
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });
//
//        solidSdk.getMalls(101, new SolidCallback<List<Mall>>() {
//            @Override
//            public void onSuccess(List<Mall> data) {
//                mall.clear();
//                mall.addAll(data);
//
//                for(int i = 0; i < mall.size(); i++){
//                    Log.d(TAG, "This is mall: " + mall.get(i));
//                }
//
//                //Add mall to spinner or RecyclerView
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//            }
//        });
//
//        solidSdk.getMall(1, 1, new SolidCallback<Mall>() {
//            @Override
//            public void onSuccess(Mall data) {
//                singleMall = data;
//                //Single data can be displayed in a string; singleMall.getName();
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });
//
//        solidSdk.getShop(1, 1, new SolidCallback<Shop>() {
//            @Override
//            public void onSuccess(Shop data) {
//                singleShop = data;
//                //Single data can be displayed in a string; singleShop.getName();
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });
//
//        solidSdk.getShops(1, new SolidCallback<List<Shop>>() {
//            @Override
//            public void onSuccess(List<Shop> data) {
//                shops.clear();
//                shops.addAll(data);
//
//                //Add shops to spinner or RecyclerView
//
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });
//
//        solidSdk.getShopsForCity(1, new SolidCallback<List<Shop>>() {
//            @Override
//            public void onSuccess(List<Shop> data) {
//                shops.clear();
//                shops.addAll(data);
//
//                //Add shops to spinner or RecyclerView
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });

    }
}
