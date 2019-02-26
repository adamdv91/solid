package com.adamdevilliers.solid.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adamdevilliers.solid.R;
import com.adamdevilliers.solidlib.models.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ItemViewHolder> {

    private List<Shop> items = new ArrayList<>();

    public void setItems(List<Shop> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ShopAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ShopAdapter.ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.default_recycler_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShopAdapter.ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.shopName.setText(items.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView shopName;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            shopName = itemView.findViewById(R.id.tv_name);
        }
    }
}