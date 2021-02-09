package com.threeklines.pixmanity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.Holder> implements AdapterView.OnItemClickListener {

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
        final int p = position;
        holder.projectName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Item number " + p+1 + "selected", Toast.LENGTH_LONG);

            }
        });
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(parent.getContext(), "Item number " + position+1 + "selected", Toast.LENGTH_LONG).show();


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
