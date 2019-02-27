package com.biptek.posbiptek.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.Produk;

import java.util.ArrayList;

public class ProdukAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Produk> produkArrayList;

    public ProdukAdapter(Context context, ArrayList<Produk> produkArrayList){
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
        convertView = inflater.inflate(R.layout.listviewproduk,null);

        TextView namaProduk = convertView.findViewById(R.id.textView_namaProduk);
        TextView stokProduk = convertView.findViewById(R.id.textView_stokProduk);
        TextView hargaProduk = convertView.findViewById(R.id.textView_hargaProduk);

        Produk produk = produkArrayList.get(position);

        namaProduk.setText("Nama: "+produk.getNama_produk());
        stokProduk.setText("Stok: "+String.valueOf(produk.getStok_produk()));
        hargaProduk.setText("Harga: Rp. "+String.valueOf(produk.getHarga_jual_produk()));

        return convertView;
    }
}
