package com.example.hsport.fixtopia092;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterClass  extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {
    ArrayList<Phones> list;

    public AdapterClass(ArrayList<Phones> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_list_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mobile.setText(list.get(position).getCompany());
//        holder.imageView.setImageResource(R.drawable.bb5);
        String url;
        url = list.get(position).getImage();
        Glide.with(holder.imageView).load(url).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        View myView;
        TextView mobile;
        AppCompatImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myView = itemView;
            mobile = myView.findViewById(R.id.tvPhones);
            imageView= myView.findViewById(R.id.ivPhones);

        }
    }
}
