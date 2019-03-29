package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.SessionData;
import com.biptek.posbiptek.model.Admin;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.DatabaseHelper;
import com.biptek.posbiptek.model.Pegawai;
import com.biptek.posbiptek.model.Perusahaan;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText usernameLogin, passwordLogin;
    private Spinner loginSpinner;
    private CRUD crud;
    private SessionData sessionData;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper mDBHelper = new DatabaseHelper(this);
        sessionData = new SessionData(this);
        crud = new CRUD(this);

        //Mengecek database(belum ada/terjadi perubahan versi database)
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        usernameLogin = findViewById(R.id.usernameLogin);
        passwordLogin = findViewById(R.id.passwordLogin);
        loginSpinner = findViewById(R.id.SpinnerLogin);

        ArrayAdapter<String> listJabatan = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                new String[]{"owner", "admin", "pegawai"});
        loginSpinner.setAdapter(listJabatan);

        //Mengecek kode perusahaan (apakah perlu signUp)
        if(sessionData.getKodePerusahaan() == -1){
            startActivity(new Intent(MainActivity.this, SignUp.class));
            finish();
        }

        //mengecek apakah sebelumnya user sudah login dengan akun tertentu (Owner, Admin, Pegawai)
        if(sessionData.getUsername() != null){
            switch (sessionData.getJabatanLogIn()) {
                case "admin":
                    startActivity(new Intent(MainActivity.this, homeadmin.class));
                    finish();
                    break;
                case "pegawai":
                    startActivity(new Intent(MainActivity.this, homekasir.class));
                    finish();
                    break;
                case "owner":
                    startActivity(new Intent(MainActivity.this, homeowner.class));
                    finish();
                    break;
            }
        }

        loginSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(loginSpinner.getSelectedItemPosition() == 0)
                    usernameLogin.setVisibility(View.INVISIBLE);
                else
                    usernameLogin.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void clickLogin (View view){
        String username = usernameLogin.getText().toString();
        String password = passwordLogin.getText().toString();

        if (username.equals("") && loginSpinner.getSelectedItemPosition() != 0)
            usernameLogin.setError("Tidak Boleh kosong");
        else if (password.equals(""))
            passwordLogin.setError("Tidak Boleh Kosong");
        else {
            switch (loginSpinner.getSelectedItem().toString()) {
                case "admin":
                    crud.open();
                    Admin admin = crud.getAdmin(username);
                    crud.close();
                    if(admin != null && admin.getPassword_admin().equals(password)){
                        sessionData.setUsername(admin.getUsername_admin());
                        sessionData.setJabatanLogIn("admin");
                        startActivity(new Intent(MainActivity.this, homeadmin.class));
                        finish();
                    }
                    else Toast.makeText(getApplicationContext(), "Username / Password Salah", Toast.LENGTH_SHORT).show();
                    break;
                case "pegawai":
                    crud.open();
                    Pegawai pegawai = crud.getPegawai(username);
                    crud.close();
                    if(pegawai != null && pegawai.getPassword_pegawai().equals(password)){
                        sessionData.setUsername(pegawai.getUsername_pegawai());
                        sessionData.setJabatanLogIn("pegawai");
                        startActivity(new Intent(MainActivity.this, homekasir.class));
                        finish();
                    }
                    else Toast.makeText(getApplicationContext(), "Username / Password Salah", Toast.LENGTH_SHORT).show();
                    break;
                case "owner":
                    crud.open();
                    Perusahaan perusahaan = crud.getPerusahaan(sessionData.getKodePerusahaan());
                    crud.close();
                    if(perusahaan.getPassword_perusahaan().equals(password)){
                        sessionData.setUsername(perusahaan.getNama_pemilik_perusahaan());
                        sessionData.setJabatanLogIn("owner");
                        startActivity(new Intent(MainActivity.this, homekasir.class));
                        finish();
                    }
                    else Toast.makeText(getApplicationContext(), "Password Salah", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}