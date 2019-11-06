package com.example.hsport.fixtopia092;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterProblemsClass extends RecyclerView.Adapter<AdapterProblemsClass.MyViewHolder> {
    ArrayList<Problems> list;
    Context context;
    public static int row_index2 = -1;
    public static String vvv = "";

    public AdapterProblemsClass(ArrayList<Problems> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_select_problem, parent, false);
        context = parent.getContext();

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.problem.setText(list.get(position).getProblem());

        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index2 = position;
                notifyDataSetChanged();
            }
        });
        if(row_index2 == position){
            holder.linear.setBackgroundColor(Color.parseColor("#005f70"));
            holder.problem.setTextColor(Color.parseColor("#ffffff"));
            vvv = list.get(position).getProblem();
        }
        else
        {
            holder.linear.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.problem.setTextColor(Color.parseColor("#000000"));
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
        View mView;
        TextView problem;
        LinearLayout linear;
        public MyViewHolder(View itemView){
            super(itemView);
            mView = itemView;
            problem = mView.findViewById(R.id.tvProblems);
            linear = mView.findViewById(R.id.lin_Inflate2);
//            mView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(mView.getContext(), problem.getText(), Toast.LENGTH_SHORT).show();
//                    // change later to button click listener
////                    Intent intent = new Intent(mView.getContext(), select_problem.class);
////                    context.startActivities(new Intent[]{intent});
//
//                }
//            });

        }
    }
}
