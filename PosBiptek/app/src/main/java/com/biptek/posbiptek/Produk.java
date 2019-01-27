package com.biptek.posbiptek;

public class Produk {
    private String kode_produk;
    private String jenis_produk;
    private String kategori_produk;
    private String nama_produk;
    private String deskripsi_produk;
    private int harga_jual_produk;
    private int harga_beli_produk;
    private String satuan_produk;
    private String gambar_produk;
    private int stok_produk;
    private int stok_kritis_produk;
    private String status_produk;

    public Produk(String kode_produk, String jenis_produk, String kategori_produk, String nama_produk, String deskripsi_produk, int harga_jual_produk, int harga_beli_produk, String satuan_produk, String gambar_produk, int stok_produk, int stok_kritis_produk, String status_produk) {
        this.kode_produk = kode_produk;
        this.jenis_produk = jenis_produk;
        this.kategori_produk = kategori_produk;
        this.nama_produk = nama_produk;
        this.deskripsi_produk = deskripsi_produk;
        this.harga_jual_produk = harga_jual_produk;
        this.harga_beli_produk = harga_beli_produk;
        this.satuan_produk = satuan_produk;
        this.gambar_produk = gambar_produk;
        this.stok_produk = stok_produk;
        this.stok_kritis_produk = stok_kritis_produk;
        this.status_produk = status_produk;
    }

    public Produk (){

    }

    public String getKode_produk() {
        return kode_produk;
    }

    public void setKode_produk(String kode_produk) {
        this.kode_produk = kode_produk;
    }

    public String getJenis_produk() {
        return jenis_produk;
    }

    public void setJenis_produk(String jenis_produk) {
        this.jenis_produk = jenis_produk;
    }

    public String getKategori_produk() {
        return kategori_produk;
    }

    public void setKategori_produk(String kategori_produk) {
        this.kategori_produk = kategori_produk;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getDeskripsi_produk() {
        return deskripsi_produk;
    }

    public void setDeskripsi_produk(String deskripsi_produk) {
        this.deskripsi_produk = deskripsi_produk;
    }

    public int getHarga_jual_produk() {
        return harga_jual_produk;
    }

    public void setHarga_jual_produk(int harga_jual_produk) {
        this.harga_jual_produk = harga_jual_produk;
    }

    public int getHarga_beli_produk() {
        return harga_beli_produk;
    }

    public void setHarga_beli_produk(int harga_beli_produk) {
        this.harga_beli_produk = harga_beli_produk;
    }

    public String getSatuan_produk() {
        return satuan_produk;
    }

    public void setSatuan_produk(String satuan_produk) {
        this.satuan_produk = satuan_produk;
    }

    public String getGambar_produk() {
        return gambar_produk;
    }

    public void setGambar_produk(String gambar_produk) {
        this.gambar_produk = gambar_produk;
    }

    public int getStok_produk() {
        return stok_produk;
    }

    public void setStok_produk(int stok_produk) {
        this.stok_produk = stok_produk;
    }

    public int getStok_kritis_produk() {
        return stok_kritis_produk;
    }

    public void setStok_kritis_produk(int stok_kritis_produk) {
        this.stok_kritis_produk = stok_kritis_produk;
    }

    public String getStatus_produk() {
        return status_produk;
    }

    public void setStatus_produk(String status_produk) {
        this.status_produk = status_produk;
    }

    @Override
    public String toString() {
        return "Produk{" +
                "kode_produk='" + kode_produk + '\'' +
                ", jenis_produk='" + jenis_produk + '\'' +
                ", kategori_produk='" + kategori_produk + '\'' +
                ", nama_produk='" + nama_produk + '\'' +
                ", deskripsi_produk='" + deskripsi_produk + '\'' +
                ", harga_jual_produk=" + harga_jual_produk +
                ", harga_beli_produk=" + harga_beli_produk +
                ", satuan_produk='" + satuan_produk + '\'' +
                ", gambar_produk='" + gambar_produk + '\'' +
                ", stok_produk=" + stok_produk +
                ", stok_kritis_produk=" + stok_kritis_produk +
                ", status_produk='" + status_produk + '\'' +
                '}';
    }
}
