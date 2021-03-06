package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.biptek.posbiptek.SessionData;
import com.biptek.posbiptek.fragment.Fragment_Setting;
import com.biptek.posbiptek.R;

public class More_admin extends AppCompatActivity  {
    ImageButton setting, logout, transfer, backupdata, X;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_admin);

        Bundle extras = getIntent().getExtras();

        final Fragment selectedFragment = new Fragment_Setting();
        X=(ImageButton)findViewById(R.id.imageButton2);
        X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setting = (ImageButton)findViewById(R.id.SettingButton);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.popupsetting, selectedFragment).commit();
                return;
            }
        });


        transfer=(ImageButton)findViewById(R.id.TrasferButton);
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        backupdata = (ImageButton)findViewById(R.id.BackupButton);
        backupdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        logout = (ImageButton)findViewById(R.id.LogoutButton);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionData sessionData = new SessionData(getApplicationContext());
                sessionData.setUsername(null);
                sessionData.setJabatanLogIn(null);
                startActivity(new Intent(More_admin.this, MainActivity.class));
                finish();
            }
        });
    }


}
