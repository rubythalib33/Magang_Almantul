package com.biptek.posbiptek.model;

public class BundleProduk {
    private long kode_bundle;
    private String nama_bundle;
    private int harga_bundle;

    public BundleProduk(long kode_bundle, String nama_bundle, int harga_bundle) {
        this.kode_bundle = kode_bundle;
        this.nama_bundle = nama_bundle;
        this.harga_bundle = harga_bundle;
    }

    public BundleProduk() {

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