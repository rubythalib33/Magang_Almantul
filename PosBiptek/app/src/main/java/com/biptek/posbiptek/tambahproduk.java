package com.biptek.posbiptek;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class tambahproduk extends AppCompatActivity {
    Button simpan,batal;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambahproduk);

        simpan = (Button)findViewById(R.id.buttonsimpantambahproduk);
        batal = (Button)findViewById(R.id.bataltambahproduk);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
            }
        });

        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tambahproduk.this, daftarproduk.class);
                startActivity(intent);
            }
        });

    }
}
