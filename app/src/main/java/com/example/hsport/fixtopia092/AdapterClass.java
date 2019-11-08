package com.example.hsport.fixtopia092;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterClass  extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {
    ArrayList<Phones> list;
    Context context;




    public AdapterClass(ArrayList<Phones> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_list_layout, parent, false);
        context = parent.getContext();
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mobile.setText(list.get(position).getCompany());
//        holder.imageView.setImageResource(R.drawable.bb5);
        String url;
        url = list.get(position).getImage();
        Glide.with(holder.imageView).load(url).into(holder.imageView);
        // getting value from firebase about the company name in english and pass the value to intent
        holder.str = list.get(position).getMobile();
        holder.passCompany = list.get(position).getCompany();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        View myView;
        TextView mobile;
        AppCompatImageView imageView;
        String str;
        String passCompany;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myView = itemView;
            mobile = myView.findViewById(R.id.tvPhones);
            imageView= myView.findViewById(R.id.ivPhones);


            myView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(myView.getContext(), str, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(myView.getContext(), SelectVersion.class);
                    intent.putExtra("Logo", str);
                    intent.putExtra("passCompany", passCompany);
                    context.startActivity(intent);
                }
            });
        }
    }
}
