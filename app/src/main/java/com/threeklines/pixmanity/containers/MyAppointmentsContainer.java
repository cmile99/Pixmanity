package com.threeklines.pixmanity.containers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.threeklines.pixmanity.cfragments.AccountFragment;
import com.threeklines.pixmanity.cfragments.HomeFragment;
import com.threeklines.pixmanity.cfragments.MyAppointmentsFragment;
import com.threeklines.pixmanity.R;

public class MyAppointmentsContainer extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    MyAppointmentsFragment myAppointmentsFragment;
    HomeFragment homeFragment;
    AccountFragment accountFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appointments_container);

        bottomNavigationView = findViewById(R.id.my_appointments_nav);
        frameLayout = findViewById(R.id.my_appointments_frame);
        myAppointmentsFragment = new MyAppointmentsFragment();
        setFragment(myAppointmentsFragment);
        homeFragment = new HomeFragment();
        accountFragment = new AccountFragment();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.account_item){
                    setFragment(accountFragment);
                    return true;
                }
                if (item.getItemId() == R.id.home_item){
                    setFragment(homeFragment);
                    return true;
                }
                return false;
            }
        });


    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.my_appointments_frame, fragment).commit();
    }
}