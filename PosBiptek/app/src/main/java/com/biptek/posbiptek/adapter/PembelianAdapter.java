package com.biptek.posbiptek.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.activity.TambahPenjualan;
import com.biptek.posbiptek.activity.tambahpembelian;
import com.biptek.posbiptek.model.Produk;

import java.util.ArrayList;

public class PembelianAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Produk> produkArrayList;

    public PembelianAdapter(Context context, ArrayList<Produk> produkArrayList){
        this.context = context;
        this.produkArrayList = produkArrayList;
    }

    @Override
    public int getCount() {
        return this.produkArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.produkArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_view_produk_terbeli, null);

        TextView namaProduk = convertView.findViewById(R.id.pembelianNamaProduk);
        TextView hargaProduk = convertView.findViewById(R.id.pembelianHargaProduk);
        TextView satuanProduk = convertView.findViewById(R.id.pembelianSatuanProduk);
        Button increaseProduk = convertView.findViewById(R.id.pembelianTambahProduk);
        Button decreaseProduk = convertView.findViewById(R.id.pembelianKurangProduk);
        Button cancelProduk = convertView.findViewById(R.id.pembelianCancelProduk);
        final TextView subTotalHarga = convertView.findViewById(R.id.pembelianSubTotalItem);
        final EditText totalProdukBeli = convertView.findViewById(R.id.pembelianJumlah);

        final Produk produk = produkArrayList.get(position);

        satuanProduk.setText(produk.getSatuan_produk());
        namaProduk.setText("Nama Produk: "+produk.getNama_produk());
        hargaProduk.setText("Harga: "+produk.getHarga_jual_produk());
        totalProdukBeli.addTextChangedListener(new TextWatcher() {
            int oldTotal = Integer.parseInt(totalProdukBeli.getText().toString());

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    subTotalHarga.setText(String.valueOf(
                            (produk.getHarga_jual_produk()*Integer.parseInt(totalProdukBeli.getText().toString())
                            )));
                }catch (NumberFormatException e){
                    subTotalHarga.setText("0");
                    totalProdukBeli.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(Integer.parseInt(totalProdukBeli.getText().toString())<0)
                    totalProdukBeli.setText("0");

                if(Integer.parseInt(totalProdukBeli.getText().toString())>produk.getStok_produk())
                    totalProdukBeli.setText(String.valueOf(produk.getStok_produk()));

                if(oldTotal < Integer.parseInt(totalProdukBeli.getText().toString()))
                    ((TambahPenjualan) context).totalBiaya(produk.getHarga_jual_produk(), true);
                else if(oldTotal > Integer.parseInt(totalProdukBeli.getText().toString()))
                    ((TambahPenjualan) context).totalBiaya(produk.getHarga_jual_produk(), false);

                oldTotal = Integer.parseInt(totalProdukBeli.getText().toString());
            }
        });

        increaseProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalProdukBeli.setText(String.valueOf(Integer.parseInt(totalProdukBeli.getText().toString())+1));
            }
        });

        decreaseProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalProdukBeli.setText(String.valueOf(Integer.parseInt(totalProdukBeli.getText().toString())-1));
            }
        });

        cancelProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((tambahpembelian) context).removeIndexKodeProduk(position);
                produkArrayList.remove(produkArrayList.get(position));
                ((tambahpembelian) context).viewListview();
            }
        });

        return convertView;
    }
}
