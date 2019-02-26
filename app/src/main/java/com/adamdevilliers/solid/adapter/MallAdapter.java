package com.adamdevilliers.solid.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adamdevilliers.solid.R;
import com.adamdevilliers.solidlib.models.Mall;

import java.util.ArrayList;
import java.util.List;

public class MallAdapter extends RecyclerView.Adapter<MallAdapter.ItemViewHolder> {

    private List<Mall> items = new ArrayList<>();

    private MallClickListener clickListener;

    public void setOnItemClickListener(MallClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setItems(List<Mall> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MallAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MallAdapter.ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.default_recycler_item, viewGroup, false), clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MallAdapter.ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.mallName.setText(items.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public int getMallId(int position) {
        return items.get(position).getId();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements MallClickListener {

        MallClickListener clickListener;

        TextView mallName;

        public ItemViewHolder(@NonNull View itemView, final MallClickListener clickListener) {
            super(itemView);

            mallName = itemView.findViewById(R.id.tv_name);
            this.clickListener = clickListener;

            mallName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (clickListener != null) {
                        clickListener.onMallClicked(getAdapterPosition());
                    }
                }
            });
        }


        @Override
        public void onMallClicked(int position) {
            if (clickListener != null) {
                clickListener.onMallClicked(getAdapterPosition());
            }
        }
    }

    public interface MallClickListener {
        void onMallClicked(int position);
    }
}