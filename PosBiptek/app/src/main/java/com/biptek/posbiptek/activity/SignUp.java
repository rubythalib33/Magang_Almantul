package com.biptek.posbiptek.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.SessionData;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Perusahaan;
import com.mobsandgeeks.saripaar.annotation.Checked;
import com.mobsandgeeks.saripaar.annotation.Order;
import com.mobsandgeeks.saripaar.annotation.Password;

public class SignUp extends AppCompatActivity {
    @Order(1)
    @Checked(message = "Tidak boleh kosong !")
    EditText nama;

    @Order(2)
    @Checked(message = "Tidak boleh kosong !")
    EditText nama_pemilik;

    @Order(3)
    @Password(min = 6, scheme = Password.Scheme.ANY)
    EditText password;

    @Order(4)
    @Checked(message = "Tidak boleh kosong !")
    EditText alamat;

    @Order(5)
    EditText tanggal_berdiri;
    EditText email;
    EditText no_telepon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_perusahaan);

        nama = findViewById(R.id.signUp_nama);
        nama_pemilik = findViewById(R.id.signUp_nama_pemilik);
        password = findViewById(R.id.signUp_password);
        alamat = findViewById(R.id.signUp_alamat);
        //tanggal_berdiri = findViewById(R.id.signUp_tanggal_berdiri);
        email = findViewById(R.id.signUp_email);
        no_telepon = findViewById(R.id.signUp_no_telepon);
    }

    public void clickSimpanSignUp (View view){
        CRUD crud = new CRUD(this);
        Perusahaan perusahaan = new Perusahaan();
        SessionData sessionData = new SessionData(this);

        perusahaan.setNama_pemilik_perusahaan(nama_pemilik.getText().toString());
        perusahaan.setPassword_perusahaan(password.getText().toString());
        perusahaan.setAlamat_perusahaan(alamat.getText().toString());
        perusahaan.setTanggal_berdiri_perusahaan(tanggal_berdiri.getText().toString());
        perusahaan.setEmail_perusahaan(email.getText().toString());
        perusahaan.setNo_telepon_perusahaan(no_telepon.getText().toString());

        crud.open();
        long idPerusahaan = crud.addPerusahaan(perusahaan);
        crud.close();
        sessionData.setKodePerusahaan(idPerusahaan);
    }
}
