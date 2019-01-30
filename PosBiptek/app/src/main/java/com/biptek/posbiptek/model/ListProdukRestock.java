package com.biptek.posbiptek.model;

public class ListProdukRestock {
    private long kode_restock_list;
    private String kode_produk_list;
    private int jumlah_produk_list;

    public ListProdukRestock(long kode_restock_list, String kode_produk_list, int jumlah_produk_list) {
        this.kode_restock_list = kode_restock_list;
        this.kode_produk_list = kode_produk_list;
        this.jumlah_produk_list = jumlah_produk_list;
    }

    public ListProdukRestock() {

    }

    public long getKode_restock_list() {
        return kode_restock_list;
    }

    public void setKode_restock_list(long kode_restock_list) {
        this.kode_restock_list = kode_restock_list;
    }

    public String getKode_produk_list() {
        return kode_produk_list;
    }

    public void setKode_produk_list(String kode_produk_list) {
        this.kode_produk_list = kode_produk_list;
    }

    public int getJumlah_produk_list() {
        return jumlah_produk_list;
    }

    public void setJumlah_produk_list(int jumlah_produk_list) {
        this.jumlah_produk_list = jumlah_produk_list;
    }

    @Override
    public String toString() {
        return "ListProdukRestock{" +
                "kode_restock_list=" + kode_restock_list +
                ", kode_produk_list='" + kode_produk_list + '\'' +
                ", jumlah_produk_list=" + jumlah_produk_list +
                '}';
    }
}
