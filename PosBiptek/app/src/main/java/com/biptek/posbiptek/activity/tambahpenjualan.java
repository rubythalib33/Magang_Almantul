package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.biptek.posbiptek.R;

public class tambahpenjualan extends AppCompatActivity {
    Button simpan, batal, barcode;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambahpenjualan);

        simpan = (Button)findViewById(R.id.buttonsimpanpenjualan);
        batal = (Button)findViewById(R.id.buttonbatalpenjualan);
        barcode = (Button)findViewById(R.id.BarcodePenjualan);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Data berhasil Tersimpan",Toast.LENGTH_SHORT).show();
            }
        });

        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tambahpenjualan.this, homeadmin.class));
            }
        });

        barcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tambahpenjualan.this, BarcodeScanner.class));
            }
        });

    }
}
