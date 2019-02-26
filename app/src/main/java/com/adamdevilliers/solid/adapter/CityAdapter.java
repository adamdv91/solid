package com.adamdevilliers.solid.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adamdevilliers.solid.R;
import com.adamdevilliers.solidlib.models.City;

import java.util.ArrayList;
import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ItemViewHolder> {

    private List<City> items = new ArrayList<>();

    private CityClickListener clickListener;

    public void setOnItemClickListener(CityClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setItems(List<City> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CityAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CityAdapter.ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.default_recycler_item, viewGroup, false), clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CityAdapter.ItemViewHolder itemViewHolder, int i) {
            itemViewHolder.cityName.setText(items.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public int getCityId(int position) {
        return items.get(position).getId();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements CityClickListener {

        CityClickListener clickListener;

        TextView cityName;

        public ItemViewHolder(@NonNull View itemView, final CityClickListener clickListener) {
            super(itemView);

            cityName = itemView.findViewById(R.id.tv_name);
            this.clickListener = clickListener;

            cityName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (clickListener != null) {
                        clickListener.onCityClicked(getAdapterPosition());
                    }
                }
            });
        }


        @Override
        public void onCityClicked(int position) {
            if (clickListener != null) {
                clickListener.onCityClicked(getAdapterPosition());
            }
        }
    }

    public interface CityClickListener {
        void onCityClicked(int position);
    }
}
