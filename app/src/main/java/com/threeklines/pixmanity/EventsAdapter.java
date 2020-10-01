package com.threeklines.pixmanity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {

    ArrayList<EventProject> eventProjects;

    public EventsAdapter(ArrayList<EventProject> eventProjects) {
        this.eventProjects = eventProjects;
    }

    @NonNull
    @Override
    public EventsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_event_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsAdapter.ViewHolder holder, int position) {
        holder.eventImage.setBackgroundResource(eventProjects.get(position).getEventImage());
        holder.eventName.setText(eventProjects.get(position).getEventName());
        holder.eventDate.setText(eventProjects.get(position).getEventDate());
    }

    @Override
    public int getItemCount() {
        return eventProjects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout eventImage;
        TextView eventName;
        TextView eventDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eventImage = itemView.findViewById(R.id.event_layout);
            eventName = itemView.findViewById(R.id.event_name);
            eventDate = itemView.findViewById(R.id.event_date);
        }
    }
}
