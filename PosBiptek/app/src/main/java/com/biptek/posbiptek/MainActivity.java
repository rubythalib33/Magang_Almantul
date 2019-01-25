package com.biptek.posbiptek;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
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
    EditText usernameLogin, passwordLogin;
    Button b1;
    private CRUD crud;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            mDBHelper =new DatabaseHelper(this);
            try { mDBHelper.updateDataBase();
            } catch(IOException mIOException)
            {
                throw new Error("UnableToUpdateDatabase");
            }
            crud = new CRUD(this);
            crud.open();

            usernameLogin=(EditText) findViewById(R.id.usernameLogin);
            passwordLogin=(EditText) findViewById(R.id.passwordLogin);

        final Intent intent = new Intent();
            b1=(Button) findViewById(R.id.ButtonLogin);
              b1.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      String username = usernameLogin.getText().toString();
                      intent.putExtra("namapengguna", username);
                      startActivity(new Intent(MainActivity.this,homeadmin.class));
//                      String password = passwordLogin.getText().toString();
//                      if (crud.getUser(username) == null) {
//                          Toast.makeText(getApplicationContext(),"Tidak ada Username Terdaftar", Toast.LENGTH_SHORT).show();
//                      } else if (user.getJabatan() == "admin") {
//                          startActivity(new Intent(MainActivity.this,homeadmin.class));
//                      } else if (user.getJabatan() == "kasir") {
//                          startActivity(new Intent(MainActivity.this,homekasir.class));
//                      }
                  }
              });
        crud.close();
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
    }






