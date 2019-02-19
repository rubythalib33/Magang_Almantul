package com.biptek.posbiptek.model;

public class Admin {
    private String username_admin;
    private Long kode_perusahaan_admin;
    private String password_admin;
    private String nama_lengkap_admin;
    private String no_telepon_admin;

    public Admin(String username_admin, Long kode_perusahaan_admin, String password_admin, String nama_lengkap_admin, String no_telepon_admin) {
        this.username_admin = username_admin;
        this.kode_perusahaan_admin = kode_perusahaan_admin;
        this.password_admin = password_admin;
        this.nama_lengkap_admin = nama_lengkap_admin;
        this.no_telepon_admin = no_telepon_admin;
    }

    public Admin(){

    }

    public String getUsername_admin() {
        return username_admin;
    }

    public void setUsername_admin(String username_admin) {
        this.username_admin = username_admin;
    }

    public Long getKode_perusahaan_admin() {
        return kode_perusahaan_admin;
    }

    public void setKode_perusahaan_admin(Long kode_perusahaan_admin) {
        this.kode_perusahaan_admin = kode_perusahaan_admin;
    }

    public String getPassword_admin() {
        return password_admin;
    }

    public void setPassword_admin(String password_admin) {
        this.password_admin = password_admin;
    }

    public String getNama_lengkap_admin() {
        return nama_lengkap_admin;
    }

    public void setNama_lengkap_admin(String nama_lengkap_admin) {
        this.nama_lengkap_admin = nama_lengkap_admin;
    }

    public String getNo_telepon_admin() {
        return no_telepon_admin;
    }

    public void setNo_telepon_admin(String no_telepon_admin) {
        this.no_telepon_admin = no_telepon_admin;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username_admin='" + username_admin + '\'' +
                ", kode_perusahaan_admin=" + kode_perusahaan_admin +
                ", password_admin='" + password_admin + '\'' +
                ", nama_lengkap_admin='" + nama_lengkap_admin + '\'' +
                ", no_telepon_admin='" + no_telepon_admin + '\'' +
                '}';
    }
}
