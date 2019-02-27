package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.fragment.Fragment_Laporan;
import com.biptek.posbiptek.fragment.Fragment_Plus;

public class homeowner extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    TextView namauser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_owner);

        namauser = (TextView)findViewById(R.id.namaUserOwner);

        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottomNavigation3);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                switch (menuItem.getItemId()){
                    case R.id.dashboard:
                        startActivity(new Intent(homeowner.this, homeowner.class));
                        return true;
                    case R.id.plus:
                        selectedFragment = new Fragment_Plus();
                        break;
                        case R.id.Laporan :
                            selectedFragment = new Fragment_Laporan();
                            break;
                    case R.id.More:
                        startActivity(new Intent(homeowner.this, More_admin.class));
                        return true;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerowner,selectedFragment).addToBackStack(null).commit();
                return true;

            }
        });
    }
}
