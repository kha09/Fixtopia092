package com.example.hsport.fixtopia092;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        LinearLayout linear;
        String col;

        public MyViewHolder(View itemVew) {
            super(itemVew);
            mView = itemVew;
            idapple = mView.findViewById(R.id.tvAppleVersion);
            linear = mView.findViewById(R.id.lin_Inflate);
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mView.getContext(), idapple.getText(), Toast.LENGTH_SHORT).show();

                    //Failed 
                    if (linear.isPressed() == true){
                        linear.setBackgroundColor(Color.parseColor("#0000ff"));

                    }else{
                        linear.setBackgroundColor(Color.parseColor("#FFFFFF"));

                    }

                }
            });
        }
    }

}
