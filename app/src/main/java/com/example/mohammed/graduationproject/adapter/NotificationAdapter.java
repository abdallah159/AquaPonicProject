package com.example.mohammed.graduationproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohammed.graduationproject.R;
import com.example.mohammed.graduationproject.model.Data;
import com.example.mohammed.graduationproject.model.Notification;

import java.util.List;

/**
 * Created by mohammed on 2/18/18.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {
    Context context;
    int rowLayout;
    List<Notification> notifications;

    public NotificationAdapter(Context context, int rowLayout, List<Notification> notifications) {
        this.context = context;
        this.rowLayout = rowLayout;
        this.notifications = notifications;
    }

    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new NotificationAdapter.NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder holder, int position) {
        holder.titleTV.setText(notifications.get(position).getAlarmTitle());
        holder.messageTV.setText(notifications.get(position).getMessage());
        holder.timeTV.setText(notifications.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV;
        TextView messageTV;
        TextView timeTV;

        public NotificationViewHolder(View itemView) {
            super(itemView);

            timeTV = itemView.findViewById(R.id.time_notificationTV);
            messageTV = itemView.findViewById(R.id.message_notificationTV);
            titleTV = itemView.findViewById(R.id.title_notificationTV);
        }
    }
}
