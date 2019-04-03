package com.biptek.posbiptek.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.Pengeluaran;

import java.util.ArrayList;

public class PengeluaranAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Pengeluaran> pengeluaranArrayList;

    public PengeluaranAdapter(Context context, ArrayList<Pengeluaran> pengeluaranArrayList){
        this.context = context;
        this.pengeluaranArrayList = pengeluaranArrayList;
    }

    @Override
    public int getCount() {
        return this.pengeluaranArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.pengeluaranArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_view_pengeluaran, null);

        TextView namaTokoPengeluaran = convertView.findViewById(R.id.textViewNamaTokoPengeluaran);
        TextView idPengeluaran = convertView.findViewById(R.id.textViewIdPengeluaran);
        TextView tanggalPengeluaran = convertView.findViewById(R.id.textViewTanggalPengeluaran);
        TextView jumlahPengeluaran = convertView.findViewById(R.id.textViewJumlahPengeluaran);

        Pengeluaran pengeluaran = pengeluaranArrayList.get(position);

        namaTokoPengeluaran.setText("Nama Toko: "+pengeluaran.getKode_toko_pengeluaran());
        idPengeluaran.setText("Kode Pengeluaran: "+pengeluaran.getKode_pengeluaran());
        tanggalPengeluaran.setText("Tanggal: "+pengeluaran.getTanggal_pengeluaran());
        jumlahPengeluaran.setText("Jumlah: "+pengeluaran.getJumlah_pengeluaran());


        return convertView;
    }
}
