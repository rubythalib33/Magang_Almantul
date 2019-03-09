package com.biptek.posbiptek.model;

public class Perusahaan {
    private long kode_perusahaan;
    private String nama_perusahaan;
    private String nama_pemilik_perusahaan;
    private String password_perusahaan;
    private String alamat_perusahaan;
    private String tanggal_berdiri_perusahaan;
    private String email_perusahaan;
    private String no_telepon_perusahaan;

    public Perusahaan(long kode_perusahaan, String nama_perusahaan, String nama_pemilik_perusahaan, String password_perusahaan, String alamat_perusahaan, String tanggal_berdiri_perusahaan, String email_perusahaan, String no_telepon_perusahaan) {
        this.kode_perusahaan = kode_perusahaan;
        this.nama_perusahaan = nama_perusahaan;
        this.nama_pemilik_perusahaan = nama_pemilik_perusahaan;
        this.password_perusahaan = password_perusahaan;
        this.alamat_perusahaan = alamat_perusahaan;
        this.tanggal_berdiri_perusahaan = tanggal_berdiri_perusahaan;
        this.email_perusahaan = email_perusahaan;
        this.no_telepon_perusahaan = no_telepon_perusahaan;
    }

    public Perusahaan(){

    }

    public long getKode_perusahaan() {
        return kode_perusahaan;
    }

    public void setKode_perusahaan(long kode_perusahaan) {
        this.kode_perusahaan = kode_perusahaan;
    }

    public String getNama_perusahaan() {
        return nama_perusahaan;
    }

    public void setNama_perusahaan(String nama_perusahaan) {
        this.nama_perusahaan = nama_perusahaan;
    }

    public String getNama_pemilik_perusahaan() {
        return nama_pemilik_perusahaan;
    }

    public void setNama_pemilik_perusahaan(String nama_pemilik_perusahaan) {
        this.nama_pemilik_perusahaan = nama_pemilik_perusahaan;
    }

    public String getPassword_perusahaan() {
        return password_perusahaan;
    }

    public void setPassword_perusahaan(String password_perusahaan) {
        this.password_perusahaan = password_perusahaan;
    }

    public String getAlamat_perusahaan() {
        return alamat_perusahaan;
    }

    public void setAlamat_perusahaan(String alamat_perusahaan) {
        this.alamat_perusahaan = alamat_perusahaan;
    }

    public String getTanggal_berdiri_perusahaan() {
        return tanggal_berdiri_perusahaan;
    }

    public void setTanggal_berdiri_perusahaan(String tanggal_berdiri_perusahaan) {
        this.tanggal_berdiri_perusahaan = tanggal_berdiri_perusahaan;
    }

    public String getEmail_perusahaan() {
        return email_perusahaan;
    }

    public void setEmail_perusahaan(String email_perusahaan) {
        this.email_perusahaan = email_perusahaan;
    }

    public String getNo_telepon_perusahaan() {
        return no_telepon_perusahaan;
    }

    public void setNo_telepon_perusahaan(String no_telepon_perusahaan) {
        this.no_telepon_perusahaan = no_telepon_perusahaan;
    }

    @Override
    public String toString() {
        return "Perusahaan{" +
                "kode_perusahaan=" + kode_perusahaan +
                ", nama_pemilik_perusahaan='" + nama_pemilik_perusahaan + '\'' +
                ", alamat_perusahaan='" + alamat_perusahaan + '\'' +
                ", email_perusahaan='" + email_perusahaan + '\'' +
                ", no_telepon_perusahaan='" + no_telepon_perusahaan + '\'' +
                '}';
    }
}
