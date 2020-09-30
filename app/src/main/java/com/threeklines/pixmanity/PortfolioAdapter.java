package com.threeklines.pixmanity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.Holder> {

    private ArrayList<PortfolioProject> projects;

    public PortfolioAdapter(ArrayList<PortfolioProject> projects) {
        this.projects = projects;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.portfolio_item, parent, false);
       return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.layout.setBackgroundResource(projects.get(position).getProjectImage());
        holder.projectName.setText(projects.get(position).getProjectName());
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ConstraintLayout layout;
        TextView projectName;
        public Holder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.project_image);
            projectName = itemView.findViewById(R.id.portfolio_project_name);
        }
    }
}
