package com.biptek.posbiptek.model;

public class Toko {
    private long kode_toko;
    private long kode_perusahaan_toko;
    private String nama_toko;
    private String alamat_toko;
    private String no_telepon_toko;

    public Toko(long kode_toko, long kode_perusahaan_toko, String nama_toko, String alamat_toko, String no_telepon_toko) {
        this.kode_toko = kode_toko;
        this.kode_perusahaan_toko = kode_perusahaan_toko;
        this.nama_toko = nama_toko;
        this.alamat_toko = alamat_toko;
        this.no_telepon_toko = no_telepon_toko;
    }

    public Toko(){

    }

    public long getKode_toko() {
        return kode_toko;
    }

    public void setKode_toko(long kode_toko) {
        this.kode_toko = kode_toko;
    }

    public long getKode_perusahaan_toko() {
        return kode_perusahaan_toko;
    }

    public void setKode_perusahaan_toko(long kode_perusahaan_toko) {
        this.kode_perusahaan_toko = kode_perusahaan_toko;
    }

    public String getNama_toko() {
        return nama_toko;
    }

    public void setNama_toko(String nama_toko) {
        this.nama_toko = nama_toko;
    }

    public String getAlamat_toko() {
        return alamat_toko;
    }

    public void setAlamat_toko(String alamat_toko) {
        this.alamat_toko = alamat_toko;
    }

    public String getNo_telepon_toko() {
        return no_telepon_toko;
    }

    public void setNo_telepon_toko(String no_telepon_toko) {
        this.no_telepon_toko = no_telepon_toko;
    }

    @Override
    public String toString() {
        return "Toko{" +
                "kode_toko=" + kode_toko +
                ", kode_perusahaan_toko=" + kode_perusahaan_toko +
                ", nama_toko='" + nama_toko + '\'' +
                ", alamat_toko='" + alamat_toko + '\'' +
                ", no_telepon_toko='" + no_telepon_toko + '\'' +
                '}';
    }
}
