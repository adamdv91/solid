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
import com.adamdevilliers.solid.adapter.MallAdapter;
import com.adamdevilliers.solidlib.SolidCallback;
import com.adamdevilliers.solidlib.SolidSDK;
import com.adamdevilliers.solidlib.models.Mall;

import java.util.List;

import static com.adamdevilliers.solid.fragment.DisplayCitiesFragment.CITY_ID;

public class DisplayMallsFragment extends Fragment implements MallAdapter.MallClickListener {

    public static final String MALL_ID = "MALL_ID";
    RecyclerView recyclerViewMall;
    View rootview;

    MallAdapter mallAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_show_malls, container, false);
        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int getCityValue = getArguments().getInt(CITY_ID);

        recyclerViewMall = rootview.findViewById(R.id.recycler_view_mall);
        recyclerViewMall.setLayoutManager(new LinearLayoutManager(getActivity()));

        mallAdapter = new MallAdapter();
        mallAdapter.setOnItemClickListener(this);

        SolidSDK solidSdk = new SolidSDK.Builder().build();

        solidSdk.getMalls(getCityValue, new SolidCallback<List<Mall>>() {
            @Override
            public void onSuccess(List<Mall> data) {
                mallAdapter.setItems(data);
                recyclerViewMall.setAdapter(mallAdapter);
            }

            @Override
            public void onFailure(Throwable t) {
            }
        });
    }

    @Override
    public void onMallClicked(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(MALL_ID, mallAdapter.getMallId(position));

        ShopsInMallFragment fragment = new ShopsInMallFragment();
        fragment.setArguments(bundle);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.screen_content,fragment)
                .addToBackStack(null)
                .commit();
    }
}
