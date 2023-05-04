package com.example.recycleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.viewholder>{

    private ArrayList<model> model;
    private Context context;

    public InfoAdapter(ArrayList<com.example.recycleapp.model> model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(viewholder holder, int position) {

        holder.name.setText(model.get(position).getTname());
        holder.email.setText(model.get(position).getTemail());
        holder.share.setText(model.get(position).getTidea());

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class viewholder extends RecyclerView.ViewHolder
    {

        TextView name,email,share;

        public viewholder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tnames);
            email = itemView.findViewById(R.id.temails);
            share = itemView.findViewById(R.id.tteet);

        }
    }
}
