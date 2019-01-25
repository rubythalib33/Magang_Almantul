package com.biptek.posbiptek.model;

public class TransaksiPenjualan {
    private long kode_penjualan;
    private String username_pegawai_penjualan;
    private String nama_customer;
    private String tanggal_transaksi_penjualan;

    public TransaksiPenjualan(long kode_penjualan, String username_pegawai_penjualan, String nama_customer, String tanggal_transaksi_penjualan) {
        this.kode_penjualan = kode_penjualan;
        this.username_pegawai_penjualan = username_pegawai_penjualan;
        this.nama_customer = nama_customer;
        this.tanggal_transaksi_penjualan = tanggal_transaksi_penjualan;
    }

    public TransaksiPenjualan() {

    }

    public long getKode_penjualan() {
        return kode_penjualan;
    }

    public void setKode_penjualan(long kode_penjualan) {
        this.kode_penjualan = kode_penjualan;
    }

    public String getUsername_pegawai_penjualan() {
        return username_pegawai_penjualan;
    }

    public void setUsername_pegawai_penjualan(String username_pegawai_penjualan) {
        this.username_pegawai_penjualan = username_pegawai_penjualan;
    }

    public String getNama_customer() {
        return nama_customer;
    }

    public void setNama_customer(String nama_customer) {
        this.nama_customer = nama_customer;
    }

    public String getTanggal_transaksi_penjualan() {
        return tanggal_transaksi_penjualan;
    }

    public void setTanggal_transaksi_penjualan(String tanggal_transaksi_penjualan) {
        this.tanggal_transaksi_penjualan = tanggal_transaksi_penjualan;
    }

    @Override
    public String toString() {
        return "TransaksiPenjualan{" +
                "kode_penjualan=" + kode_penjualan +
                ", username_pegawai_penjualan='" + username_pegawai_penjualan + '\'' +
                ", nama_customer='" + nama_customer + '\'' +
                ", tanggal_transaksi_penjualan='" + tanggal_transaksi_penjualan + '\'' +
                '}';
    }
}