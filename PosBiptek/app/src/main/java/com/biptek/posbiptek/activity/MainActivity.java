package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.SessionData;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.DatabaseHelper;
import com.biptek.posbiptek.model.Pegawai;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText usernameLogin, passwordLogin;
    private Intent intent;
    private DatabaseHelper mDBHelper;
    private CRUD crud;
    private SessionData sessionData;
    private Pegawai pegawai;
    private String username, password;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDBHelper = new DatabaseHelper(this);
        sessionData = new SessionData(this);
        crud = new CRUD(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }


        usernameLogin = (EditText) findViewById(R.id.usernameLogin);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);


        if(sessionData.getUsername() != null){
            crud.open();
            pegawai = crud.getPegawai(sessionData.getUsername());
            crud.close();
            switch (pegawai.getJabatan_pegawai()) {
                case "admin":
                    intent = new Intent(MainActivity.this, homeadmin.class);
                    startActivity(intent);
                    break;
                case "kasir":
                    intent = new Intent(MainActivity.this, homekasir.class);
                    startActivity(intent);
                    break;
                case "owner":
                    intent = new Intent(MainActivity.this, homeowner.class);
                    startActivity(intent);
                    break;
            }
        }
    }

    public void clickLogin (View view){
        username = usernameLogin.getText().toString();
        password = passwordLogin.getText().toString();
        crud.open();
        pegawai = crud.getPegawai(username);
        crud.close();
        if (username.equals("")) {
            usernameLogin.setError("Tidak Boleh kosong");
            //startActivity(intent);
        } else if (password.equals("")) {
            passwordLogin.setError("Tidak Boleh Kosong");
        } else if (pegawai != null) {
            if (pegawai.getPassword_pegawai().equals(password)) {
                switch (pegawai.getJabatan_pegawai()) {
                    case "admin":
                        sessionData.setUsername(pegawai.getUsername_pegawai());
                        Toast.makeText(this, sessionData.getUsername(), Toast.LENGTH_LONG).show();
                        intent = new Intent(MainActivity.this, homeadmin.class);
                        startActivity(intent);
                        break;
                    case "kasir":
                        intent = new Intent(MainActivity.this, homekasir.class);
                        startActivity(intent);
                        break;
                    case "owner":
                        intent = new Intent(MainActivity.this, homekasir.class);
                        startActivity(intent);
                        break;
                }
            } else
                Toast.makeText(getApplicationContext(), "Username / Password Salah", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(getApplicationContext(), "Username / Password Salah", Toast.LENGTH_SHORT).show();
    }
}