package com.biptek.posbiptek.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.Produk;

import java.util.ArrayList;

public class PenjualanAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Produk> produkArrayList;

    public PenjualanAdapter(Context context, ArrayList<Produk> produkArrayList){
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_view_produk_terjual, null);

        TextView namaProduk = convertView.findViewById(R.id.penjualanNamaProduk);
        TextView hargaProduk = convertView.findViewById(R.id.penjualanHargaProduk);
        final TextView subTotalHarga = convertView.findViewById(R.id.penjualanSubTotalItem);
        final EditText totalProdukBeli = convertView.findViewById(R.id.penjualanJumlah);

        final Produk produk = produkArrayList.get(position);

        namaProduk.setText("Nama Produk: "+produk.getNama_produk());
        hargaProduk.setText("Harga: "+produk.getHarga_jual_produk());
        totalProdukBeli.addTextChangedListener(new TextWatcher() {
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
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return convertView;
    }
}
