package com.biptek.posbiptek;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class homekasir extends AppCompatActivity {
    Button dasboard, data, plus, laporan, more;

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_kasir);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("namapengguna");
        TextView nama_pengguna = findViewById(R.id.namaUser);
        nama_pengguna.setText(nama);

        //Bottom Menu
        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                switch (menuItem.getItemId()){
                    case R.id.dashboard:
                        startActivity(new Intent(homekasir.this, homeadmin.class));
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
                        startActivity(new Intent(homekasir.this, More_admin.class));
                        return true;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                return true;

            }
        });

    }
}
