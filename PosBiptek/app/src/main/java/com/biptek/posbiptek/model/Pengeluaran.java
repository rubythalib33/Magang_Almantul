package com.biptek.posbiptek.model;

public class Pengeluaran {
    private long kode_data_pengeluaran;
    private long kode_toko_pengeluaran;
    private String kode_pengeluaran;
    private String tanggal_pengeluaran;
    private int jumlah_pengeluaran;

    public Pengeluaran(long kode_data_pengeluaran, long kode_toko_pengeluaran, String kode_pengeluaran, String tanggal_pengeluaran, int jumlah_pengeluaran) {
        this.kode_data_pengeluaran = kode_data_pengeluaran;
        this.kode_toko_pengeluaran = kode_toko_pengeluaran;
        this.kode_pengeluaran = kode_pengeluaran;
        this.tanggal_pengeluaran = tanggal_pengeluaran;
        this.jumlah_pengeluaran = jumlah_pengeluaran;
    }

    public Pengeluaran() {

    }

    public long getKode_data_pengeluaran() {
        return kode_data_pengeluaran;
    }

    public void setKode_data_pengeluaran(long kode_data_pengeluaran) {
        this.kode_data_pengeluaran = kode_data_pengeluaran;
    }

    public long getKode_toko_pengeluaran() {
        return kode_toko_pengeluaran;
    }

    public void setKode_toko_pengeluaran(long kode_toko_pengeluaran) {
        this.kode_toko_pengeluaran = kode_toko_pengeluaran;
    }

    public String getKode_pengeluaran() {
        return kode_pengeluaran;
    }

    public void setKode_pengeluaran(String kode_pengeluaran) {
        this.kode_pengeluaran = kode_pengeluaran;
    }

    public String getTanggal_pengeluaran() {
        return tanggal_pengeluaran;
    }

    public void setTanggal_pengeluaran(String tanggal_pengeluaran) {
        this.tanggal_pengeluaran = tanggal_pengeluaran;
    }

    public int getJumlah_pengeluaran() {
        return jumlah_pengeluaran;
    }

    public void setJumlah_pengeluaran(int jumlah_pengeluaran) {
        this.jumlah_pengeluaran = jumlah_pengeluaran;
    }

    @Override
    public String toString() {
        return "Pengeluaran{" +
                "kode_data_pengeluaran=" + kode_data_pengeluaran +
                ", kode_toko_pengeluaran=" + kode_toko_pengeluaran +
                ", kode_pengeluaran='" + kode_pengeluaran + '\'' +
                ", tanggal_pengeluaran='" + tanggal_pengeluaran + '\'' +
                ", jumlah_pengeluaran=" + jumlah_pengeluaran +
                '}';
    }
}
