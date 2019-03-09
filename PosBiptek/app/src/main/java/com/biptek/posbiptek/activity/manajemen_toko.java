package com.biptek.posbiptek.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.SessionData;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Perusahaan;

public class manajemen_toko extends AppCompatActivity {
    private CRUD crud;
    private EditText NamaPerusahaan,AlamatLengkapPT,NamaPemilikPT,TanggalBerdiriPT,EmailPerusahaan,PasswordLamaPT,PasswordPT;
    private Button SimpanPT,BatalPT;
    private SessionData sessionData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manajementoko);
        crud = new CRUD(this);

        Perusahaan perusahaan = new Perusahaan();
        sessionData = new SessionData(this);
        NamaPerusahaan=findViewById(R.id.NamaPerusahaan);
        AlamatLengkapPT=findViewById(R.id.AlamatLengkapPT);
        NamaPemilikPT= findViewById(R.id.NamaPemilikPT);
        TanggalBerdiriPT=findViewById(R.id.TanggalBerdiriPT);
        EmailPerusahaan=findViewById(R.id.EmailPerusahaan);
        PasswordLamaPT=findViewById(R.id.PasswordLamaPT);
        PasswordPT=findViewById(R.id.passwordPT);

        SimpanPT=findViewById(R.id.SimpanPT);

        crud.open();;
        //nanti ngambil data di shared preferences
        perusahaan = crud.getPerusahaan(sessionData.getKodePerusahaan());
        crud.close();

        NamaPerusahaan.setText(perusahaan.getNama_perusahaan());
        AlamatLengkapPT.setText(perusahaan.getAlamat_perusahaan());
        NamaPemilikPT.setText(perusahaan.getNama_pemilik_perusahaan());
        TanggalBerdiriPT.setText(perusahaan.getTanggal_berdiri_perusahaan());
        EmailPerusahaan.setText(perusahaan.getEmail_perusahaan());

        
    }
}
