package com.threeklines.pixmanity.containers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.threeklines.pixmanity.cfragments.AccountFragment;
import com.threeklines.pixmanity.cfragments.HomeFragment;
import com.threeklines.pixmanity.cfragments.MyProfile;
import com.threeklines.pixmanity.R;

public class MyProfileContainer extends AppCompatActivity {
    //View variables

    private BottomNavigationView bottomNavigationView;

    //Member variables
    HomeFragment homeFragment;
    AccountFragment accountFragment;
    MyProfile myProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_container);

        bottomNavigationView = findViewById(R.id.profile_bot_nav);
        myProfile = new MyProfile();
        homeFragment = new HomeFragment();
        accountFragment = new AccountFragment();

        setFragment(myProfile);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home_item) {
                    setFragment(homeFragment);
                    return true;
                }
                if (item.getItemId() == R.id.account_item) {
                    setFragment(accountFragment);
                }
                return false;
            }
        });

    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.my_profile_frame, fragment).commit();
    }
}