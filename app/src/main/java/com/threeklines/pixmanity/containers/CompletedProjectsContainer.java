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
import com.threeklines.pixmanity.cfragments.CompletedProjectsFragment;
import com.threeklines.pixmanity.cfragments.HomeFragment;

public class CompletedProjectsContainer extends AppCompatActivity {
    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment;
    AccountFragment accountFragment;
    CompletedProjectsFragment completedProjectsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_projects_container);

        frameLayout = findViewById(R.id.completed_fame);
        bottomNavigationView = findViewById(R.id.completed_bottom_nav);
        homeFragment = new HomeFragment();
        accountFragment = new AccountFragment();
        completedProjectsFragment = new CompletedProjectsFragment();

        setFragment(completedProjectsFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home_item){
                    setFragment(homeFragment);
                    return true;
                }
                if (item.getItemId() == R.id.account_item){
                    setFragment(accountFragment);
                    return true;
                }
                return false;
            }
        });
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.completed_fame,fragment).commit();
    }
}