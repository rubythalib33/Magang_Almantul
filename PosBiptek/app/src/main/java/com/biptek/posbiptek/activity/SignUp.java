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
import com.mobsandgeeks.saripaar.annotation.Checked;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Order;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.annotation.Pattern;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SignUp extends AppCompatActivity {
    Calendar calendar;
    DatePickerDialog.OnDateSetListener date;

    @Order(1)
    @Checked(message = "Tidak boleh kosong !")
    EditText nama;

    @Order(2)
    @Checked(message = "Tidak boleh kosong !")
    EditText nama_pemilik;

    @Order(3)
    @Password(min = 6, scheme = Password.Scheme.ANY, message = "Password minimal 6 karakter !")
    EditText password;

    @Order(4)
    @ConfirmPassword(message = "Password tidak sesuai !")
    EditText passwordRe;

    @Order(5)
    @Checked(message = "Tidak boleh kosong !")
    EditText alamat;

    @Order(6)
    @Checked(message = "Pilih tanggal terlebih dahulu !")
    EditText tanggal_berdiri;

    @Order(7)
    @Pattern(regex = "[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+", message = "Silahkan isi dengan Format Email !")
    EditText email;

    @Order(8)
    @Pattern(regex = "^[0-9,+]{10,}$", message = "Silahkan isi no telepon")
    EditText no_telepon;

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

        perusahaan.setNama_perusahaan(nama.getText().toString());
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
        startActivity(new Intent(SignUp.this, MainActivity.class));
        finish();
    }
}
