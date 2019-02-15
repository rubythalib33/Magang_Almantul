package com.biptek.posbiptek.model;

public class Pemasukan {
    private long kode_data_pemasukan;
    private long kode_toko_pemasukan;
    private String kode_pemasukan;
    private String tanggal_pemasukan;
    private int jumlah_pemasukan;

    public Pemasukan(long kode_data_pemasukan, long kode_toko_pemasukan, String kode_pemasukan, String tanggal_pemasukan, int jumlah_pemasukan) {
        this.kode_data_pemasukan = kode_data_pemasukan;
        this.kode_toko_pemasukan = kode_toko_pemasukan;
        this.kode_pemasukan = kode_pemasukan;
        this.tanggal_pemasukan = tanggal_pemasukan;
        this.jumlah_pemasukan = jumlah_pemasukan;
    }

    public Pemasukan() {

    }

    public long getKode_data_pemasukan() {
        return kode_data_pemasukan;
    }

    public void setKode_data_pemasukan(long kode_data_pemasukan) {
        this.kode_data_pemasukan = kode_data_pemasukan;
    }

    public long getKode_toko_pemasukan() {
        return kode_toko_pemasukan;
    }

    public void setKode_toko_pemasukan(long kode_toko_pemasukan) {
        this.kode_toko_pemasukan = kode_toko_pemasukan;
    }

    public String getKode_pemasukan() {
        return kode_pemasukan;
    }

    public void setKode_pemasukan(String kode_pemasukan) {
        this.kode_pemasukan = kode_pemasukan;
    }

    public String getTanggal_pemasukan() {
        return tanggal_pemasukan;
    }

    public void setTanggal_pemasukan(String tanggal_pemasukan) {
        this.tanggal_pemasukan = tanggal_pemasukan;
    }

    public int getJumlah_pemasukan() {
        return jumlah_pemasukan;
    }

    public void setJumlah_pemasukan(int jumlah_pemasukan) {
        this.jumlah_pemasukan = jumlah_pemasukan;
    }

    @Override
    public String toString() {
        return "Pemasukan{" +
                "kode_data_pemasukan=" + kode_data_pemasukan +
                ", kode_toko_pemasukan=" + kode_toko_pemasukan +
                ", kode_pemasukan='" + kode_pemasukan + '\'' +
                ", tanggal_pemasukan='" + tanggal_pemasukan + '\'' +
                ", jumlah_pemasukan=" + jumlah_pemasukan +
                '}';
    }
}
