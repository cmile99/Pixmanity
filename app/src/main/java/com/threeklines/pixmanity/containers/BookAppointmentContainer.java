package com.threeklines.pixmanity.containers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.threeklines.pixmanity.R;
import com.threeklines.pixmanity.cfragments.AccountFragment;
import com.threeklines.pixmanity.cfragments.BookingPageOneFragment;
import com.threeklines.pixmanity.cfragments.HomeFragment;

public class BookAppointmentContainer extends AppCompatActivity {

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment;
    AccountFragment accountFragment;
    BookingPageOneFragment bookingPageOneFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment_container);
        frameLayout = findViewById(R.id.booking_frame1);
        bottomNavigationView = findViewById(R.id.booking_one_nav);
        homeFragment = new HomeFragment();
        accountFragment = new AccountFragment();
        bookingPageOneFragment = new BookingPageOneFragment();

        setFragment(bookingPageOneFragment);

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

    private void setFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.booking_frame1,fragment);
    }
}