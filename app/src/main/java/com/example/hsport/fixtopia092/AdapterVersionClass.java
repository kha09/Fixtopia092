package com.example.hsport.fixtopia092;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterVersionClass extends RecyclerView.Adapter<AdapterVersionClass.MyViewHolder> {
    ArrayList<Versions> list;

    public AdapterVersionClass(ArrayList<Versions> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_select_version, parent , false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.idapple.setText(list.get(position).getIdapple());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView idapple;

        public MyViewHolder(View itemVew) {
            super(itemVew);
            mView = itemVew;
            idapple = mView.findViewById(R.id.tvAppleVersion);
        }
    }

}
