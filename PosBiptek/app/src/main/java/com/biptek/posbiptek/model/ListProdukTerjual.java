package com.biptek.posbiptek.model;

public class ListProdukTerjual {
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
