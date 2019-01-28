package com.biptek.posbiptek.model;

public class ListProdukDiskon {
    private String kode_produk_list_diskon;
    private int besar_diskon;

    public ListProdukDiskon(String kode_produk_list_diskon, int besar_diskon) {
        this.kode_produk_list_diskon = kode_produk_list_diskon;
        this.besar_diskon = besar_diskon;
    }

    public ListProdukDiskon() {

    }

    public String getKode_produk_list_diskon() {
        return kode_produk_list_diskon;
    }

    public void setKode_produk_list_diskon(String kode_produk_list_diskon) {
        this.kode_produk_list_diskon = kode_produk_list_diskon;
    }

    public int getBesar_diskon() {
        return besar_diskon;
    }

    public void setBesar_diskon(int besar_diskon) {
        this.besar_diskon = besar_diskon;
    }

    @Override
    public String toString() {
        return "ListProdukDiskon{" +
                "kode_produk_list_diskon='" + kode_produk_list_diskon + '\'' +
                ", besar_diskon=" + besar_diskon +
                '}';
    }
}
