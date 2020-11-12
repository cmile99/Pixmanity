package com.threeklines.pixmanity.cfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.threeklines.pixmanity.PortfolioAdapter;
import com.threeklines.pixmanity.PortfolioProject;
import com.threeklines.pixmanity.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CompletedProjectsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompletedProjectsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    //View variables
    RecyclerView completeProjects;
    ImageView book;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CompletedProjectsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CompletedProjectsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CompletedProjectsFragment newInstance(String param1, String param2) {
        CompletedProjectsFragment fragment = new CompletedProjectsFragment();
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
        View view = inflater.inflate(R.layout.fragment_completed_projects, container, false);
        completeProjects = view.findViewById(R.id.completed_list);
        book = view.findViewById(R.id.completed_book);

        completeProjects.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        completeProjects.setAdapter(new PortfolioAdapter(fillProjects()));
        return view;
    }

    private ArrayList<PortfolioProject> fillProjects() {
        ArrayList<PortfolioProject> projects = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            projects.add(new PortfolioProject("Project " + i, R.drawable.home_background_3, new ArrayList<Integer>()));
        }
        return projects;
    }

}