package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.biptek.posbiptek.SessionData;
import com.biptek.posbiptek.fragment.Fragment_Plus;
import com.biptek.posbiptek.R;

public class homekasir extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_kasir);

        SessionData sessionData = new SessionData(this);
        TextView namauser = findViewById(R.id.namaUserkasir);
        namauser.setText("Hi, "+ sessionData.getUsername());

        //Bottom Menu
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation2);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                switch (menuItem.getItemId()){
                    case R.id.dashboard:
                        startActivity(new Intent(homekasir.this, homekasir.class));
                        return true;
                    case R.id.plus:
                        selectedFragment = new Fragment_Plus();
                        break;
                    case R.id.More:
                        startActivity(new Intent(homekasir.this, moreowner.class));
                        return true;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerkasir,selectedFragment).addToBackStack(null).commit();
                return true;

            }
        });

    }
}
