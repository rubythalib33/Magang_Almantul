package com.biptek.posbiptek.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.SessionData;
import com.biptek.posbiptek.fragment.Fragment_dataSupplier;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Restock;
import com.biptek.posbiptek.model.Supplier;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class tambahpembelian extends AppCompatActivity {
    Button pProduk, batalPembelian, pilihSupplier, simpanpembelian;
    private ArrayList<Supplier> suppliers;
    private Fragment popSupplier;
    EditText namaSupplier, tanggalPembayaran;
    Calendar calendar2;
    DatePickerDialog.OnDateSetListener date;
    CheckBox bukti;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambahpembelian);

        final CRUD crud = new CRUD(this);
        SessionData sessionData = new SessionData(this);
        calendar2 = Calendar.getInstance();

        pilihSupplier = (Button)findViewById(R.id.btncariSupplier);
        pProduk = (Button)findViewById(R.id.buttonpilihprodukpembelian);
        batalPembelian = (Button)findViewById(R.id.buttonbatalpembelian);
        popSupplier = new Fragment_dataSupplier();
        namaSupplier = (EditText)findViewById(R.id.NamaSuplierSpinner);
        tanggalPembayaran = (EditText)findViewById(R.id.tglBatasPembeayaran);
        simpanpembelian = (Button)findViewById(R.id.simpanpembelian);
        bukti = (CheckBox)findViewById(R.id.checkBox_bukti);
        String tanggalPembelian = getCurrentTime();

        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar2.set(Calendar.YEAR, year);
                calendar2.set(Calendar.MONTH, month);
                calendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        pilihSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.containerPembelian, popSupplier).addToBackStack(null).commit();
            }
        });

        Bundle bundle = new Bundle();
        Intent i = getIntent();
        namaSupplier.setText(i.getStringExtra("namasupplier"));

//        Restock restock = new Restock();
//        restock.setBukti_transaksi_restock("Bukti");
//        restock.setTanggal_jatuh_tempo(tanggalPembayaran.getText().toString());
//        restock.setUsername_pegawai_restock(sessionData.getUsername());
//        restock.setTanggal_transaksi_restock(tanggalPembelian);



        pProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tambahpembelian.this, pilihprodukpembelian.class));
            }
        });

        simpanpembelian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = bukti.isChecked();
                if(checked){
//            restock.setBukti_transaksi_restock(bukti.getText().toString());
                } else
                    Toast.makeText(getApplicationContext(),"centang Sik",Toast.LENGTH_SHORT).show();
            }
        });

        batalPembelian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
    }

    private void updateLabel(){
        String calendarFormat = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(calendarFormat, Locale.US);
        tanggalPembayaran.setText(sdf.format(calendar2.getTime()));
    }

    public void clickDateBatasPembayaran(View view){
        new DatePickerDialog(tambahpembelian.this, date,
                calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH),
                calendar2.get(Calendar.DAY_OF_MONTH)).show();
    }


    public static String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a", Locale.US);
        Date date = new Date();
        return dateFormat.format(date);
    }

}
