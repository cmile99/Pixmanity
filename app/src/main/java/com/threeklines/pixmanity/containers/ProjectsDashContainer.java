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
import com.threeklines.pixmanity.cfragments.ProjectsDashFragment;
import com.threeklines.pixmanity.R;

public class ProjectsDashContainer extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment;
    AccountFragment accountFragment;
    ProjectsDashFragment projectsDashFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects_dash_container);
        bottomNavigationView = findViewById(R.id.p_dash_nav);
        homeFragment = new HomeFragment();
        accountFragment = new AccountFragment();
        projectsDashFragment = new ProjectsDashFragment();


        setFragment(projectsDashFragment);
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
        fragmentTransaction.replace(R.id.p_frame_layout, fragment).commit();
        }
}