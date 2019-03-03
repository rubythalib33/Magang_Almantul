package com.biptek.posbiptek.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.Supplier;

import java.util.ArrayList;

public class KontakAdapter extends BaseAdapter {
    private ArrayList<Supplier> supplierArrayList;
    private Context context;

    public KontakAdapter(Context context, ArrayList<Supplier> suppliers){
        this.context = context;
        this.supplierArrayList = suppliers;
    }

    @Override
    public int getCount() {
        return this.supplierArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return supplierArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.customlistkontak,null);

        TextView name = convertView.findViewById(R.id.TVnamaSupplier);
        TextView alamat = convertView.findViewById(R.id.TV_alamatSupllier);
        TextView telp = convertView.findViewById(R.id.TV_notelpSupplier);
        Supplier supplier = supplierArrayList.get(position);

        name.setText("Nama Supplier : "+supplier.getNama_supplier());
        alamat.setText("Alamat : "+supplier.getAlamat_supplier());
        telp.setText("No. Telp : "+supplier.getNo_telepon_supplier());
        return convertView;
    }
}
