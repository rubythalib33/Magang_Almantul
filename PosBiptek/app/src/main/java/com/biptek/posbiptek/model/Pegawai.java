package com.biptek.posbiptek.model;

public class Pegawai {
    private String username_pegawai;
    private Long kode_toko_pegawai;
    private String password_pegawai;
    private String jabatan_pegawai;
    private String nama_lengkap_pegawai;
    private String no_telepon_pegawai;

    public Pegawai(String username_pegawai, Long kode_toko_pegawai, String password_pegawai, String jabatan_pegawai, String nama_lengkap_pegawai, String no_telepon_pegawai) {
        this.username_pegawai = username_pegawai;
        this.kode_toko_pegawai = kode_toko_pegawai;
        this.password_pegawai = password_pegawai;
        this.jabatan_pegawai = jabatan_pegawai;
        this.nama_lengkap_pegawai = nama_lengkap_pegawai;
        this.no_telepon_pegawai = no_telepon_pegawai;
    }

    public Pegawai() {

    }

    public String getUsername_pegawai() {
        return username_pegawai;
    }

    public void setUsername_pegawai(String username_pegawai) {
        this.username_pegawai = username_pegawai;
    }

    public Long getKode_toko_pegawai() {
        return kode_toko_pegawai;
    }

    public void setKode_toko_pegawai(Long kode_toko_pegawai) {
        this.kode_toko_pegawai = kode_toko_pegawai;
    }

    public String getPassword_pegawai() {
        return password_pegawai;
    }

    public void setPassword_pegawai(String password_pegawai) {
        this.password_pegawai = password_pegawai;
    }

    public String getJabatan_pegawai() {
        return jabatan_pegawai;
    }

    public void setJabatan_pegawai(String jabatan_pegawai) {
        this.jabatan_pegawai = jabatan_pegawai;
    }

    public String getNama_lengkap_pegawai() {
        return nama_lengkap_pegawai;
    }

    public void setNama_lengkap_pegawai(String nama_lengkap_pegawai) {
        this.nama_lengkap_pegawai = nama_lengkap_pegawai;
    }

    public String getNo_telepon_pegawai() {
        return no_telepon_pegawai;
    }

    public void setNo_telepon_pegawai(String no_telepon_pegawai) {
        this.no_telepon_pegawai = no_telepon_pegawai;
    }

    @Override
    public String toString() {
        return "Pegawai{" +
                "username_pegawai='" + username_pegawai + '\'' +
                ", kode_toko_pegawai=" + kode_toko_pegawai +
                ", password_pegawai='" + password_pegawai + '\'' +
                ", jabatan_pegawai='" + jabatan_pegawai + '\'' +
                ", nama_lengkap_pegawai='" + nama_lengkap_pegawai + '\'' +
                ", no_telepon_pegawai='" + no_telepon_pegawai + '\'' +
                '}';
    }
}
