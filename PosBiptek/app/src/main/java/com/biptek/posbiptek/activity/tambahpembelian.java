package com.biptek.posbiptek.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.SessionData;
import com.biptek.posbiptek.fragment.FragmentPembelian;
import com.biptek.posbiptek.fragment.FragmentPenjualan;
import com.biptek.posbiptek.fragment.Fragment_dataSupplier;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Produk;
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
    ArrayList<Integer> produkPembelianfilter;
    private ArrayList<Produk> items;
    private Fragment popSupplier, popUppilihProduk;
    ListView listPembelian;
    EditText namaSupplier, tanggalPembayaran;
    Calendar calendar2;
    DatePickerDialog.OnDateSetListener date;
    CheckBox bukti;
    CRUD crud;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambahpembelian);

        SessionData sessionData = new SessionData(this);
        calendar2 = Calendar.getInstance();

        pilihSupplier = (Button)findViewById(R.id.btncariSupplier);
        pProduk = (Button)findViewById(R.id.buttonpilihprodukpembelian);
        batalPembelian = (Button)findViewById(R.id.buttonbatalpembelian);
        popSupplier = new Fragment_dataSupplier();
        popUppilihProduk = new FragmentPembelian();
        namaSupplier = (EditText)findViewById(R.id.NamaSuplierSpinner);
        tanggalPembayaran = (EditText)findViewById(R.id.tglBatasPembeayaran);
        simpanpembelian = (Button)findViewById(R.id.simpanpembelian);
        bukti = (CheckBox)findViewById(R.id.checkBox_bukti);
        listPembelian = (ListView)findViewById(R.id.listViewPembelian);
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
//        restock.setTanggal_jatuh_tempo(tanggalPembayaran.getText().toString());
//        restock.setUsername_pegawai_restock(sessionData.getUsername());
//        restock.setTanggal_transaksi_restock(tanggalPembelian);

        pProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putIntegerArrayList("filterProdukPembelian", produkPembelianfilter);
                popUppilihProduk.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.containerPembelian, popUppilihProduk).addToBackStack(null).commit();
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


    public void viewListview(){
        ListAdapter listAdapter = listPembelian.getAdapter();
        if(listAdapter == null)
            return;
        int desireWidth = View.MeasureSpec.makeMeasureSpec(listPembelian.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for(int i = 0; i<listAdapter.getCount(); i++){
            view = listAdapter.getView(i, view, listPembelian);
            if(i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desireWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desireWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();

        }
        ViewGroup.LayoutParams params = listPembelian.getLayoutParams();
        params.height = totalHeight+(listPembelian.getDividerHeight()*(listAdapter.getCount()-1));
        listPembelian.setLayoutParams(params);

    }

    public void addItemBeli(String kodeProduk){
        crud.open();
        items.add(crud.getProduk(kodeProduk));
        crud.close();
    }

    public void addIndexKodeProduk(int position){
        produkPembelianfilter.add(position);
    }

    public void removeIndexKodeProduk(int position){
        produkPembelianfilter.remove(position);
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
