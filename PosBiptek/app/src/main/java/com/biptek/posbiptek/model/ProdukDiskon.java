package com.biptek.posbiptek.model;

public class ProdukDiskon {
    private long kode_diskon;
    private String kode_produk_diskon;
    private int besar_diskon;
    private String tanggal_mulai_berlaku_diskon;
    private String tanggal_berakhir_diskon;

    public ProdukDiskon(long kode_diskon, String kode_produk_diskon, int besar_diskon, String tanggal_mulai_berlaku_diskon, String tanggal_berakhir_diskon) {
        this.kode_diskon = kode_diskon;
        this.kode_produk_diskon = kode_produk_diskon;
        this.besar_diskon = besar_diskon;
        this.tanggal_mulai_berlaku_diskon = tanggal_mulai_berlaku_diskon;
        this.tanggal_berakhir_diskon = tanggal_berakhir_diskon;
    }

    public ProdukDiskon() {

    }

    public long getKode_diskon() {
        return kode_diskon;
    }

    public void setKode_diskon(long kode_diskon) {
        this.kode_diskon = kode_diskon;
    }

    public String getKode_produk_diskon() {
        return kode_produk_diskon;
    }

    public void setKode_produk_diskon(String kode_produk_diskon) {
        this.kode_produk_diskon = kode_produk_diskon;
    }

    public int getBesar_diskon() {
        return besar_diskon;
    }

    public void setBesar_diskon(int besar_diskon) {
        this.besar_diskon = besar_diskon;
    }

    public String getTanggal_mulai_berlaku_diskon() {
        return tanggal_mulai_berlaku_diskon;
    }

    public void setTanggal_mulai_berlaku_diskon(String tanggal_mulai_berlaku_diskon) {
        this.tanggal_mulai_berlaku_diskon = tanggal_mulai_berlaku_diskon;
    }

    public String getTanggal_berakhir_diskon() {
        return tanggal_berakhir_diskon;
    }

    public void setTanggal_berakhir_diskon(String tanggal_berakhir_diskon) {
        this.tanggal_berakhir_diskon = tanggal_berakhir_diskon;
    }

    @Override
    public String toString() {
        return "ProdukDiskon{" +
                "kode_diskon=" + kode_diskon +
                ", kode_produk_diskon='" + kode_produk_diskon + '\'' +
                ", besar_diskon=" + besar_diskon +
                ", tanggal_mulai_berlaku_diskon='" + tanggal_mulai_berlaku_diskon + '\'' +
                ", tanggal_berakhir_diskon='" + tanggal_berakhir_diskon + '\'' +
                '}';
    }
}
