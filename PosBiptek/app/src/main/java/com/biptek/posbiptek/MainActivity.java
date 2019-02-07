package com.biptek.posbiptek;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.biptek.posbiptek.model.*;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper mDBHelper;
    EditText usernameLogin,passwordLogin;
    Button b1;
    private CRUD crud;
    private User user;


    public void onCreate(Bundle savedInstanceState){
        crud.open();public class MainActivity extends AppCompatActivity {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                if(crud.getUser(username) == null){
                    Toast.makeText(getApplicationContext(),"Username Tidak Terdaftar",Toast.LENGTH_SHORT).show();
                }else if(user.getJabatan() == "admin"){
                    Toast.makeText(getApplicationContext(),"Masuk admin",Toast.LENGTH_SHORT).show();
                }else if(user.getJabatan() == "kasir") {
                    Toast.makeText(getApplicationContext(),"Masuk KAsir",Toast.LENGTH_SHORT).show();

                }
                crud.close();
            }
        });
    }

//    private BottomNavigationView bottomNavigationView;
//
//    String [] SPINNER ={"Admin","Kasir","Owner"};
//    @Override
//


    //Bottom Menu
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.home_admin);
//
//        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottomNavigation);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//                if (menuItem.getItemId() == R.id.dashboard){
//
//                }else if(menuItem.getItemId() == R.id.Data){
//
//                }else if(menuItem.getItemId() == R.id.Laporan){
//
//                }else if(menuItem.getItemId() == R.id.More){
//
//                }
//                return false;
//            }
//        });


    //menampilkan spinner jabatan
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,SPINNER);
//        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner) findViewById(R.id.SpinnerJabatan);
//        betterSpinner.setAdapter(arrayAdapter);

//        setContentView(R.layout.home_admin);

//        TextView textView = findViewById(R.id.textView);
//        textView.append(this.getApplicationInfo().dataDir+"\n");
//
//
//        CRUD crud = new CRUD(this);
//        crud.open();
//        crud.addProduk(new Produk("2",
//                "jasa",
//                "komputer",
//                "Install Linux OS",
//                "Ubuntu 18.10",
//                50000,
//                0,
//                "unit",
//                "-",
//                30,
//                0,
//                "baru"));
//        User user = crud.getUser("odhi");
//        List<ListProdukTerjual> produkTerjuals = new ArrayList<>();
//        TransaksiPenjualan transaksiPenjualan = new TransaksiPenjualan(2, user.getUsername(), "putra", "hari ini");
//        produkTerjuals.add(new ListProdukTerjual(transaksiPenjualan.getKode_penjualan(), "1", 11));
//        produkTerjuals.add(new ListProdukTerjual(transaksiPenjualan.getKode_penjualan(), "2", 2));
//        crud.deleteTransaksiPenjualan(transaksiPenjualan);
//        textView.append(crud.getAllTransaksiPenjualan().toString());
//        //textView.append(crud.getListProdukTerjual(transaksiPenjualan.getKode_penjualan()).toString());
//        crud.close()
}
