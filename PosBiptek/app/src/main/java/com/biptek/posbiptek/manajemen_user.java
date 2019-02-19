package com.biptek.posbiptek;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class manajemen_user extends AppCompatActivity {

    ListView listUser;
    Button b1;
    private DatabaseHelper mdb;
    private CRUD crud;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manajemenuser);

        b1 = (Button)findViewById(R.id.buttontambahuser);

        listUser = (ListView)findViewById(R.id.ListUser);
        mdb = new DatabaseHelper(this);
        crud = new CRUD(this);
        crud.open();

        ArrayList<String> ListDataUser = new ArrayList<>();
        List dataUser = crud.getAllProduk();

        if(dataUser.isEmpty()){
            Toast.makeText(getApplicationContext(),"Data Kosong", Toast.LENGTH_SHORT).show();
        }else {
            for(int i=0; i<= dataUser.size(); i++){
                ListDataUser.add(dataUser.get(i).toString());
                ListAdapter listAdapter = new ArrayAdapter<>(this, R.layout.daftarproduk);
                listUser.setAdapter(listAdapter);
            }
        }
        crud.close();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(manajemen_user.this, tambahuser.class));
            }
        });

    }
}
