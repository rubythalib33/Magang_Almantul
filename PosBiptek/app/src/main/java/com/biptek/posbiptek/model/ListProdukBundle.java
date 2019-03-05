package com.biptek.posbiptek.model;

public class ListProdukBundle {
    private long id_list_produk_bundle;
    private long kode_bundle_list;
    private String kode_produk_list_bundle;
    private int jumlah_produk_bundle;

    public ListProdukBundle(long id_list_produk_bundle, long kode_bundle_list, String kode_produk_list_bundle, int jumlah_produk_bundle) {
        this.id_list_produk_bundle = id_list_produk_bundle;
        this.kode_bundle_list = kode_bundle_list;
        this.kode_produk_list_bundle = kode_produk_list_bundle;
        this.jumlah_produk_bundle = jumlah_produk_bundle;
    }

    public ListProdukBundle(String kode_produk_list_bundle, int jumlah_produk_bundle) {
        this.kode_produk_list_bundle = kode_produk_list_bundle;
        this.jumlah_produk_bundle = jumlah_produk_bundle;
    }

    public ListProdukBundle() {

    }

    public long getId_list_produk_bundle() {
        return id_list_produk_bundle;
    }

    public void setId_list_produk_bundle(long id_list_produk_bundle) {
        this.id_list_produk_bundle = id_list_produk_bundle;
    }

    public long getKode_bundle_list() {
        return kode_bundle_list;
    }

    public void setKode_bundle_list(long kode_bundle_list) {
        this.kode_bundle_list = kode_bundle_list;
    }

    public String getKode_produk_list_bundle() {
        return kode_produk_list_bundle;
    }

    public void setKode_produk_list_bundle(String kode_produk_list_bundle) {
        this.kode_produk_list_bundle = kode_produk_list_bundle;
    }

    public int getJumlah_produk_bundle() {
        return jumlah_produk_bundle;
    }

    public void setJumlah_produk_bundle(int jumlah_produk_bundle) {
        this.jumlah_produk_bundle = jumlah_produk_bundle;
    }

    @Override
    public String toString() {
        return "ListProdukBundle{" +
                "kode_bundle_list=" + kode_bundle_list +
                ", kode_produk_list_bundle='" + kode_produk_list_bundle + '\'' +
                ", jumlah_produk_bundle=" + jumlah_produk_bundle +
                '}';
    }
}
