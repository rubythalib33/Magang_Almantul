package com.biptek.posbiptek.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.Pegawai;
import com.biptek.posbiptek.model.TransaksiPenjualan;

import java.util.ArrayList;

public class PenjualanAdapter extends BaseAdapter {

    private ArrayList<TransaksiPenjualan> arrayListPenjualan;
    Context context;

    public PenjualanAdapter(Context context, ArrayList<TransaksiPenjualan>arrayListPenjualan){
        this.context = context;
        this.arrayListPenjualan = arrayListPenjualan;
    }

    @Override
    public int getCount() {
        return arrayListPenjualan.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListPenjualan.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.customlistpenjualan,null);

        TextView Customer = convertView.findViewById(R.id.TV_Custmoner);
        TextView tanggal = convertView.findViewById(R.id.TV_TanggalPenjualan);
        TextView pegawai = convertView.findViewById(R.id.TV_PegawaiPenjualan);
        TransaksiPenjualan transaksiPenjualan = arrayListPenjualan.get(position);

        Customer.setText("Customer : "+transaksiPenjualan.getNama_customer());
        tanggal.setText("Tanggal : "+transaksiPenjualan.getTanggal_transaksi_penjualan());
        pegawai.setText("Pegawai : "+transaksiPenjualan.getUsername_pegawai_penjualan());
        return convertView;
    }
}
