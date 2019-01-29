package com.biptek.posbiptek.model;

public class Supplier {
    private long kode_supplier;
    private String nama_supplier;
    private String email_supplier;
    private String no_telepon_supplier;
    private String alamat_supplier;

    public Supplier(long kode_supplier, String nama_supplier, String email_supplier, String no_telepon_supplier, String alamat_supplier) {
        this.kode_supplier = kode_supplier;
        this.nama_supplier = nama_supplier;
        this.email_supplier = email_supplier;
        this.no_telepon_supplier = no_telepon_supplier;
        this.alamat_supplier = alamat_supplier;
    }

    public Supplier() {

    }

    public long getKode_supplier() {
        return kode_supplier;
    }

    public void setKode_supplier(long kode_supplier) {
        this.kode_supplier = kode_supplier;
    }

    public String getNama_supplier() {
        return nama_supplier;
    }

    public void setNama_supplier(String nama_supplier) {
        this.nama_supplier = nama_supplier;
    }

    public String getEmail_supplier() {
        return email_supplier;
    }

    public void setEmail_supplier(String email_supplier) {
        this.email_supplier = email_supplier;
    }

    public String getNo_telepon_supplier() {
        return no_telepon_supplier;
    }

    public void setNo_telepon_supplier(String no_telepon_supplier) {
        this.no_telepon_supplier = no_telepon_supplier;
    }

    public String getAlamat_supplier() {
        return alamat_supplier;
    }

    public void setAlamat_supplier(String alamat_supplier) {
        this.alamat_supplier = alamat_supplier;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "kode_supplier=" + kode_supplier +
                ", nama_supplier='" + nama_supplier + '\'' +
                ", email_supplier='" + email_supplier + '\'' +
                ", no_telepon_supplier='" + no_telepon_supplier + '\'' +
                ", alamat_supplier='" + alamat_supplier + '\'' +
                '}';
    }
}
