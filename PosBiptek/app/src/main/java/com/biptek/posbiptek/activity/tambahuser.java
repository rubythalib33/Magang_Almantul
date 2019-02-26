package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.DatabaseHelper;
import com.biptek.posbiptek.model.Pegawai;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.io.IOException;

public class tambahuser extends AppCompatActivity {

    private Toolbar toolbar1;
    private DatabaseHelper mDBHelper;
    private CRUD crud;
    EditText NamaLengkapTU, UsernameTU, PasswordTU, NomorTeleponTU;
    MaterialBetterSpinner JabatanTU;
    Button simpanTU, batalTU;

    String [] SpinnerList ={"admin", "kasir", "owner"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambahuser);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, SpinnerList);
        final MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner)findViewById(R.id.JabatanTU);
        betterSpinner.setAdapter(arrayAdapter);

        NamaLengkapTU = (EditText)findViewById(R.id.NamaLengkapTU);
        UsernameTU = (EditText)findViewById(R.id.UsernameTU);
        PasswordTU = (EditText)findViewById(R.id.PasswordTU);
        NomorTeleponTU = (EditText)findViewById(R.id.NomorTeleponTU);
        JabatanTU = (MaterialBetterSpinner) findViewById(R.id.JabatanTU);

        mDBHelper = new DatabaseHelper(this);
        crud = new CRUD(this);

        try { mDBHelper.updateDataBase();
        } catch(IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }


        simpanTU = (Button)findViewById(R.id.SimpanTU);

        simpanTU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaLengkapTU = "";
                namaLengkapTU = NamaLengkapTU.getText().toString();
                String usernameTU = "";
                usernameTU = UsernameTU.getText().toString();
                String passwordTU = "";
                passwordTU = PasswordTU.getText().toString();
                String nomorteleponTU = "";
                nomorteleponTU = NomorTeleponTU.getText().toString();
                String jabatanTU = "";
                jabatanTU = String.valueOf(betterSpinner.getText().toString());
                Pegawai pegawai = new Pegawai(usernameTU, (long) 0, passwordTU, jabatanTU, namaLengkapTU, nomorteleponTU);
                    if(namaLengkapTU.equals("")||usernameTU.equals("")||passwordTU.equals("")||
                            nomorteleponTU.equals("")||jabatanTU.equals("")||jabatanTU.equals("")){
                        Toast.makeText(getApplicationContext(),"Tidak Boleh kosong",Toast.LENGTH_SHORT).show();
                    }else {
                        crud.open();
                        crud.addPegawai(pegawai);
                        crud.close();
                        startActivity(new Intent(tambahuser.this, manajemen_user.class));
                    }
            }
        });
    }
}
