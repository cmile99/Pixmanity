package com.threeklines.pixmanity.cfragments;

import android.app.Dialog;
import android.app.Notification;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.threeklines.pixmanity.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FullBooking#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FullBooking extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button booking;
    AlertDialog.Builder dialog;

    public FullBooking() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FullBooking.
     */
    // TODO: Rename and change types and number of parameters
    public static FullBooking newInstance(String param1, String param2) {
        FullBooking fragment = new FullBooking();
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
        View view = inflater.inflate(R.layout.fragment_full_booking, container, false);
        booking = view.findViewById(R.id.book_appointment_btn);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 dialog = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
                 dialog.setTitle("Book Appointment")
                         .setMessage("Your appointment has been set for 3 feb at park lodge")
                         .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
//                                 Objects.requireNonNull(getActivity()).finish();
                                 dialog.dismiss();
                                 Toast.makeText(getContext(),  "Yes clicked", Toast.LENGTH_SHORT).show();
                                 NotificationCompat.Builder notification = new NotificationCompat.Builder(getContext());
                                 notification.setSmallIcon(R.drawable.google);
                                 notification.setContentTitle("Book Appointment");
                                 notification.setContentText("Your appointment request has been submited for approval");
                                 notification.setPriority(NotificationCompat.DEFAULT_ALL);

                             }
                         })
                         .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
                                 dialog.cancel();
                                 Toast.makeText(getContext(),"No clicked", Toast.LENGTH_SHORT).show();

                             }
                         })
                         .show();
            }
        });
        return view;
    }
}