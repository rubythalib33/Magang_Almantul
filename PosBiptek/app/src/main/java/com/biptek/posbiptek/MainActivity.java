package com.biptek.posbiptek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.biptek.posbiptek.model.*;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper mDBHelper;
    EditText usernameLogin,passwordLogin;
    Button b1;
    private CRUD crud;
    private Pegawai pegawai;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crud.open();
        mDBHelper = new DatabaseHelper(this);
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }


        usernameLogin=(EditText)findViewById(R.id.LoginUsername);
        passwordLogin=(EditText)findViewById(R.id.LoginPasssword);
        b1=(Button)findViewById(R.id.ButtonLogin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameLogin.getText().toString();
                String password = passwordLogin.getText().toString();
                if(crud.getPegawai(username) == null){
                    Toast.makeText(getApplicationContext(),"Username Tidak Terdaftar",Toast.LENGTH_SHORT).show();
                }else if(pegawai.getJabatan_pegawai() == "admin"){
                    Toast.makeText(getApplicationContext(),"Masuk admin",Toast.LENGTH_SHORT).show();
                }else if(pegawai.getJabatan_pegawai() == "kasir") {
                    Toast.makeText(getApplicationContext(),"Masuk KAsir",Toast.LENGTH_SHORT).show();

                }
                crud.close();
            }
        });
    }
}
