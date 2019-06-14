package com.biptek.posbiptek.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.SessionData;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Perusahaan;

public class manajemen_perusahaan extends AppCompatActivity {
    private CRUD crud;
    private EditText NamaPerusahaan,AlamatLengkapPT,NamaPemilikPT, NoTeleponPT,TanggalBerdiriPT,EmailPerusahaan,PasswordLamaPT,PasswordPT;
    private SessionData sessionData;
    private Perusahaan perusahaan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manajemenperusahaan);
        crud = new CRUD(this);

        perusahaan = new Perusahaan();
        sessionData = new SessionData(this);
        NamaPerusahaan=findViewById(R.id.NamaPerusahaan);
        AlamatLengkapPT=findViewById(R.id.AlamatLengkapPT);
        NoTeleponPT=findViewById(R.id.NoTeleponPT);
        NamaPemilikPT= findViewById(R.id.NamaPemilikPT);
        TanggalBerdiriPT=findViewById(R.id.TanggalBerdiriPT);
        EmailPerusahaan=findViewById(R.id.EmailPerusahaan);
        PasswordLamaPT=findViewById(R.id.PasswordLamaPT);
        PasswordPT=findViewById(R.id.passwordPT);

        crud.open();;
        //nanti ngambil data di shared preferences
        perusahaan = crud.getPerusahaan(sessionData.getKodePerusahaan());
        crud.close();

        NamaPerusahaan.setText(perusahaan.getNama_perusahaan());
        AlamatLengkapPT.setText(perusahaan.getAlamat_perusahaan());
        NoTeleponPT.setText(perusahaan.getNo_telepon_perusahaan());
        NamaPemilikPT.setText(perusahaan.getNama_pemilik_perusahaan());
        TanggalBerdiriPT.setText(perusahaan.getTanggal_berdiri_perusahaan());
        EmailPerusahaan.setText(perusahaan.getEmail_perusahaan());

        
    }

    public void clickUpdatePT(View view){
        Perusahaan perusahaanUpdate = new Perusahaan();
        perusahaanUpdate.setKode_perusahaan(sessionData.getKodePerusahaan());

        if(NamaPerusahaan.getText().toString().equals(""))
            NamaPerusahaan.setError("Tidak boleh kosong !");
        else
            perusahaanUpdate.setNama_perusahaan(NamaPerusahaan.getText().toString());

        if(NamaPemilikPT.getText().toString().equals(""))
            NamaPemilikPT.setError("Tidak boleh kosong !");
        else
            perusahaanUpdate.setNama_pemilik_perusahaan(NamaPemilikPT.getText().toString());

        if(!PasswordPT.getText().toString().matches(".{6,}"))
            PasswordPT.setError("Password minimal 6 karakter !");
        else if(PasswordLamaPT.getText().toString().equals(perusahaan.getPassword_perusahaan()))
            perusahaanUpdate.setPassword_perusahaan(PasswordPT.getText().toString());
        else
            PasswordLamaPT.setError("Password Lama salah !");

        if(AlamatLengkapPT.getText().toString().equals(""))
            AlamatLengkapPT.setError("tidak boleh kosong !");
        else
            perusahaanUpdate.setAlamat_perusahaan(AlamatLengkapPT.getText().toString());

        if(TanggalBerdiriPT.getText().toString().equals(""))
            TanggalBerdiriPT.setError("Tidak boleh kosong !");
        else
            perusahaanUpdate.setTanggal_berdiri_perusahaan(TanggalBerdiriPT.getText().toString());

        if(EmailPerusahaan.getText().toString().trim().matches("[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+"))
            perusahaanUpdate.setEmail_perusahaan(EmailPerusahaan.getText().toString());
        else
            EmailPerusahaan.setError("Silahkan isi dengan format email !");

        if(NoTeleponPT.getText().toString().matches("^[0-9,+]{10,}$"))
            perusahaanUpdate.setNo_telepon_perusahaan(NoTeleponPT.getText().toString());
        else
            NoTeleponPT.setError("Silahkan isi no telepon dengan benar !");

        crud.open();
        crud.updatePerusahaan(perusahaanUpdate);
        crud.close();
    }

    public void clickBatalPT(View view){
        this.onBackPressed();
    }
}
