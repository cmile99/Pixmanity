package com.threeklines.pixmanity.cfragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.threeklines.pixmanity.R;
import com.threeklines.pixmanity.containers.CompletedProjectsContainer;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProjectsDashFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProjectsDashFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //View variables
    TextView projectsInProjects;
    TextView completedProjects;
    ImageView book;



    public ProjectsDashFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProjectsDashFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProjectsDashFragment newInstance(String param1, String param2) {
        ProjectsDashFragment fragment = new ProjectsDashFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_projects_dash, container, false);
        projectsInProjects = view.findViewById(R.id.p_inProgress);
        completedProjects = view.findViewById(R.id.p_completed);
        book = view.findViewById(R.id.book7);

        completedProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), CompletedProjectsContainer.class));
            }
        });

        return view;
    }
}