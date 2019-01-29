package com.biptek.posbiptek.model;

public class User {
    private String username;
    private String password;
    private String jabatan;
    private String nama_lengkap;
    private String no_telepon;

    public User(String username, String password, String jabatan, String nama_lengkap, String no_telepon) {
        this.username = username;
        this.password = password;
        this.jabatan = jabatan;
        this.nama_lengkap = nama_lengkap;
        this.no_telepon = no_telepon;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", jabatan='" + jabatan + '\'' +
                ", nama_lengkap='" + nama_lengkap + '\'' +
                ", no_telepon='" + no_telepon + '\'' +
                '}';
    }
}
