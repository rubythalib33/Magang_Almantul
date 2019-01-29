package com.biptek.posbiptek.model;

public class TransaksiPenjualan {
    private long kode_penjualan;
    private String kode_user_penjualan;
    private String nama_customer;
    private String tanggal_transaksi_penjualan;

    public TransaksiPenjualan(long kode_penjualan, String kode_user_penjualan, String nama_customer, String tanggal_transaksi_penjualan) {
        this.kode_penjualan = kode_penjualan;
        this.kode_user_penjualan = kode_user_penjualan;
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

    public String getKode_user_penjualan() {
        return kode_user_penjualan;
    }

    public void setKode_user_penjualan(String kode_user_penjualan) {
        this.kode_user_penjualan = kode_user_penjualan;
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
                ", kode_user_penjualan='" + kode_user_penjualan + '\'' +
                ", nama_customer='" + nama_customer + '\'' +
                ", tanggal_transaksi_penjualan='" + tanggal_transaksi_penjualan + '\'' +
                '}';
    }
}

class ListProdukTerjual {
    private long kode_penjualan_list;
    private String kode_produk_list_terjual;
    private int jumlah_produk_terjual;

    public ListProdukTerjual(long kode_penjualan_list, String kode_produk_list_terjual, int jumlah_produk_terjual) {
        this.kode_penjualan_list = kode_penjualan_list;
        this.kode_produk_list_terjual = kode_produk_list_terjual;
        this.jumlah_produk_terjual = jumlah_produk_terjual;
    }

    public ListProdukTerjual() {

    }

    public long getKode_penjualan_list() {
        return kode_penjualan_list;
    }

    public void setKode_penjualan_list(long kode_penjualan_list) {
        this.kode_penjualan_list = kode_penjualan_list;
    }

    public String getKode_produk_list_terjual() {
        return kode_produk_list_terjual;
    }

    public void setKode_produk_list_terjual(String kode_produk_list_terjual) {
        this.kode_produk_list_terjual = kode_produk_list_terjual;
    }

    public int getJumlah_produk_terjual() {
        return jumlah_produk_terjual;
    }

    public void setJumlah_produk_terjual(int jumlah_produk_terjual) {
        this.jumlah_produk_terjual = jumlah_produk_terjual;
    }

    @Override
    public String toString() {
        return "ListProdukTerjual{" +
                "kode_penjualan_list=" + kode_penjualan_list +
                ", kode_produk_list_terjual='" + kode_produk_list_terjual + '\'' +
                ", jumlah_produk_terjual=" + jumlah_produk_terjual +
                '}';
    }
}
