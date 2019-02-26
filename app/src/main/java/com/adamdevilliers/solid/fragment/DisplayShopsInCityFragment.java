package com.adamdevilliers.solid.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adamdevilliers.solid.R;
import com.adamdevilliers.solid.adapter.ShopAdapter;
import com.adamdevilliers.solidlib.SolidCallback;
import com.adamdevilliers.solidlib.SolidSDK;
import com.adamdevilliers.solidlib.models.Shop;

import java.util.List;

import static com.adamdevilliers.solid.fragment.DisplayCitiesFragment.CITY_ID;

public class DisplayShopsInCityFragment extends Fragment {

    RecyclerView recyclerViewCity;
    View rootview;

    ShopAdapter shopAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_show_shops, container, false);
        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int getCityValue = getArguments().getInt(CITY_ID);

        recyclerViewCity = rootview.findViewById(R.id.recycler_view_shop);
        recyclerViewCity.setLayoutManager(new LinearLayoutManager(getActivity()));

        shopAdapter = new ShopAdapter();

        SolidSDK solidSdk = new SolidSDK.Builder().build();

        solidSdk.getShopsForCity(getCityValue, new SolidCallback<List<Shop>>() {
            @Override
            public void onSuccess(List<Shop> data) {
                shopAdapter.setItems(data);
                recyclerViewCity.setAdapter(shopAdapter);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }
}
