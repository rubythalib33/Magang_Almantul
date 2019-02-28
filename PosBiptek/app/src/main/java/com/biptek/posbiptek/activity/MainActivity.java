package com.biptek.posbiptek.activity;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.*;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper mDBHelper;
    EditText usernameLogin, passwordLogin;
    Button b1;
    private CRUD crud;
    private static String username;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        MainActivity.username = username;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDBHelper = new DatabaseHelper(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        crud = new CRUD(this);


        usernameLogin = (EditText) findViewById(R.id.usernameLogin);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);

        setUsername(usernameLogin.getText().toString());

        final Intent intent = new Intent(MainActivity.this, homeadmin.class);
        final Intent intent1 = new Intent(MainActivity.this, homekasir.class);
        final Intent intent2 = new Intent(MainActivity.this, homeowner.class);

<<<<<<< HEAD
            b1=(Button) findViewById(R.id.ButtonLogin);
              b1.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      String username = "";
                      username = usernameLogin.getText().toString();
                      String password = "";
                      password = passwordLogin.getText().toString();
                      crud.open();
                      Pegawai pegawai = crud.getPegawai(username);
                      String jabatan = pegawai.getJabatan_pegawai();
                      crud.close();
                      if (pegawai.equals(null)) {
                          Toast.makeText(getApplicationContext(), "Username / Password Salah", Toast.LENGTH_SHORT).show();
                      }else if (pegawai != null) {
                          if (pegawai.getPassword_pegawai().equals(password)) {
                              if (jabatan.equals("admin")) {
                                  startActivity(intent);
                              } else if (jabatan.equals("kasir")) {
                                  startActivity(intent1);
                              } else if (jabatan.equals("owner"))
                                  startActivity(intent2);
                          } else
                              Toast.makeText(getApplicationContext(), "Username / Password Salah", Toast.LENGTH_SHORT).show();
                      } else
                          Toast.makeText(getApplicationContext(), "Username / Password Salah", Toast.LENGTH_SHORT).show();
                  }
              });
        }




//
//    String [] SPINNER ={"Admin","Kasir","Owner"};
//    @Override
//






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
=======
        b1 = (Button) findViewById(R.id.ButtonLogin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = "";
                username = usernameLogin.getText().toString();
                String password = "";
                password = passwordLogin.getText().toString();
                crud.open();
                Pegawai pegawai = crud.getPegawai(username);
                crud.close();
                if (username.equals("")) {
                    usernameLogin.setError("Tidak Boleh kosong");
                    //startActivity(intent);
                } else if (password.equals("")) {
                    passwordLogin.setError("Tidak Boleh Kosong");
                } else if (pegawai != null) {
                    if (pegawai.getPassword_pegawai().equals(password)) {
                        if (pegawai.getJabatan_pegawai().equals("admin")) {
                            startActivity(intent);
                        } else if (pegawai.getJabatan_pegawai().equals("kasir")) {
                            startActivity(intent1);
                        } else if (pegawai.getJabatan_pegawai().equals("owner"))
                            startActivity(intent2);
                    } else
                        Toast.makeText(getApplicationContext(), "Username / Password Salah", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getApplicationContext(), "Username / Password Salah", Toast.LENGTH_SHORT).show();
            }
        });
>>>>>>> e99a84c7fd9e8d9ff3e9881d16239b8aeead6c5b
    }
}