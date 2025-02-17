package com.threeklines.pixmanity.cfragments;

import android.content.Intent;
import android.os.Bundle;

import android.widget.AdapterView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.threeklines.pixmanity.EventProject;
import com.threeklines.pixmanity.EventsAdapter;
import com.threeklines.pixmanity.PortfolioAdapter;
import com.threeklines.pixmanity.PortfolioProject;
import com.threeklines.pixmanity.R;
import com.threeklines.pixmanity.containers.BookAppointmentContainer;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //View variables
    private RecyclerView portfolio;
    private RecyclerView events;
    private ImageView bookAppointment;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        portfolio = view.findViewById(R.id.portfolio_view);
        portfolio.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        portfolio.setAdapter(new PortfolioAdapter(fillProjects()));



        events = view.findViewById(R.id.events_view);
        events.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        events.setAdapter(new EventsAdapter(fillEvents()));

        bookAppointment = view.findViewById(R.id.new_appointment);
        bookAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), BookAppointmentContainer.class));
            }
        });

        return view;
    }

    private ArrayList<EventProject> fillEvents() {
        ArrayList<EventProject> eventProjects = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            eventProjects.add(new EventProject("Event " + i, R.drawable.event_card_1, "10/" + i * 2));
        }
        return eventProjects;
    }

    private ArrayList<PortfolioProject> fillProjects() {
        ArrayList<PortfolioProject> projects = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            projects.add(new PortfolioProject("Project " + i, R.drawable.home_background_3, new ArrayList<Integer>()));
        }
        return projects;
    }

    class TheListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getContext(), "Item number " + position+1 + "selected", Toast.LENGTH_LONG);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

}