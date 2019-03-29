package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Produk;

import java.io.ByteArrayOutputStream;

import me.drakeet.materialdialog.MaterialDialog;

public class TambahProduk extends AppCompatActivity {
    EditText kodeProduk, kategoriProduk, namaProduk, deskripsiProduk, hargaJual,
             hargaBeli, satuanProduk, stokProduk, stokKritisProduk, statusProduk;
    Spinner jenisProduk;
    Button btnGambarProduk;
    ImageView imgGambar;
    private final int kodeKamera = 101;
    private final int kodeGallery = 102;
    private final int kodeBarcode = 1;
    Uri imageUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambahproduk);

        kodeProduk = findViewById(R.id.kodeTambahProduk);
        jenisProduk = findViewById(R.id.jenisTambahProduk);
        kategoriProduk = findViewById(R.id.kategoriTambahProduk);
        namaProduk = findViewById(R.id.namaTambahProduk);
        deskripsiProduk = findViewById(R.id.deskripsiTambahProduk);
        hargaJual = findViewById(R.id.hargaJualTambahProduk);
        hargaBeli = findViewById(R.id.hargaBeliTambahProduk);
        satuanProduk = findViewById(R.id.satuanTambahProduk);
        stokProduk = findViewById(R.id.StokTambahProduk);
        stokKritisProduk = findViewById(R.id.StokKritisTambahProduk);
        statusProduk = findViewById(R.id.statusTambahProduk);
        btnGambarProduk = findViewById(R.id.gambarTambahProduk);
        imgGambar = findViewById(R.id.imageViewGambar);

        ArrayAdapter<String> listJenisProduk = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                new String[]{"barang", "jasa"});
        jenisProduk.setAdapter(listJenisProduk);

        if (getIntent().getStringExtra("mode").equals("update")) {
            CRUD crud = new CRUD(this);
            crud.open();
            Produk produk = crud.getProduk(getIntent().getStringExtra("kode_produk"));
            crud.close();
            kodeProduk.setText("Kode Produk : "+produk.getKode_produk());
            kodeProduk.setEnabled(false);

            byte[] pic = produk.getGambar_produk();
            Bitmap bitmap = BitmapFactory.decodeByteArray(pic, 0, pic.length);

            Button barcodeScanner = findViewById(R.id.BarcodeTambahProduk);
            barcodeScanner.setVisibility(View.INVISIBLE);

            if (!produk.getJenis_produk().equals(jenisProduk.getItemAtPosition(0)))
                jenisProduk.setSelection(1);

            kategoriProduk.setText(produk.getKategori_produk());
            namaProduk.setText(produk.getNama_produk());
            deskripsiProduk.setText(produk.getDeskripsi_produk());
            hargaJual.setText(String.valueOf(produk.getHarga_jual_produk()));
            hargaBeli.setText(String.valueOf(produk.getHarga_beli_produk()));
            satuanProduk.setText(produk.getSatuan_produk());
            imgGambar.setImageBitmap(null);
            stokProduk.setText(String.valueOf(produk.getStok_produk()));
            stokKritisProduk.setText(String.valueOf(produk.getStok_kritis_produk()));
            statusProduk.setText(produk.getStatus_produk());
            imgGambar.setImageBitmap(bitmap);
            TextView updateProduk = findViewById(R.id.textViewTambahProduk);
            updateProduk.setText("Update Produk");

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == kodeGallery){
            imageUri = data.getData();
            imgGambar.setImageURI(imageUri);
        }else if(requestCode == kodeKamera && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgGambar.setImageBitmap(bitmap);
        }
        if(requestCode == kodeBarcode)
            kodeProduk.setText(data.getStringExtra("barcodeResult"));
    }

    public void clickTambahProduk(View view){
        //form validation
        if(kodeProduk.getText().toString().equals("")){
            kodeProduk.setError("Tidak boleh kosong !");
            return;
        }
        if(kategoriProduk.getText().toString().equals("")){
            kategoriProduk.setError("Tidak boleh kosong !");
            return;
        }
        if(namaProduk.getText().toString().equals("")){
            namaProduk.setError("Tidak boleh kosong !");
            return;
        }
        if(deskripsiProduk.getText().toString().equals("")){
            deskripsiProduk.setError("Tidak boleh kosong !");
            return;
        }
        if(hargaJual.getText().toString().equals("")){
            hargaJual.setError("Tidak boleh kosong !");
            return;
        }
        if(hargaBeli.getText().toString().equals("")){
            hargaBeli.setError("Tidak boleh kosong !");
            return;
        }
        if(satuanProduk.getText().toString().equals("")){
            satuanProduk.setError("Tidak boleh kosong !");
            return;
        }
        if(stokProduk.getText().toString().equals("")){
            stokProduk.setError("Tidak boleh kosong !");
            return;
        }
        if(stokKritisProduk.getText().toString().equals("")){
            stokKritisProduk.setError("Tidak boleh kosong !");
            return;
        }
        if(statusProduk.getText().toString().equals("")){
            statusProduk.setError("Tidak boleh kosong !");
            return;
        }
        if(imgGambar.getDrawable() == null){
            Toast.makeText(this,"Anda belum memilih gambar produk !", Toast.LENGTH_SHORT).show();
            return;
        }

        Bitmap bmp = ((BitmapDrawable)imgGambar.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG,0, baos);
        byte[] imgInByte = baos.toByteArray();

        Produk produk = new Produk(
                kodeProduk.getText().toString(),
                jenisProduk.getSelectedItem().toString(),
                kategoriProduk.getText().toString(),
                namaProduk.getText().toString(),
                deskripsiProduk.getText().toString(),
                Integer.parseInt(hargaJual.getText().toString()),
                Integer.parseInt(hargaBeli.getText().toString()),
                satuanProduk.getText().toString(),
                imgInByte,
                Integer.parseInt(stokProduk.getText().toString()),
                Integer.parseInt(stokKritisProduk.getText().toString()),
                statusProduk.getText().toString()
        );
        CRUD crud = new CRUD(this);
        crud.open();
        if (getIntent().getStringExtra("mode").equals("update")) {
            produk.setKode_produk(getIntent().getStringExtra("kode_produk"));
            crud.updateProduk(produk);
            crud.close();
            onBackPressed();
        }
        else if (crud.addProduk(produk)) {
            crud.close();
            onBackPressed();
        }
        else {
            Toast.makeText(this, "Kode Produk sudah digunakan sebelumnya !", Toast.LENGTH_LONG).show();
            crud.close();
        }
    }

    public void clickBatalTambahProduk(View view){
        onBackPressed();
    }

    public void clickBarcodeTambahProduk(View view){
        startActivityForResult(new Intent(TambahProduk.this, BarcodeScanner.class), kodeBarcode);
    }

    public void listDialogue(View view){
        final ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        arrayAdapter.add("Take Photo");
        arrayAdapter.add("Select Gallery");

        ListView listView = new ListView(this);
        listView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        float scale = getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (8 * scale + 0.5f);
        listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
        listView.setDividerHeight(0);
        listView.setAdapter(arrayAdapter);

        final MaterialDialog alert = new MaterialDialog(this).setContentView(listView);

        alert.setPositiveButton("Cancel", new View.OnClickListener() {
            @Override public void onClick(View v) {
                alert.dismiss();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                    alert.dismiss();
                    Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intentCamera, kodeKamera);

                }else {
                    alert.dismiss();
                    Intent intentGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intentGallery, kodeGallery);
                }
            }
        });
        alert.show();
    }

}
