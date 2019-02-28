package com.biptek.posbiptek.activity;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.*;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper mDBHelper;
    EditText usernameLogin, passwordLogin;
    Button b1;
    private CRUD crud;
    private static String username;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        MainActivity.username = username;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDBHelper = new DatabaseHelper(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        crud = new CRUD(this);


        usernameLogin = (EditText) findViewById(R.id.usernameLogin);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);

        setUsername(usernameLogin.getText().toString());

        final Intent intent = new Intent(MainActivity.this, homeadmin.class);
        final Intent intent1 = new Intent(MainActivity.this, homekasir.class);
        final Intent intent2 = new Intent(this, homeowner.class);

        b1 = (Button) findViewById(R.id.ButtonLogin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = "";
                username = usernameLogin.getText().toString();
                String password = "";
                password = passwordLogin.getText().toString();
                crud.open();
                Pegawai pegawai = crud.getPegawai(username);
                crud.close();
                if (username.equals("")) {
                    usernameLogin.setError("Tidak Boleh kosong");
                    //startActivity(intent);
                } else if (password.equals("")) {
                    passwordLogin.setError("Tidak Boleh Kosong");
                } else if (pegawai != null) {
                    if (pegawai.getPassword_pegawai().equals(password)) {
                        if (pegawai.getJabatan_pegawai().equals("admin")) {
                            startActivity(intent);
                        } else if (pegawai.getJabatan_pegawai().equals("kasir")) {
                            startActivity(intent1);
                        } else if (pegawai.getJabatan_pegawai().equals("owner"))
                            startActivity(intent2);
                    } else
                        Toast.makeText(getApplicationContext(), "Username / Password Salah", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getApplicationContext(), "Username / Password Salah", Toast.LENGTH_SHORT).show();
            }
        });
    }
}