package com.example.moyoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import fragments.BpReadingsFragments;
import fragments.DataFragment;
//import fragments.DoctorFragment;
import fragments.MyNewDoctorFragment;
import fragments.SettingsFragment;
import fragments.StatisticsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout MdrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set the toolbar as the actionbar
        Toolbar mtoolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(mtoolbar);

        MdrawerLayout = findViewById(R.id.navigationDrawer_layout);

        //get a refference to the navigation view to be able to handle the click events on the menu drawer
        NavigationView mnavigationView = findViewById(R.id.nav_view);

        //set the listener
        mnavigationView.setNavigationItemSelectedListener(this);


        //for rotating the hamburger icon together with the drawer.
        ActionBarDrawerToggle mtoggle = new ActionBarDrawerToggle(this, MdrawerLayout, mtoolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        MdrawerLayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    new BpReadingsFragments()).commit();
            mnavigationView.setCheckedItem(R.id.nav_bp_redeadings);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_bp_redeadings:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new BpReadingsFragments()).commit();
                break;

            case R.id.nav_statistics:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new StatisticsFragment()).commit();
                break;

            case R.id.nav_data:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new DataFragment()).commit();
                break;

            case R.id.nav_my_doctor:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new MyNewDoctorFragment()).commit();
                break;

            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new SettingsFragment()).commit();
                break;
            case R.id.nav_privacy_policy:
                Toast.makeText(this, "Privacy Policy Clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_help_feedback:
                Toast.makeText(this, "Help and Feedback clicked!", Toast.LENGTH_SHORT).show();
                break;
        }
        MdrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (MdrawerLayout.isDrawerOpen(GravityCompat.START)) {
            MdrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();


        }
    }
}
