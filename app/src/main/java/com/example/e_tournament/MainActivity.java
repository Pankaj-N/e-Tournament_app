package com.example.e_tournament;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Homepage()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Homepage()).commit();
                break;
            case R.id.nav_create:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CreateTournament()).commit();
                break;
            case R.id.nav_join:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new JoinTournament()).commit();
                break;
            case R.id.nav_player:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AddPlayer()).commit();
                break;
            case R.id.nav_team:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AddTeam()).commit();
                break;
            case R.id.nav_past:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PastTournament()).commit();
                break;
            case R.id.nav_help:
                Toast.makeText(this, "Downloding..", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_logout:
                Toast.makeText(this, "Logging off", Toast.LENGTH_LONG).show();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}
