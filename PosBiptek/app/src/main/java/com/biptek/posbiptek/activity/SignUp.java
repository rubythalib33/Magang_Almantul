package com.biptek.posbiptek.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.SessionData;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Perusahaan;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SignUp extends AppCompatActivity {
    Calendar calendar;
    DatePickerDialog.OnDateSetListener date;
    EditText nama, nama_pemilik, password, passwordRe, alamat, tanggal_berdiri, email, no_telepon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_perusahaan);

        calendar = Calendar.getInstance();
        nama = findViewById(R.id.signUp_nama);
        nama_pemilik = findViewById(R.id.signUp_nama_pemilik);
        password = findViewById(R.id.signUp_password);
        passwordRe = findViewById(R.id.signUp_passwordRe);
        alamat = findViewById(R.id.signUp_alamat);
        tanggal_berdiri = findViewById(R.id.signUp_tanggal_berdiri);
        email = findViewById(R.id.signUp_email);
        no_telepon = findViewById(R.id.signUp_no_telepon);

        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
    }

    private void updateLabel(){
        String calendarFormat = "mm/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(calendarFormat, Locale.US);
        tanggal_berdiri.setText(sdf.format(calendar.getTime()));
    }

    public void clickDatePickerSignUp(View view){
        new DatePickerDialog(SignUp.this, date,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void clickSimpanSignUp (View view){
        CRUD crud = new CRUD(this);
        Perusahaan perusahaan = new Perusahaan();
        SessionData sessionData = new SessionData(this);

        if(nama.getText().toString().equals(""))
            nama.setError("Tidak boleh kosong !");
        else
            perusahaan.setNama_perusahaan(nama.getText().toString());

        if(nama_pemilik.getText().toString().equals(""))
            nama_pemilik.setError("Tidak boleh kosong !");
        else
            perusahaan.setNama_pemilik_perusahaan(nama_pemilik.getText().toString());

        if(!password.getText().toString().matches(".{6,}"))
            password.setError("Password minimal 6 karakter !");

        if(passwordRe.getText().toString().matches(".{6,}"))
            passwordRe.setError("Password minimal 6 karakter !");
        else if(passwordRe.getText().toString().equals(password))
            perusahaan.setPassword_perusahaan(password.getText().toString());
        else
            passwordRe.setError("Password tidak sama !");

        if(alamat.getText().toString().equals(""))
            alamat.setError("tidak boleh kosong !");
        else
            perusahaan.setAlamat_perusahaan(alamat.getText().toString());

        if(tanggal_berdiri.getText().toString().equals(""))
            tanggal_berdiri.setError("Tidak boleh kosong !");
        else
            perusahaan.setTanggal_berdiri_perusahaan(tanggal_berdiri.getText().toString());

        if(email.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+\\\\\\\\.+[a-z]+"))
            perusahaan.setEmail_perusahaan(email.getText().toString());
        else
            email.setError("Silahkan isi dengan format email !");

        if(no_telepon.getText().toString().matches("^[0-9,+]{10,}$"))
            perusahaan.setNo_telepon_perusahaan(no_telepon.getText().toString());
        else
            no_telepon.setError("Silahkan isi no telepon dengan benar !");

        crud.open();
        long idPerusahaan = crud.addPerusahaan(perusahaan);
        crud.close();
        if(idPerusahaan != -1){
            sessionData.setKodePerusahaan(idPerusahaan);
            startActivity(new Intent(SignUp.this, MainActivity.class));
            finish();
        }
    }
}
