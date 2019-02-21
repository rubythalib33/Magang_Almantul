package com.biptek.posbiptek;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.DatabaseHelper;
import com.biptek.posbiptek.model.Pegawai;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.io.IOException;

public class tambahuser extends AppCompatActivity {

    private DatabaseHelper mDBHelper;
    private CRUD crud;
    EditText NamaLengkapTU, UsernameTU, PasswordTU, NomorTeleponTU;
    MaterialBetterSpinner JabatanTU;
    Button simpanTU, batalTU;

    String [] SpinnerList ={"admin", "user"};

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
        batalTU = (Button)findViewById(R.id.BatalTU);

        simpanTU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaLengkapTU = NamaLengkapTU.getText().toString();
                String usernameTU = UsernameTU.getText().toString();
                String passwordTU = PasswordTU.getText().toString();
                String nomorteleponTU = NomorTeleponTU.getText().toString();
                String jabatanTU = String.valueOf(betterSpinner.getText().toString());
                Pegawai pegawai = new Pegawai(usernameTU, (long) 0, passwordTU, jabatanTU, namaLengkapTU, nomorteleponTU);
                crud.open();
                crud.addPegawai(pegawai);
                crud.close();
                Toast.makeText(getApplicationContext(),"Data Berhasil ditambahkan", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
