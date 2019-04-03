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

public class PengeluaranAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Supplier> supplierArrayList;

    public PengeluaranAdapter(Context context, ArrayList<Supplier> supplierArrayList){
        this.context = context;
        this.supplierArrayList = supplierArrayList;
    }

    @Override
    public int getCount() {
        return this.supplierArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.supplierArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_view_pengeluaran, null);

        TextView namaSupplier = convertView.findViewById(R.id.textViewNamaSupplier);
        TextView alamatSupplier = convertView.findViewById(R.id.textViewAlamatSupplier);
        TextView noTeleponSupplier = convertView.findViewById(R.id.textViewNoTeleponSupplier);
        TextView emailSupplier = convertView.findViewById(R.id.textViewEmailSupplier);

        Supplier supplier = supplierArrayList.get(position);

        namaSupplier.setText("Nama Supplier: "+supplier.getNama_supplier());
        alamatSupplier.setText("Alamat: "+supplier.getAlamat_supplier());
        noTeleponSupplier.setText("No. Telepon: "+supplier.getNo_telepon_supplier());
        emailSupplier.setText("E-mail: "+supplier.getEmail_supplier());


        return convertView;
    }
}
