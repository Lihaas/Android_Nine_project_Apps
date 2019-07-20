package com.stwalkerster.android.apps.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.itemViewHolder> {

    private String[] data;
public  CarAdapter(String[] data){
    this.data = data;
}
    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item,parent,false);

        return new itemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {
                String name = data[position];
                holder.name.setText(name);
    }

    @Override
    public int getItemCount() {
    //Find the length of data
        return data.length;
    }

    public  class itemViewHolder extends RecyclerView.ViewHolder{
            TextView name;
        public itemViewHolder(@NonNull View itemView) {
            super(itemView);
            // Never get id again
            name = itemView.findViewById(R.id.name);
        }
    }
}
