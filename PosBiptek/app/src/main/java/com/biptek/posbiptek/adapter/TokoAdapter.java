package com.biptek.posbiptek.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.Toko;

import java.util.ArrayList;

public class TokoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Toko> tokoArrayList;

    public TokoAdapter(Context context, ArrayList<Toko> tokoArrayList){
        this.context = context;
        this.tokoArrayList = tokoArrayList;
    }

    @Override
    public int getCount() {
        return this.tokoArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.tokoArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_view_toko, null);

        TextView namaToko = convertView.findViewById(R.id.textViewNamaToko);
        TextView alamatToko = convertView.findViewById(R.id.textViewAlamatToko);
        TextView noTeleponToko = convertView.findViewById(R.id.textViewNoTeleponToko);

        Toko toko = tokoArrayList.get(position);

        namaToko.setText("Nama Toko: "+toko.getNama_toko());
        alamatToko.setText("Alamat: "+toko.getAlamat_toko());
        noTeleponToko.setText("No. Telepon: "+toko.getNo_telepon_toko());

        return convertView;
    }
}
