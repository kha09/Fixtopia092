package com.example.hsport.fixtopia092;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterVersionClass extends RecyclerView.Adapter<AdapterVersionClass.MyViewHolder> {
    ArrayList<Versions> list;
    Context context;
    int row_index = -1;
    public static String ccc = "";

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
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.idapple.setText(list.get(position).getIdapple());
        // fixed change color of the layout when its pressed
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index=position;
                notifyDataSetChanged();
            }
        });
        if(row_index==position){
            holder.linear.setBackgroundColor(Color.parseColor("#005f70"));
            holder.idapple.setTextColor(Color.parseColor("#ffffff"));
            ccc = list.get(position).getIdapple();
        }
        else
        {
            holder.linear.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.idapple.setTextColor(Color.parseColor("#000000"));

        }



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView idapple;
        LinearLayout linear;
        Boolean bol = true;

        public MyViewHolder(View itemVew) {
            super(itemVew);
            mView = itemVew;
            idapple = mView.findViewById(R.id.tvAppleVersion);
            linear = mView.findViewById(R.id.lin_Inflate);

//            mView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(mView.getContext(), idapple.getText(), Toast.LENGTH_SHORT).show();
//
////                    //change color and get back to original color choosing multiple layout not fixed
////                    if (linear.isPressed()) {
////
////                        if (bol) {
////                            linear.setBackgroundColor(Color.parseColor("#0000ff"));
////                            bol = false;
////                        }else {
////                            linear.setBackgroundColor(Color.parseColor("#ffffff"));
////                            bol =true;
////
////                        }
////                    }
//
//                }
//            });

        }
    }

}
