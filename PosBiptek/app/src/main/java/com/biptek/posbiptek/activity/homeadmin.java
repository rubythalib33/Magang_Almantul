package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.biptek.posbiptek.SessionData;
import com.biptek.posbiptek.fragment.Fragment_Data;
import com.biptek.posbiptek.fragment.Fragment_Laporan;
import com.biptek.posbiptek.fragment.Fragment_Plus;
import com.biptek.posbiptek.R;

public class homeadmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_admin);

        SessionData sessionData = new SessionData(this);
        TextView namauser = (TextView) findViewById(R.id.namaUser);
        namauser.setText("Hi, "+ sessionData.getUsername());

        //Bottom Menu
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()){
                        case R.id.dashboard:
                            return true;
                        case R.id.Data:
                            selectedFragment = new Fragment_Data();
                            break;
                        case R.id.plus:
                            selectedFragment = new Fragment_Plus();
                            break;
                        case R.id.Laporan:
                            selectedFragment = new Fragment_Laporan();
                            break;
                        case R.id.More:
                            startActivity(new Intent(homeadmin.this, More_admin.class));
                            return true;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).addToBackStack(null).commit();
                    return true;

                }
            });
    }
}
