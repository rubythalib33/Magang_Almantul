package com.biptek.posbiptek.activity;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.adapter.PenjualanAdapter;
import com.biptek.posbiptek.model.*;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.io.IOException;
import java.security.acl.Owner;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper mDBHelper;
    EditText usernameLogin, passwordLogin;
    Button b1;
    private CRUD crud;
    private static String username;

    MaterialBetterSpinner jabatan;
    String [] SpinnerList ={"admin", "pegawai"};

    public static String getUsername() {
        return username;
    }
    public static void setUsername(String username) {
        MainActivity.username = username;
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, SpinnerList);
        final MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner)findViewById(R.id.JabatanLogin);
        betterSpinner.setAdapter(arrayAdapter);

        mDBHelper = new DatabaseHelper(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        crud = new CRUD(this);


        usernameLogin = (EditText) findViewById(R.id.usernameLogin);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);
        jabatan = (MaterialBetterSpinner)findViewById(R.id.JabatanLogin);

        setUsername(usernameLogin.getText().toString());

        final Intent intent = new Intent(MainActivity.this, homeadmin.class);
        final Intent intent1 = new Intent(MainActivity.this, homekasir.class);


        b1 = (Button) findViewById(R.id.ButtonLogin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = "";
                username = usernameLogin.getText().toString();
                String password = "";
                password = passwordLogin.getText().toString();
                String jabatanLogin = "";
                jabatanLogin = String.valueOf(betterSpinner.getText().toString());
                if (username.equals("")|| password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Username / Password Salah", Toast.LENGTH_SHORT).show();
                }else if(jabatanLogin.equals("admin")) {
                    crud.open();
                    Admin admin = crud.getAdmin(username);
                    crud.close();
                    if (admin.getPassword_admin().equals(password)) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Username / Password Salah", Toast.LENGTH_SHORT).show();
                    }
                }else if (jabatanLogin.equals("pegawai")) {
                    crud.open();
                    Pegawai pegawai = crud.getPegawai(username);
                    crud.close();
                    if(pegawai.getPassword_pegawai().equals(password)){
                        startActivity(intent1);
                    }else{
                        Toast.makeText(getApplicationContext(), "Username / Password Salah", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Username / Password Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
       }
    }