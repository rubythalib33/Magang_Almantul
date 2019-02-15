package com.biptek.posbiptek.model;

public class Restock {
    private long kode_restock;
    private long kode_supplier_restock;
    private String username_pegawai_restock;
    private String tanggal_transaksi_restock;
    private String tanggal_jatuh_tempo;
    private String bukti_transaksi_restock;

    public Restock(long kode_restock, long kode_supplier_restock, String username_pegawai_restock, String tanggal_transaksi_restock, String tanggal_jatuh_tempo, String bukti_transaksi_restock) {
        this.kode_restock = kode_restock;
        this.kode_supplier_restock = kode_supplier_restock;
        this.username_pegawai_restock = username_pegawai_restock;
        this.tanggal_transaksi_restock = tanggal_transaksi_restock;
        this.tanggal_jatuh_tempo = tanggal_jatuh_tempo;
        this.bukti_transaksi_restock = bukti_transaksi_restock;
    }

    public Restock() {

    }

    public long getKode_restock() {
        return kode_restock;
    }

    public void setKode_restock(long kode_restock) {
        this.kode_restock = kode_restock;
    }

    public long getKode_supplier_restock() {
        return kode_supplier_restock;
    }

    public void setKode_supplier_restock(long kode_supplier_restock) {
        this.kode_supplier_restock = kode_supplier_restock;
    }

    public String getUsername_pegawai_restock() {
        return username_pegawai_restock;
    }

    public void setUsername_pegawai_restock(String username_pegawai_restock) {
        this.username_pegawai_restock = username_pegawai_restock;
    }

    public String getTanggal_transaksi_restock() {
        return tanggal_transaksi_restock;
    }

    public void setTanggal_transaksi_restock(String tanggal_transaksi_restock) {
        this.tanggal_transaksi_restock = tanggal_transaksi_restock;
    }

    public String getTanggal_jatuh_tempo() {
        return tanggal_jatuh_tempo;
    }

    public void setTanggal_jatuh_tempo(String tanggal_jatuh_tempo) {
        this.tanggal_jatuh_tempo = tanggal_jatuh_tempo;
    }

    public String getBukti_transaksi_restock() {
        return bukti_transaksi_restock;
    }

    public void setBukti_transaksi_restock(String bukti_transaksi_restock) {
        this.bukti_transaksi_restock = bukti_transaksi_restock;
    }

    @Override
    public String toString() {
        return "Restock{" +
                "kode_restock=" + kode_restock +
                ", kode_supplier_restock=" + kode_supplier_restock +
                ", username_pegawai_restock='" + username_pegawai_restock + '\'' +
                ", tanggal_transaksi_restock='" + tanggal_transaksi_restock + '\'' +
                ", tanggal_jatuh_tempo='" + tanggal_jatuh_tempo + '\'' +
                ", bukti_transaksi_restock='" + bukti_transaksi_restock + '\'' +
                '}';
    }
}