package com.biptek.posbiptek.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.biptek.posbiptek.adapter.AdminAdapter;
import com.biptek.posbiptek.fragment.FragmentDeleteConfirmation;
import com.biptek.posbiptek.fragment.Fragment_Admin;
import com.biptek.posbiptek.R;
import com.biptek.posbiptek.adapter.PegawaiAdapter;
import com.biptek.posbiptek.fragment.Fragment_Pegawai;
import com.biptek.posbiptek.model.Admin;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Pegawai;

import java.util.ArrayList;

public class manajemen_user extends AppCompatActivity {

    private Button b1;
    private CRUD crud;
    private Fragment popupUser, popAdmin;
    private Spinner jabatan;
    private ArrayList<Pegawai> arrayList;
    private ArrayList<Admin> arrayList1;
    private ListView listUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manajemenuser);

        jabatan = (Spinner)findViewById(R.id.spinnerJabatanMU);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,
                new String[]{"pegawai","admin"});
        jabatan.setAdapter(arrayAdapter);


        b1 = (Button)findViewById(R.id.buttonTambahUser);
        listUser = (ListView)findViewById(R.id.ListVIewManajemenUser);
        popupUser = new Fragment_Pegawai();
        popAdmin = new Fragment_Admin();
        crud = new CRUD(this);
        String jbtn = "";
        arrayList = new ArrayList<>();
        arrayList1 = new ArrayList<>();

        //untuk menampilkan berdasarkan jabatan user
        jabatan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(jabatan.getSelectedItemPosition()==0){
                    loadDataListView();
                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("kode", 10);
                            popupUser.setArguments(bundle);
                            getSupportFragmentManager().beginTransaction().replace(R.id.layoutdetail, popupUser).addToBackStack(null).commit();
                        }
                    });
                }else if(jabatan.getSelectedItemPosition()==1){
                    loadDataListView1();
                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("key", 20);
                            popAdmin.setArguments(bundle);
                            getSupportFragmentManager().beginTransaction().replace(R.id.layoutdetail, popAdmin).addToBackStack(null).commit();
                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(jabatan.getSelectedItemPosition() == 0)
            loadDataListView();
        else if(jabatan.getSelectedItemPosition() == 1)
            loadDataListView1();
    }

    //fungsi menampilkan data pegawai
    private void loadDataListView() {
        crud.open();
        arrayList = crud.getAllPegawai();
        crud.close();

        if(arrayList.isEmpty()){
            Toast.makeText(getApplicationContext(),"Data Kosong!", Toast.LENGTH_SHORT).show();
        }

        PegawaiAdapter pegawaiAdapter = new PegawaiAdapter(this, arrayList);
        listUser.setAdapter(pegawaiAdapter);

        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("kode", 11);
                bundle.putString("USERNAME", arrayList.get(position).getUsername_pegawai());
                popupUser.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.layoutdetail, popupUser).addToBackStack(null).commit();
            }
        });

        listUser.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment delete = new FragmentDeleteConfirmation();
                Bundle bundle = new Bundle();
                bundle.putString("USERNAME", arrayList.get(position).getUsername_pegawai());
                bundle.putString("menu", "pegawai");
                delete.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.layoutdetail, delete).addToBackStack(null).commit();
                return true;
            }
        });

    }

    //fungsi menampilkan data Admin
    private void loadDataListView1() {
        crud.open();
        arrayList1 = crud.getAllAdmin();
        crud.close();

        if(arrayList1.isEmpty()){
            Toast.makeText(getApplicationContext(),"Data Kosong!",Toast.LENGTH_SHORT).show();
        }

        AdminAdapter adminAdapter = new AdminAdapter(this, arrayList1);
        listUser.setAdapter(adminAdapter);

        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("key", 21);
                bundle.putString("USERNAMEADMIN", arrayList1.get(position).getUsername_admin());
                popAdmin.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.layoutdetail, popAdmin).addToBackStack(null).commit();
            }
        });

        listUser.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment delete = new FragmentDeleteConfirmation();
                Bundle bundle = new Bundle();
                bundle.putString("USERNAMEADMIN", arrayList1.get(position).getUsername_admin());
                bundle.putString("menu", "admin");
                delete.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.layoutdetail, delete).addToBackStack(null).commit();
                return true;
            }
        });

    }
}