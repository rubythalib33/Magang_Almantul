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
import com.biptek.posbiptek.model.DatabaseHelper;
import com.biptek.posbiptek.model.Pegawai;

import java.util.ArrayList;

public class manajemen_user extends AppCompatActivity {

    Button b1;
    private DatabaseHelper mdb;
    private CRUD crud;
    private Fragment popupUser, popAdmin;
    private Spinner jabatan;
    ArrayList<Pegawai> arrayList;
    ArrayList<Admin> arrayList1;
    PegawaiAdapter pegawaiAdapter;
    AdminAdapter adminAdapter;
    ListView listpegawai,listadmin;

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
        listpegawai = (ListView)findViewById(R.id.ListUser);
        listadmin = (ListView)findViewById(R.id.ListAdmin);
        popupUser = new Fragment_Pegawai();
        popAdmin = new Fragment_Admin();
        crud = new CRUD(this);
        String jbtn = "";
        jbtn = jabatan.getSelectedItem().toString();
        arrayList = new ArrayList<>();
        arrayList1 = new ArrayList<>();

        //untuk menampilkan berdasarkan jabatan user
        jabatan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(jabatan.getSelectedItemPosition()==0){
                    listadmin.setVisibility(View.INVISIBLE);
                    listpegawai.setVisibility(View.VISIBLE);
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
                    listpegawai.setVisibility(View.INVISIBLE);
                    listadmin.setVisibility(View.VISIBLE);
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

    //fungsi menampilkan data user
    private void loadDataListView() {
        crud.open();
        arrayList = crud.getAllPegawai();
        crud.close();

        if(arrayList.isEmpty()){
            Toast.makeText(getApplicationContext(),"Data Kosong!", Toast.LENGTH_SHORT).show();
        }
        pegawaiAdapter = new PegawaiAdapter(this, arrayList);
        listpegawai.setAdapter(pegawaiAdapter);
        pegawaiAdapter.notifyDataSetChanged();


        listpegawai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("kode", 11);
                bundle.putString("USERNAME", arrayList.get(position).getUsername_pegawai());
                popupUser.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.layoutdetail, popupUser).addToBackStack(null).commit();
            }
        });

        listpegawai.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment delete = new FragmentDeleteConfirmation();
                Bundle bundle = new Bundle();
                bundle.putString("USERNAME", arrayList.get(position).getUsername_pegawai());
                delete.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.layoutdetail, delete).addToBackStack(null).commit();
                return false;
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
        }else

        adminAdapter = new AdminAdapter(this, arrayList1);
        listadmin.setAdapter(adminAdapter);
        pegawaiAdapter.notifyDataSetChanged();

        listadmin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("key", 21);
                bundle.putString("USERNAMEADMIN", arrayList1.get(position).getUsername_admin());
                popupUser.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.layoutdetail2, popAdmin).addToBackStack(null).commit();
            }
        });

        listadmin.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment delete = new FragmentDeleteConfirmation();
                Bundle bundle = new Bundle();
                bundle.putString("USERNAMEADMIN", arrayList1.get(position).getUsername_admin());
                delete.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.layoutdetail2, delete).addToBackStack(null).commit();
                return false;
            }
        });

    }
}