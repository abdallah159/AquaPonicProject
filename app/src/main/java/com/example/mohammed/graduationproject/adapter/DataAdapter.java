package com.example.mohammed.graduationproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohammed.graduationproject.R;
import com.example.mohammed.graduationproject.model.Data;

import java.util.List;

/**
 * Created by mohammed on 2/17/18.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    Context context;
    int rowLayout;
    List<Data> data;

    public DataAdapter(Context context, int rowLayout, List<Data> data) {
        this.context = context;
        this.rowLayout = rowLayout;
        this.data = data;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        TextView dateTV;
        TextView tempTV;
        TextView phTV;
        TextView levelTV;

        public DataViewHolder(View itemView) {
            super(itemView);

            dateTV=itemView.findViewById(R.id.date_row);
            tempTV=itemView.findViewById(R.id.temp_rowTV);
            phTV=itemView.findViewById(R.id.ph_rowTV);
            levelTV=itemView.findViewById(R.id.level_rowTV);
        }
    }


    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
//        holder.tempTV.setText(data.get(position).getTemp());
//        holder.phTV.setText(data.get(position).getPh());
//        holder.levelTV.setText(data.get(position).getHighLevel());
        holder.dateTV.setText(data.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
