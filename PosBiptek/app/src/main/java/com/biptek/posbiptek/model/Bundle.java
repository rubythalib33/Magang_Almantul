package com.biptek.posbiptek.model;

public class Bundle {
    private long kode_bundle;
    private String nama_bundle;
    private int harga_bundle;

    public Bundle(long kode_bundle, String nama_bundle, int harga_bundle) {
        this.kode_bundle = kode_bundle;
        this.nama_bundle = nama_bundle;
        this.harga_bundle = harga_bundle;
    }

    public Bundle() {

    }

    public long getKode_bundle() {
        return kode_bundle;
    }

    public void setKode_bundle(long kode_bundle) {
        this.kode_bundle = kode_bundle;
    }

    public String getNama_bundle() {
        return nama_bundle;
    }

    public void setNama_bundle(String nama_bundle) {
        this.nama_bundle = nama_bundle;
    }

    public int getHarga_bundle() {
        return harga_bundle;
    }

    public void setHarga_bundle(int harga_bundle) {
        this.harga_bundle = harga_bundle;
    }

    @Override
    public String toString() {
        return "Bundle{" +
                "kode_bundle=" + kode_bundle +
                ", nama_bundle='" + nama_bundle + '\'' +
                ", harga_bundle=" + harga_bundle +
                '}';
    }
}

class ListProdukBundle {
    private long kode_bundle_list;
    private String kode_produk_list_bundle;
    private int jumlah_produk_bundle;

    public ListProdukBundle(long kode_bundle_list, String kode_produk_list_bundle, int jumlah_produk_bundle) {
        this.kode_bundle_list = kode_bundle_list;
        this.kode_produk_list_bundle = kode_produk_list_bundle;
        this.jumlah_produk_bundle = jumlah_produk_bundle;
    }

    public ListProdukBundle() {

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