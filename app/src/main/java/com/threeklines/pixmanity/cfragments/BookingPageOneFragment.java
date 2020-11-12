package com.threeklines.pixmanity.cfragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.threeklines.pixmanity.R;
import com.threeklines.pixmanity.containers.BookAppointment2Container;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookingPageOneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookingPageOneFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //View variables
    MaterialButton continueBtn ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BookingPageOneFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookingPageOneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookingPageOneFragment newInstance(String param1, String param2) {
        BookingPageOneFragment fragment = new BookingPageOneFragment();
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
        View view = inflater.inflate(R.layout.fragment_booking_page_one, container, false);

        continueBtn = view.findViewById(R.id.continue_button);
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), BookAppointment2Container.class));
            }
        });
        return view;
    }
}