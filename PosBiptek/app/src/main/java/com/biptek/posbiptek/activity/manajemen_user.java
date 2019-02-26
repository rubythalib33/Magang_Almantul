package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.biptek.posbiptek.fragment.Fragment_detail;
import com.biptek.posbiptek.R;
import com.biptek.posbiptek.adapter.PegawaiAdapter;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.DatabaseHelper;
import com.biptek.posbiptek.model.Pegawai;

import java.util.ArrayList;

public class manajemen_user extends AppCompatActivity {

    Button b1;
    private DatabaseHelper mdb;
    private CRUD crud;
    ArrayList<Pegawai> arrayList;
    PegawaiAdapter pegawaiAdapter;
    ListView listpegawai;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manajemenuser);

        b1 = (Button)findViewById(R.id.buttontambahuser);
        listpegawai = (ListView)findViewById(R.id.ListUser);
        mdb = new DatabaseHelper(this);
        crud = new CRUD(this);
        arrayList = new ArrayList<>();
        loadDataListView();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(manajemen_user.this, tambahuser.class));
            }
        });
    }

    private void loadDataListView() {
        crud.open();
        arrayList = crud.getAllPegawai();
        crud.close();
        pegawaiAdapter = new PegawaiAdapter(this, arrayList);
        listpegawai.setAdapter(pegawaiAdapter);
        pegawaiAdapter.notifyDataSetChanged();
        listpegawai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String username = listpegawai.getItemAtPosition(position).toString();

                Bundle bundle = new Bundle();
                bundle.putString("Nama_Pegawai", username);
                Fragment_detail fragment_detail = new Fragment_detail();
                fragment_detail.setArguments(bundle);

                Fragment detail = new Fragment_detail();
                getSupportFragmentManager().beginTransaction().replace(R.id.layoutdetail,detail).addToBackStack(null).commit();
            }
        });
    }
}