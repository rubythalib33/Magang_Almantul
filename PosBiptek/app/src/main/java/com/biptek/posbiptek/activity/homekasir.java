package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.biptek.posbiptek.fragment.Fragment_Plus;
import com.biptek.posbiptek.R;

public class homekasir extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    TextView namauser;
    private String namapengguna;
    private String KEY_USERNAME = "namapengguna";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_kasir);

        namauser = (TextView)findViewById(R.id.namaUserkasir);

//        Bundle extras = getIntent().getExtras();
//        namapengguna = extras.getString(KEY_USERNAME);
//        namauser.setText("Hi,"+namapengguna);

        //Bottom Menu
        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottomNavigation2);
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
                        startActivity(new Intent(homekasir.this, More_admin.class));
                        return true;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerkasir,selectedFragment).addToBackStack(null).commit();
                return true;

            }
        });

    }
}
