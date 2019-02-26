package com.adamdevilliers.solid.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.adamdevilliers.solid.adapter.CityAdapter;
import com.adamdevilliers.solidlib.SolidCallback;
import com.adamdevilliers.solidlib.SolidSDK;
import com.adamdevilliers.solidlib.models.City;

import java.util.List;

public class DisplayCitiesFragment extends Fragment implements CityAdapter.CityClickListener {

    public static final String CITY_ID = "CITY_ID";
    RecyclerView recyclerViewCity;
    View rootview;

    CityAdapter cityAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview =inflater.inflate(R.layout.fragment_show_cities, container, false);
        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewCity = rootview.findViewById(R.id.recycler_view_city);
        recyclerViewCity.setLayoutManager(new LinearLayoutManager(getActivity()));

        cityAdapter = new CityAdapter();

        cityAdapter.setOnItemClickListener(this);

        SolidSDK solidSdk = new SolidSDK.Builder().build();

        solidSdk.getCities(new SolidCallback<List<City>>() {
            @Override
            public void onSuccess(List<City> data) {
                cityAdapter.setItems(data);
                recyclerViewCity.setAdapter(cityAdapter);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    public void onCityClicked(final int position) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getActivity());


        alertDialogBuilder.setTitle("What would you like?");

        alertDialogBuilder
                .setMessage("Whould you like the shops or malls?")
                .setCancelable(false)
                .setPositiveButton("Shops",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {

                        Bundle bundle = new Bundle();
                        bundle.putInt(CITY_ID,cityAdapter.getCityId(position));

                        DisplayShopsInCityFragment fragment = new DisplayShopsInCityFragment();
                        fragment.setArguments(bundle);

                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.screen_content,fragment)
                                .addToBackStack(null)
                                .commit();

                        dialog.cancel();
                    }
                })
                .setNegativeButton("Malls",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {

                        Bundle bundle = new Bundle();
                        bundle.putInt(CITY_ID,cityAdapter.getCityId(position));

                        DisplayMallsFragment fragment = new DisplayMallsFragment();
                        fragment.setArguments(bundle);

                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.screen_content,fragment)
                                .addToBackStack(null)
                                .commit();

                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
}
