package com.biptek.posbiptek.model;

public class ListProdukRestock {
    private long kode_restock_list;
    private String kode_produk_list_restock;
    private int jumlah_produk_restock;

    public ListProdukRestock(long kode_restock_list, String kode_produk_list_restock, int jumlah_produk_restock) {
        this.kode_restock_list = kode_restock_list;
        this.kode_produk_list_restock = kode_produk_list_restock;
        this.jumlah_produk_restock = jumlah_produk_restock;
    }

    public ListProdukRestock() {

    }

    public long getKode_restock_list() {
        return kode_restock_list;
    }

    public void setKode_restock_list(long kode_restock_list) {
        this.kode_restock_list = kode_restock_list;
    }

    public String getKode_produk_list_restock() {
        return kode_produk_list_restock;
    }

    public void setKode_produk_list_restock(String kode_produk_list_restock) {
        this.kode_produk_list_restock = kode_produk_list_restock;
    }

    public int getJumlah_produk_restock() {
        return jumlah_produk_restock;
    }

    public void setJumlah_produk_restock(int jumlah_produk_restock) {
        this.jumlah_produk_restock = jumlah_produk_restock;
    }

    @Override
    public String toString() {
        return "ListProdukRestock{" +
                "kode_restock_list=" + kode_restock_list +
                ", kode_produk_list_restock='" + kode_produk_list_restock + '\'' +
                ", jumlah_produk_restock=" + jumlah_produk_restock +
                '}';
    }
}
