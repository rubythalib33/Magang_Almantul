package com.biptek.posbiptek.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class CRUD {
    private static final String LOGTAG = "POS_BIPTEK_SYS";
    private SQLiteOpenHelper dbhandler;
    private SQLiteDatabase database;

    public CRUD(Context context){
        dbhandler = new DatabaseHelper(context);
    }

    public void open () {
        Log.i (LOGTAG, "Database Opened");
        database = dbhandler.getWritableDatabase();
    }

    public void close () {
        Log.i (LOGTAG, "Database Closed");
        dbhandler.close();
    }

//Untuk table bundle_produk dan list_produk_bundle
    private static final String[] allColumnsBundle = {
            "kode_bundle",
            "nama_bundle",
            "harga_bundle",
    };

    private static final String[] allColumnsBundleList ={
            "kode_bundle_list",
            "kode_produk_list_bundle",
            "jumlah_produk_bundle"
    };

    public long addBundleProduk(BundleProduk bundleProduk, List<ListProdukBundle> listProdukBundles){

        //untuk table bundle
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama_bundle", bundleProduk.getNama_bundle());
        contentValues.put("harga_bundle", bundleProduk.getHarga_bundle());
        long insertid = database.insert("bundle", null, contentValues);

        //untuk table list_produk_bundle
        for(ListProdukBundle listProdukBundle : listProdukBundles){
            ContentValues contentValuesList = new ContentValues();
            contentValuesList.put("kode_bundle_list", insertid);
            contentValuesList.put("kode_produk_list_bundle", listProdukBundle.getKode_produk_list_bundle());
            contentValuesList.put("jumlah_produk_bundle", listProdukBundle.getJumlah_produk_bundle());
            database.insert("list_produk_bundle", null, contentValuesList);
        }

        return insertid;
    }

    //mendapatkan 1 data bundle produk
    public BundleProduk getBundleProduk(long kode_bundle){
        Cursor cursor = database.query("bundle",
                allColumnsBundle,
                "kode_bundle=?",
                new String[]{String.valueOf(kode_bundle)},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        BundleProduk bundleProduk = new BundleProduk(cursor.getLong(0),
                cursor.getString(1),
                cursor.getInt(2));

        return bundleProduk;
    }

    //mendapatkan semua data bundle produk
    public List<BundleProduk> getAllBundleProduk(){
        Cursor cursor = database.query("bundle",
                allColumnsBundle,
                null,
                null,
                null,
                null,
                null);

        List<BundleProduk> bundleProduks = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                BundleProduk bundleProduk = new BundleProduk();
                bundleProduk.setKode_bundle(cursor.getLong(cursor.getColumnIndex("kode_bundle")));
                bundleProduk.setNama_bundle(cursor.getString(cursor.getColumnIndex("nama_bundle")));
                bundleProduk.setHarga_bundle(cursor.getInt(cursor.getColumnIndex("harga_bundle")));
                bundleProduks.add(bundleProduk);
            }
        }

        return bundleProduks;
    }

    //mendapatkan list barang yang dibundle pada produk bundle tertentu
    public List<ListProdukBundle> getListProdukBundle(long kode_bundle_list){
        Cursor cursor = database.query("list_produk_bundle",
                allColumnsBundleList,
                "kode_bundle_list",
                new String[]{String.valueOf(kode_bundle_list)},
                null,
                null,
                null);

        List<ListProdukBundle> listProdukBundles = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                ListProdukBundle produkBundle = new ListProdukBundle();
                produkBundle.setKode_bundle_list(cursor.getLong(cursor.getColumnIndex("kode_bundle_list")));
                produkBundle.setKode_produk_list_bundle(cursor.getString(cursor.getColumnIndex("kode_produk_list_bundle")));
                produkBundle.setJumlah_produk_bundle(cursor.getInt(cursor.getColumnIndex("jumlah_produk_bundle")));
                listProdukBundles.add(produkBundle);
            }
        }

        return listProdukBundles;
    }

    public void updateBundleProduk(BundleProduk bundleProduk, List<ListProdukBundle> listProdukBundles){

        //untuk table bundle_produk
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama_bundle", bundleProduk.getNama_bundle());
        contentValues.put("harga_bundle", bundleProduk.getHarga_bundle());
        database.update("bundle", contentValues, "kode_bundle=?", new String[]{String.valueOf(bundleProduk.getKode_bundle())});

        //untuk table list_produk_bundle
        for(ListProdukBundle listProdukBundle : listProdukBundles){
            ContentValues contentValuesList = new ContentValues();
            contentValuesList.put("kode_bundle_list", bundleProduk.getKode_bundle());
            contentValuesList.put("kode_produk_list_bundle", listProdukBundle.getKode_produk_list_bundle());
            contentValuesList.put("jumlah_produk_bundle", listProdukBundle.getJumlah_produk_bundle());
            database.update("list_produk_bundle", contentValuesList,
                    "kode_bundle_list=? AND kode_produk_list_bundle=?",
                    new String[]{String.valueOf(bundleProduk.getKode_bundle()), listProdukBundle.getKode_produk_list_bundle()});
        }
    }

    public void deleteBundleProduk(BundleProduk bundleProduk){
        database.delete("list_produk_bundle", "kode_bundle_list=?", new String[]{String.valueOf(bundleProduk.getKode_bundle())});
        database.delete("bundle", "kode_bundle=?", new String[]{String.valueOf(bundleProduk.getKode_bundle())});
    }

//Untuk table pemasukan
    private static final String[] allColumnsPemasukan = {
            "kode_data_pemasukan",
            "kode_toko_pemasukan",
            "kode_pemasukan",
            "tanggal_pemasukan",
            "jumlah_pemasukan"
    };

    public long addPemasukan(Pemasukan pemasukan){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_pemasukan", pemasukan.getKode_pemasukan());
        contentValues.put("kode_toko_pemasukan", pemasukan.getKode_toko_pemasukan());
        contentValues.put("tanggal_pemasukan", pemasukan.getTanggal_pemasukan());
        contentValues.put("jumlah_pemasukan", pemasukan.getJumlah_pemasukan());
        long insertid = database.insert("pemasukan", null, contentValues);
        return insertid;
    }

    //mendapatkan 1 data pemasukan
    public Pemasukan getPemasukan(long kode_data_pemasukan){
        Cursor cursor = database.query("pemasukan",
                allColumnsPemasukan,
                "kode_data_pemasukan=?",
                new String[]{String.valueOf(kode_data_pemasukan)},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        Pemasukan pemasukan = new Pemasukan(cursor.getLong(0),
                cursor.getLong(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getInt(4));

        return pemasukan;
    }

    //mendapatkan semua data pemasukan
    public List<Pemasukan> getAllPemasukan(){
        Cursor cursor = database.query("pemasukan",
                allColumnsPemasukan,
                null,
                null,
                null,
                null,
                null);

        List<Pemasukan> pemasukans = new ArrayList<>();
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                Pemasukan pemasukan = new Pemasukan();
                pemasukan.setKode_data_pemasukan(cursor.getLong(cursor.getColumnIndex("kode_data_pemasukan")));
                pemasukan.setKode_toko_pemasukan(cursor.getLong(cursor.getColumnIndex("kode_toko_pemasukan")));
                pemasukan.setKode_pemasukan(cursor.getString(cursor.getColumnIndex("kode_pemasukan")));
                pemasukan.setTanggal_pemasukan(cursor.getString(cursor.getColumnIndex("tanggal_pemasukan")));
                pemasukan.setJumlah_pemasukan(cursor.getInt(cursor.getColumnIndex("jumlah_pemasukan")));
                pemasukans.add(pemasukan);
            }
        }

        return pemasukans;
    }

    public void updatePemasukan(Pemasukan pemasukan){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_pemasukan", pemasukan.getKode_pemasukan());
        contentValues.put("kode_toko_pemasukan", pemasukan.getKode_toko_pemasukan());
        contentValues.put("tanggal_pemasukan", pemasukan.getTanggal_pemasukan());
        contentValues.put("jumlah_pemasukan", pemasukan.getJumlah_pemasukan());
        database.update("pemasukan", contentValues, "kode_data_pemasukan=?", new String[]{String.valueOf(pemasukan.getKode_data_pemasukan())});
    }

    public void deletePemasukan(Pemasukan pemasukan){
        database.delete("pemasukan", "kode_data_pemasukan=?", new String[]{String.valueOf(pemasukan.getKode_data_pemasukan())});
    }

//Untuk table pengeluaran
    private static final String[] allColumnsPengeluaran = {
            "kode_data_pengeluaran",
            "kode_toko_pengeluaran",
            "kode_pengeluaran",
            "tanggal_pengeluaran",
            "jumlah_pengeluaran"
    };

    public long addPengeluaran(Pengeluaran pengeluaran){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_pengeluaran", pengeluaran.getKode_pengeluaran());
        contentValues.put("kode_toko_pengeluaran", pengeluaran.getKode_toko_pengeluaran());
        contentValues.put("tanggal_pengeluaran", pengeluaran.getTanggal_pengeluaran());
        contentValues.put("jumlah_pengeluaran", pengeluaran.getJumlah_pengeluaran());
        long insertid = database.insert("pengeluaran", null, contentValues);
        return insertid;
    }

    //mendapatkan 1 data pengeluaran
    public Pengeluaran getPengeluaran(long kode_data_pengeluaran){
        Cursor cursor = database.query("pengeluaran",
                allColumnsPengeluaran,
                "kode_data_pengeluaran=?",
                new String[]{String.valueOf(kode_data_pengeluaran)},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        Pengeluaran pengeluaran = new Pengeluaran(cursor.getLong(0),
                cursor.getLong(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getInt(4));

        return pengeluaran;
    }

    //mendapatkan semua data pengeluaran
    public List<Pengeluaran> getAllPengeluaran(){
        Cursor cursor = database.query("pengeluaran",
                allColumnsPengeluaran,
                null,
                null,
                null,
                null,
                null);

        List<Pengeluaran> pengeluarans = new ArrayList<>();
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                Pengeluaran pengeluaran = new Pengeluaran();
                pengeluaran.setKode_data_pengeluaran(cursor.getLong(cursor.getColumnIndex("kode_data_pengeluaran")));
                pengeluaran.setKode_toko_pengeluaran(cursor.getLong(cursor.getColumnIndex("kode_toko_pengeluaran")));
                pengeluaran.setKode_pengeluaran(cursor.getString(cursor.getColumnIndex("kode_pengeluaran")));
                pengeluaran.setTanggal_pengeluaran(cursor.getString(cursor.getColumnIndex("tanggal_pengeluaran")));
                pengeluaran.setJumlah_pengeluaran(cursor.getInt(cursor.getColumnIndex("jumlah_pengeluaran")));
                pengeluarans.add(pengeluaran);
            }
        }

        return pengeluarans;
    }

    public void updatePengeluaran(Pengeluaran pengeluaran){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_pengeluaran", pengeluaran.getKode_pengeluaran());
        contentValues.put("kode_toko_pengeluaran", pengeluaran.getKode_toko_pengeluaran());
        contentValues.put("tanggal_pengeluaran", pengeluaran.getTanggal_pengeluaran());
        contentValues.put("jumlah_pengeluaran", pengeluaran.getJumlah_pengeluaran());
        database.update("pengeluaran", contentValues, "kode_data_pengeluaran=?", new String[]{String.valueOf(pengeluaran.getKode_data_pengeluaran())});
    }

    public void deletePengeluaran(Pengeluaran pengeluaran){
        database.delete("pengeluaran", "kode_data_pengeluaran=?", new String[]{String.valueOf(pengeluaran.getKode_data_pengeluaran())});
    }

//Untuk table produk
    private static final String[] allColumnsProduk = {
            "kode_produk",
            "jenis_produk",
            "kategori_produk",
            "nama_produk",
            "deskripsi_produk",
            "harga_jual_produk",
            "harga_beli_produk",
            "satuan_produk",
            "gambar_produk",
            "stok_produk",
            "stok_kritis_produk",
            "status_produk"
    };

    public void addProduk(Produk produk){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_produk", produk.getKode_produk());
        contentValues.put("jenis_produk", produk.getJenis_produk());
        contentValues.put("kategori_produk", produk.getKategori_produk());
        contentValues.put("nama_produk", produk.getNama_produk());
        contentValues.put("deskripsi_produk", produk.getDeskripsi_produk());
        contentValues.put("harga_jual_produk", produk.getHarga_jual_produk());
        contentValues.put("harga_beli_produk", produk.getHarga_beli_produk());
        contentValues.put("satuan_produk", produk.getSatuan_produk());
        contentValues.put("gambar_produk", produk.getGambar_produk());
        contentValues.put("stok_produk", produk.getStok_produk());
        contentValues.put("stok_kritis_produk", produk.getStok_kritis_produk());
        contentValues.put("status_produk", produk.getStatus_produk());
        database.insert("produk", null, contentValues);
    }

    //mendapatkan 1 produk
    public Produk getProduk (String kode_produk){
        Cursor cursor = database.query("produk",
                allColumnsProduk,
                "kode_produk=?",
                new String[]{kode_produk},
                null,
                null,
                null);

        if (cursor != null)
            cursor.moveToFirst();

        Produk produk = new Produk(cursor.getString(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getInt(5),
                cursor.getInt(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getInt(9),
                cursor.getInt(10),
                cursor.getString(11));

        return produk;
    }

    //mendapatkan semua produk
    public List<Produk> getAllProduk(){
        Cursor cursor = database.query("produk",
                allColumnsProduk,
                null,
                null,
                null,
                null,
                null
        );

        List<Produk> produks = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                Produk produk = new Produk();
                produk.setKode_produk(cursor.getString(cursor.getColumnIndex("kode_produk")));
                produk.setJenis_produk(cursor.getString(cursor.getColumnIndex("jenis_produk")));
                produk.setKategori_produk(cursor.getString(cursor.getColumnIndex("kategori_produk")));
                produk.setNama_produk(cursor.getString(cursor.getColumnIndex("nama_produk")));
                produk.setDeskripsi_produk(cursor.getString(cursor.getColumnIndex("deskripsi_produk")));
                produk.setHarga_jual_produk(cursor.getInt(cursor.getColumnIndex("harga_jual_produk")));
                produk.setHarga_beli_produk(cursor.getInt(cursor.getColumnIndex("harga_beli_produk")));
                produk.setSatuan_produk(cursor.getString(cursor.getColumnIndex("satuan_produk")));
                produk.setGambar_produk(cursor.getString(cursor.getColumnIndex("gambar_produk")));
                produk.setStok_produk(cursor.getInt(cursor.getColumnIndex("stok_produk")));
                produk.setStok_kritis_produk(cursor.getInt(cursor.getColumnIndex("stok_kritis_produk")));
                produk.setStatus_produk(cursor.getString(cursor.getColumnIndex("status_produk")));
                produks.add(produk);
            }
        }

        return produks;
    }

    public void updateProduk(Produk produk){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_produk", produk.getKode_produk());
        contentValues.put("jenis_produk", produk.getJenis_produk());
        contentValues.put("kategori_produk", produk.getKategori_produk());
        contentValues.put("nama_produk", produk.getNama_produk());
        contentValues.put("deskripsi_produk", produk.getDeskripsi_produk());
        contentValues.put("harga_jual_produk", produk.getHarga_jual_produk());
        contentValues.put("harga_beli_produk", produk.getHarga_beli_produk());
        contentValues.put("satuan_produk", produk.getSatuan_produk());
        contentValues.put("gambar_produk", produk.getGambar_produk());
        contentValues.put("stok_produk", produk.getStok_produk());
        contentValues.put("stok_kritis_produk", produk.getStok_kritis_produk());
        contentValues.put("status_produk", produk.getStatus_produk());
        database.update("produk", contentValues, "kode_produk=?", new String[]{produk.getKode_produk()});
    }

    public void deleteProduk(Produk produk){
        database.delete("produk", "kode_produk=?", new String[] {produk.getKode_produk()});
    }

//Untuk table produk_diskon
    private static final String[] allColumnsProdukDiskon = {
            "kode_diskon",
            "kode_produk_diskon",
            "besar_diskon",
            "tanggal_mulai_berlaku_diskon",
            "tanggal_berakhir_diskon"
    };

    public long addProdukDiskon(ProdukDiskon produkDiskon, Produk produk){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_produk_diskon", produk.getKode_produk());
        contentValues.put("besar_diskon", produkDiskon.getBesar_diskon());
        contentValues.put("tanggal_mulai_berlaku_diskon", produkDiskon.getTanggal_mulai_berlaku_diskon());
        contentValues.put("tanggal_berakhir_diskon", produkDiskon.getTanggal_berakhir_diskon());
        long inserid = database.insert("produk_diskon", null, contentValues);
        return inserid;
    }

    //mendapatkan 1 data diskon produk
    public ProdukDiskon getProdukDiskon(long kode_diskon){
        Cursor cursor = database.query("produk_diskon",
                allColumnsProdukDiskon,
                "kode_diskon=?",
                new String[]{String.valueOf(kode_diskon)},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        ProdukDiskon produkDiskon = new ProdukDiskon(cursor.getLong(0),
                cursor.getString(1),
                cursor.getInt(2),
                cursor.getString(3),
                cursor.getString(4));

        return produkDiskon;
    }

    //mendapatkan semua data diskon produk
    public List<ProdukDiskon> getAllProdukDiskon(){
        Cursor cursor = database.query("produk_diskon",
                allColumnsProdukDiskon,
                null,
                null,
                null,
                null,
                null);

        List<ProdukDiskon> produkDiskons = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                ProdukDiskon produkDiskon = new ProdukDiskon();
                produkDiskon.setKode_diskon(cursor.getLong(cursor.getColumnIndex("kode_diskon")));
                produkDiskon.setKode_produk_diskon(cursor.getString(cursor.getColumnIndex("kode_produk_diskon")));
                produkDiskon.setBesar_diskon(cursor.getInt(cursor.getColumnIndex("besar_diskon")));
                produkDiskon.setTanggal_mulai_berlaku_diskon(cursor.getString(cursor.getColumnIndex("tanggal_mulai_berlaku_diskon")));
                produkDiskon.setTanggal_berakhir_diskon(cursor.getString(cursor.getColumnIndex("tanggal_berakhir_diskon")));
                produkDiskons.add(produkDiskon);
            }
        }

        return produkDiskons;
    }

    public void updateProdukDiskon(ProdukDiskon produkDiskon, Produk produk){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_produk_diskon", produk.getKode_produk());
        contentValues.put("besar_diskon", produkDiskon.getBesar_diskon());
        contentValues.put("tanggal_mulai_berlaku_diskon", produkDiskon.getTanggal_mulai_berlaku_diskon());
        contentValues.put("tanggal_berakhir_diskon", produkDiskon.getTanggal_berakhir_diskon());
        database.update("produk_diskon", contentValues, "kode_diskon=?", new String[]{String.valueOf(produkDiskon.getKode_diskon())});
    }

    public void deleteProdukDiskon(ProdukDiskon produkDiskon){
        database.delete("produk_diskon", "kode_diskon=?", new String[]{String.valueOf(produkDiskon.getKode_diskon())});
    }

//Untuk table restock dan list_produk_restock
    private static final String[] allColumnsRestock = {
            "kode_restock",
            "kode_supplier_restock",
            "tanggal_transaksi_restock",
            "tanggal_jatuh_tempo",
            "bukti_transakti_restock"
    };

    private static final String[] allColumnsRestockList = {
            "kode_restock_list",
            "kode_produk_list_restock",
            "jumlah_produk_restock"
    };

    public long addRestock(Restock restock, List<ListProdukRestock> listProdukRestocks){

        //untuk table restock
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_supplier_restock", restock.getKode_supplier_restock());
        contentValues.put("username_pegawai_restock", restock.getUsername_pegawai_restock());
        contentValues.put("tanggal_transaksi_restock", restock.getTanggal_transaksi_restock());
        contentValues.put("tanggal_jatuh_tempon", restock.getTanggal_jatuh_tempo());
        contentValues.put("bukti_transaksi_restock", restock.getBukti_transaksi_restock());
        long insertid = database.insert("restock", null, contentValues);

        //untuk table list_produk_restock
        for(ListProdukRestock listProdukRestock : listProdukRestocks){
            ContentValues contentValuesList = new ContentValues();
            contentValuesList.put("kode_restock_list", insertid);
            contentValuesList.put("kode_produk_list_restock", listProdukRestock.getKode_produk_list_restock());
            contentValuesList.put("jumlah_produk_restock", listProdukRestock.getJumlah_produk_restock());
            database.insert("list_produk_restock", null, contentValuesList);
        }

        return insertid;
    }

    //mendapatkan 1 data restock
    public Restock getRestock(long kode_restock){
        Cursor cursor = database.query("restock",
                allColumnsRestock,
                "kode_restock=?",
                new String[]{String.valueOf(kode_restock)},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        Restock restock = new Restock(cursor.getLong(0),
                cursor.getLong(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5));

        return  restock;
    }

    //mendapatkan semua data restock
    public List<Restock> getAllRestock(){
        Cursor cursor = database.query("restock",
                allColumnsRestock,
                null,
                null,
                null,
                null,
                null);

        List<Restock> restocks = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                Restock restock = new Restock();
                restock.setKode_restock(cursor.getLong(cursor.getColumnIndex("kode_restock")));
                restock.setKode_supplier_restock(cursor.getLong(cursor.getColumnIndex("kode_supplier_restock")));
                restock.setUsername_pegawai_restock(cursor.getString(cursor.getColumnIndex("username_pegawai_restock")));
                restock.setTanggal_transaksi_restock(cursor.getString(cursor.getColumnIndex("tanggal_transaksi_restock")));
                restock.setTanggal_jatuh_tempo(cursor.getString(cursor.getColumnIndex("tanggal_jatuh_tempo")));
                restock.setBukti_transaksi_restock(cursor.getString(cursor.getColumnIndex("bukti_transaksi_restock")));
                restocks.add(restock);
            }
        }

        return restocks;
    }

    //mendapatkan list barang yang direstock pada data restock tertentu
    public List<ListProdukRestock> getListProdukRestock(long kode_restock_list){
        Cursor cursor = database.query("list_produk_restock",
                allColumnsRestockList,
                "kode_restock_list",
                new String[]{String.valueOf(kode_restock_list)},
                null,
                null,
                null);

        List<ListProdukRestock> listProdukRestocks = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                ListProdukRestock ProdukRestock = new ListProdukRestock();
                ProdukRestock.setKode_restock_list(cursor.getLong(cursor.getColumnIndex("kode_restock_list")));
                ProdukRestock.setKode_produk_list_restock(cursor.getString(cursor.getColumnIndex("kode_produk_list_restock")));
                ProdukRestock.setJumlah_produk_restock(cursor.getInt(cursor.getColumnIndex("jumlah_produk_restock")));
                listProdukRestocks.add(ProdukRestock);
            }
        }

        return listProdukRestocks;
    }

    public void updateRestock(Restock restock, List<ListProdukRestock> listProdukRestocks){

        //untuk table restock
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_supplier_restock", restock.getKode_supplier_restock());
        contentValues.put("username_pegawai_restock", restock.getUsername_pegawai_restock());
        contentValues.put("tanggal_transaksi_restock", restock.getTanggal_transaksi_restock());
        contentValues.put("tanggal_jatuh_tempon", restock.getTanggal_jatuh_tempo());
        contentValues.put("bukti_transaksi_restock", restock.getBukti_transaksi_restock());
        database.update("restock", contentValues, "kode_restock=?", new String[]{String.valueOf(restock.getKode_restock())});

        //untuk table list_produk_restock
        for(ListProdukRestock listProdukRestock : listProdukRestocks){
            ContentValues contentValuesList = new ContentValues();
            contentValuesList.put("kode_restock_list", restock.getKode_restock());
            contentValuesList.put("kode_produk_list_restock", listProdukRestock.getKode_produk_list_restock());
            contentValuesList.put("jumlah_produk_restock", listProdukRestock.getJumlah_produk_restock());
            database.update("list_produk_restock", contentValuesList,
                    "kode_restock_list=? AND kode_produk_list_restock=?",
                    new String[]{String.valueOf(restock.getKode_restock()), listProdukRestock.getKode_produk_list_restock()});
        }
    }

    public void deleteRestock(Restock restock){
        database.delete("list_produk_restock", "kode_restock_list=?", new String[]{String.valueOf(restock.getKode_restock())});
        database.delete("restock", "kode_restock=?", new String[]{String.valueOf(restock.getKode_restock())});
    }

//untuk table Supplier
    private static final String[] allColumnsSupplier = {
            "kode_supplier",
            "nama_supplier",
            "email_supllier",
            "no_telepon_supplier",
            "alamat_supplier"
    };

    public long addSupplier(Supplier supplier){
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama_supplier", supplier.getNama_supplier());
        contentValues.put("email_supplier", supplier.getEmail_supplier());
        contentValues.put("no_telepon_supplier", supplier.getNo_telepon_supplier());
        contentValues.put("alamat_supplier", supplier.getAlamat_supplier());
        long insertid = database.insert("supplier", null, contentValues);
        return insertid;
    }

    //mendapatkan 1 supplier
    public Supplier getSupplier(long kode_supplier){
        Cursor cursor = database.query("supplier",
                allColumnsSupplier,
                "kode_supplier=?",
                new String[]{String.valueOf(kode_supplier)},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        Supplier supplier = new Supplier(cursor.getLong(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4));

        return supplier;
    }

    //mendapatkan semua supplier
    public List<Supplier> getAllSupplier(){
        Cursor cursor = database.query("supplier",
                allColumnsSupplier,
                null,
                null,
                null,
                null,
                null);

        List<Supplier> suppliers = new ArrayList<>();
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                Supplier supplier = new Supplier();
                supplier.setKode_supplier(cursor.getLong(cursor.getColumnIndex("kode_supplier")));
                supplier.setNama_supplier(cursor.getString(cursor.getColumnIndex("nama_supplier")));
                supplier.setEmail_supplier(cursor.getString(cursor.getColumnIndex("email_supplier")));
                supplier.setNo_telepon_supplier(cursor.getString(cursor.getColumnIndex("no_telepon_supplier")));
                supplier.setAlamat_supplier(cursor.getString(cursor.getColumnIndex("alamat_supplier")));
                suppliers.add(supplier);
            }
        }

        return suppliers;
    }

    public void updateSupplier(Supplier supplier){
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama_supplier", supplier.getNama_supplier());
        contentValues.put("email_supplier", supplier.getEmail_supplier());
        contentValues.put("no_telepon_supplier", supplier.getNo_telepon_supplier());
        contentValues.put("alamat_supplier", supplier.getAlamat_supplier());
        database.update("supplier", contentValues, "kode_supplier=?", new String[]{String.valueOf(supplier.getKode_supplier())});
    }

    public void deleteSupplier(Supplier supplier){
        database.delete("supplier", "kode_supplier", new String[]{String.valueOf(supplier.getKode_supplier())});
    }

//Untuk table transaksi_penjualan dan list_produk_terjual
    private static final String[] allColumnsTransaksiPenjualan = {
            "kode_penjualan",
            "username_pegawai_penjualan",
            "nama_customer",
            "tanggal_transaksi_penjualan"
    };

    private static final String[] allColumnsListProdukTerjual = {
            "kode_penjualan_list",
            "kode_produk_list_terjual",
            "jumlah_produk_terjual"
    };

    public long addTransaksiPenjualan(TransaksiPenjualan transaksiPenjualan, List<ListProdukTerjual> listProdukTerjuals){

        //untuk table transaksi_penjualan
        ContentValues contentValues = new ContentValues();
        contentValues.put("username_pegawai_penjualan", transaksiPenjualan.getUsername_pegawai_penjualan());
        contentValues.put("nama_customer", transaksiPenjualan.getNama_customer());
        contentValues.put("tanggal_transaksi_penjualan", transaksiPenjualan.getTanggal_transaksi_penjualan());
        long inserid = database.insert("transaksi_penjualan", null, contentValues);

        //untuk table list_produk_terjual
        for(ListProdukTerjual produkTerjual : listProdukTerjuals){
            ContentValues contentValuesList = new ContentValues();
            contentValuesList.put("kode_penjualan_list", inserid);
            contentValuesList.put("kode_produk_list_terjual", produkTerjual.getKode_produk_list_terjual());
            contentValuesList.put("jumlah_produk_terjual", produkTerjual.getJumlah_produk_terjual());
            database.insert("list_produk_terjual", null, contentValuesList);
        }

        return inserid;
    }

    //mendapatkan 1 data transaksi penjualan
    public TransaksiPenjualan getTransaksiPenjualan(long kode_penjualan){
        Cursor cursor = database.query("transaksi_penjualan",
                allColumnsTransaksiPenjualan,
                "kode_penjualan=?",
                new String[]{String.valueOf(kode_penjualan)},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        TransaksiPenjualan transaksiPenjualan = new TransaksiPenjualan(cursor.getLong(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3));

        return transaksiPenjualan;
    }

    //mendapatkan list barang yang terjual pada transaksi tertentu
    public List<ListProdukTerjual> getListProdukTerjual(long kode_penjualan_list){
        Cursor cursor = database.query("list_produk_terjual",
                allColumnsListProdukTerjual,
                "kode_penjualan_list=?",
                new String[]{String.valueOf(kode_penjualan_list)},
                null,
                null,
                null);

        List<ListProdukTerjual> listProdukTerjuals = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                ListProdukTerjual produkTerjual = new ListProdukTerjual();
                produkTerjual.setKode_penjualan_list(cursor.getLong(cursor.getColumnIndex("kode_penjualan_list")));
                produkTerjual.setKode_produk_list_terjual(cursor.getString(cursor.getColumnIndex("kode_produk_list_terjual")));
                produkTerjual.setJumlah_produk_terjual(cursor.getInt(cursor.getColumnIndex("jumlah_produk_terjual")));
                listProdukTerjuals.add(produkTerjual);
            }
        }

        return listProdukTerjuals;
    }

    //mendapatkan semua data transaksi penjualan
    public List<TransaksiPenjualan> getAllTransaksiPenjualan(){
        Cursor cursor = database.query("transaksi_penjualan",
                allColumnsTransaksiPenjualan,
                null,
                null,
                null,
                null,
                null);

        List<TransaksiPenjualan> transaksiPenjualans = new ArrayList<>();
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                TransaksiPenjualan transaksiPenjualan = new TransaksiPenjualan();
                transaksiPenjualan.setKode_penjualan(cursor.getLong(cursor.getColumnIndex("kode_penjualan")));
                transaksiPenjualan.setUsername_pegawai_penjualan(cursor.getString(cursor.getColumnIndex("username_pegawai_penjualan")));
                transaksiPenjualan.setNama_customer(cursor.getString(cursor.getColumnIndex("nama_customer")));
                transaksiPenjualan.setTanggal_transaksi_penjualan(cursor.getString(cursor.getColumnIndex("tanggal_transaksi_penjualan")));
                transaksiPenjualans.add(transaksiPenjualan);
            }
        }

        return transaksiPenjualans;
    }

    public void updateTransaksiPenjualan(TransaksiPenjualan transaksiPenjualan , List<ListProdukTerjual> listProdukTerjuals){

        //update di table transaksi_penjualan
        ContentValues contentValues = new ContentValues();
        contentValues.put("username_pegawai_penjualan", transaksiPenjualan.getUsername_pegawai_penjualan());
        contentValues.put("nama_customer", transaksiPenjualan.getNama_customer());
        contentValues.put("tanggal_transaksi_penjualan", transaksiPenjualan.getTanggal_transaksi_penjualan());
        database.update("transaksi_penjualan", contentValues, "kode_penjualan=?", new String[]{String.valueOf(transaksiPenjualan.getKode_penjualan())});

        for(ListProdukTerjual produkTerjual : listProdukTerjuals){
            ContentValues contentValuesList = new ContentValues();
            contentValuesList.put("kode_penjualan_list", transaksiPenjualan.getKode_penjualan());
            contentValuesList.put("kode_produk_list_terjual", produkTerjual.getKode_produk_list_terjual());
            contentValuesList.put("jumlah_produk_terjual", produkTerjual.getJumlah_produk_terjual());
            database.update("list_produk_terjual", contentValuesList, "kode_penjualan_list=? AND kode_produk_list_terjual=?", new String[]{String.valueOf(produkTerjual.getKode_penjualan_list()), produkTerjual.getKode_produk_list_terjual()});
        }
    }

    public void deleteTransaksiPenjualan(TransaksiPenjualan transaksiPenjualan){
        database.delete("list_produk_terjual", "kode_penjualan_list=?", new String[]{String.valueOf(transaksiPenjualan.getKode_penjualan())});
        database.delete("transaksi_penjualan", "kode_penjualan=?", new String[]{String.valueOf(transaksiPenjualan.getKode_penjualan())});
    }

//Untuk table pegawai
    private static final String[] allColumnsPegawai = {
            "username_pegawai",
            "kode_toko_pegawai",
            "password_pegawai",
            "jabatan_pegawai",
            "nama_lengkap_pegawai",
            "no_telepon_pegawai"
    };

    public void addPegawai(Pegawai pegawai){
        ContentValues contentValues = new ContentValues();
        contentValues.put("username_pegawai", pegawai.getUsername_pegawai());
        contentValues.put("kode_toko_pegawai",pegawai.getKode_toko_pegawai());
        contentValues.put("password_pegawai", pegawai.getPassword_pegawai());
        contentValues.put("jabatan_pegawai", pegawai.getJabatan_pegawai());
        contentValues.put("nama_lengkap_pegawai", pegawai.getNama_lengkap_pegawai());
        contentValues.put("no_telepon_pegawai", pegawai.getNo_telepon_pegawai());
        database.insert("pegawai", null, contentValues);
    }

    //mendapatkan 1 pegawai
    public Pegawai getPegawai(String username){
        Cursor cursor = database.query("pegawai",
                allColumnsPegawai,
                "username_pegawai=?",
                new String[]{username},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        Pegawai pegawai = new Pegawai(cursor.getString(0),
                cursor.getLong(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5));

        return pegawai;
    }

    //mendapatkan semua pegawai
    public List<Pegawai> getAllPegawai(){
        Cursor cursor = database.query("pegawai",
                allColumnsPegawai,
                null,
                null,
                null,
                null,
                null);

        List<Pegawai> pegawais = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                Pegawai pegawai = new Pegawai();
                pegawai.setUsername_pegawai(cursor.getString(cursor.getColumnIndex("username_pegawai")));
                pegawai.setKode_toko_pegawai(cursor.getLong(cursor.getColumnIndex("kode_toko_pegawai")));
                pegawai.setPassword_pegawai(cursor.getString(cursor.getColumnIndex("password_pegawai")));
                pegawai.setJabatan_pegawai(cursor.getString(cursor.getColumnIndex("jabatan_pegawai")));
                pegawai.setNama_lengkap_pegawai(cursor.getString(cursor.getColumnIndex("nama_lengkap_pegawai")));
                pegawai.setNo_telepon_pegawai(cursor.getString(cursor.getColumnIndex("no_telepon_pegawai")));
                pegawais.add(pegawai);
            }
        }

        return pegawais;
    }

    public void updatePegawai(Pegawai pegawai){
        ContentValues contentValues = new ContentValues();
        contentValues.put("username_pegawai", pegawai.getUsername_pegawai());
        contentValues.put("kode_toko_pegawai",pegawai.getKode_toko_pegawai());
        contentValues.put("password_pegawai", pegawai.getPassword_pegawai());
        contentValues.put("jabatan_pegawai", pegawai.getJabatan_pegawai());
        contentValues.put("nama_lengkap_pegawai", pegawai.getNama_lengkap_pegawai());
        contentValues.put("no_telepon_pegawai", pegawai.getNo_telepon_pegawai());
        database.update("pegawai", contentValues, "username_pegawai=?", new String[]{pegawai.getUsername_pegawai()});
    }

    public void deletePegawai(Pegawai pegawai){
        database.delete("pegawai", "username_pegawai=?", new String[]{pegawai.getUsername_pegawai()});
    }

//untuk table toko
    private static final String[] allColumnsToko = {
        "kode_toko",
        "kode_perusahaan_toko",
        "manager_toko",
        "alamat_toko",
        "no_telepon_toko"
    };

    public long addToko(Toko toko){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_toko", toko.getKode_toko());
        contentValues.put("kode_perusahaan_toko", toko.getKode_perusahaan_toko());
        contentValues.put("manager_toko", toko.getManager_toko());
        contentValues.put("alamat_toko", toko.getAlamat_toko());
        contentValues.put("no_telepon_toko", toko.getNo_telepon_toko());
        long insertid = database.insert("toko", null, contentValues);
        return insertid;
    }

    //mendapatkan 1 toko
    public Toko getToko(long kode_toko){
        Cursor cursor = database.query("toko",
                allColumnsToko,
                "kode_toko=?",
                new String[]{String.valueOf(kode_toko)},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        Toko toko = new Toko(cursor.getLong(0),
                cursor.getLong(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4));

        return toko;
    }

    //mendapatkan semua toko
    public List<Toko> getAllToko(){
        Cursor cursor = database.query("toko",
                allColumnsToko,
                null,
                null,
                null,
                null,
                null);

        List<Toko> tokos = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                Toko toko = new Toko();
                toko.setKode_toko(cursor.getLong(cursor.getColumnIndex("kode_toko")));
                toko.setKode_perusahaan_toko(cursor.getLong(cursor.getColumnIndex("kode_perusahaan_toko")));
                toko.setManager_toko(cursor.getString(cursor.getColumnIndex("manager_toko")));
                toko.setAlamat_toko(cursor.getString(cursor.getColumnIndex("alamat_toko")));
                toko.setNo_telepon_toko(cursor.getString(cursor.getColumnIndex("no_telepon_toko")));
                tokos.add(toko);
            }
        }

        return tokos;
    }

    public void updateToko(Toko toko){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_toko", toko.getKode_toko());
        contentValues.put("kode_perusahaan_toko", toko.getKode_perusahaan_toko());
        contentValues.put("manager_toko", toko.getManager_toko());
        contentValues.put("alamat_toko", toko.getAlamat_toko());
        contentValues.put("no_telepon_toko", toko.getNo_telepon_toko());
        database.update("toko", contentValues, "kode_toko=?", new String[]{String.valueOf(toko.getKode_toko())});
    }

    public void deleteToko(Toko toko){
        database.delete("toko", "kode_toko", new String[]{String.valueOf(toko.getKode_toko())});
    }

//untuk table perusahaan
    private final String[] allColumnsPerusahaan = {
            "kode_perusahaan",
            "nama_pemilik_perusahaan",
            "alamat_perusahaan",
            "email_perusahaan",
            "no_telepon_perusahaan"
    };

    public long addPerusahaan(Perusahaan perusahaan){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_perusahaan", perusahaan.getKode_perusahaan());
        contentValues.put("nama_pemilik_perusahaan", perusahaan.getNama_pemilik_perusahaan());
        contentValues.put("alamat_perusahaan", perusahaan.getAlamat_perusahaan());
        contentValues.put("email_perusahaan", perusahaan.getEmail_perusahaan());
        contentValues.put("no_telepon_perusahaan", perusahaan.getNo_telepon_perusahaan());
        long insertid = database.insert("perusahaan", null, contentValues);
        return insertid;
    }

    //mendapatkan 1 perusahaan
    public Perusahaan getPerusahaan(long kode_perusahaan){
        Cursor cursor = database.query("perusahaan",
                allColumnsPerusahaan,
                "kode_perusahaan=?",
                new String[]{String.valueOf(kode_perusahaan)},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        Perusahaan perusahaan = new Perusahaan(cursor.getLong(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4));

        return perusahaan;
    }

    //mendapatkan semua perusahaan
    public List<Perusahaan> getAllPerusahaan(){
        Cursor cursor = database.query("perusahaan",
                allColumnsPerusahaan,
                null,
                null,
                null,
                null,
                null);

        List<Perusahaan> perusahaans = new ArrayList<>();
        if(cursor.getCount() > 0 ){
            while(cursor.moveToNext()){
                Perusahaan perusahaan = new Perusahaan();
                perusahaan.setKode_perusahaan(cursor.getLong(cursor.getColumnIndex("kode_perusahaan")));
                perusahaan.setNama_pemilik_perusahaan(cursor.getString(cursor.getColumnIndex("nama_pemilik_perusahaan")));
                perusahaan.setAlamat_perusahaan(cursor.getString(cursor.getColumnIndex("alamat_perusahaan")));
                perusahaan.setEmail_perusahaan(cursor.getString(cursor.getColumnIndex("email_perusahaan")));
                perusahaan.setNo_telepon_perusahaan(cursor.getString(cursor.getColumnIndex("no_telepon_perusahaan")));
                perusahaans.add(perusahaan);
            }
        }

        return perusahaans;
    }

    public void updatePerusahaan(Perusahaan perusahaan){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_perusahaan", perusahaan.getKode_perusahaan());
        contentValues.put("nama_pemilik_perusahaan", perusahaan.getNama_pemilik_perusahaan());
        contentValues.put("alamat_perusahaan", perusahaan.getAlamat_perusahaan());
        contentValues.put("email_perusahaan", perusahaan.getEmail_perusahaan());
        contentValues.put("no_telepon_perusahaan", perusahaan.getNo_telepon_perusahaan());
        database.update("perusahaan", contentValues, "kode_perusahaan=?", new String[]{String.valueOf(perusahaan.getKode_perusahaan())});
    }

    public void deletePerusahaan(Perusahaan perusahaan){
        database.delete("perusahaan", "kode_perusahaan=?", new String[]{String.valueOf(perusahaan.getKode_perusahaan())});
    }

//untuk table admin
    private final String[] allColumnsAdmin = {
        "username_admin",
        "kode_perusahaan_admin",
        "password_admin",
        "nama_lengkap_admin",
        "no_telepon_admin"
    };

    public void addAdmin(Admin admin){
        ContentValues contentValues = new ContentValues();
        contentValues.put("username_admin", admin.getUsername_admin());
        contentValues.put("kode_perusahaan_admin", admin.getKode_perusahaan_admin());
        contentValues.put("password_admin", admin.getPassword_admin());
        contentValues.put("nama_lengkap_admin", admin.getNama_lengkap_admin());
        contentValues.put("no_telepon_admin", admin.getNo_telepon_admin());
        database.insert("admin", null, contentValues);
    }

    //mendapatkan 1 admin
    public Admin getAdmin(String username_admin){
        Cursor cursor = database.query("admin",
                allColumnsAdmin,
                "username_admin=?",
                new String[]{username_admin},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        Admin admin = new Admin(cursor.getString(0),
                cursor.getLong(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4));

        return admin;
    }

    //mendapatkan semua admin
    public List<Admin> getAllAdmin(){
        Cursor cursor = database.query("admin",
                allColumnsAdmin,
                null,
                null,
                null,
                null,
                null);

        List<Admin> admins = new ArrayList<>();
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                Admin admin = new Admin();
                admin.setUsername_admin(cursor.getString(cursor.getColumnIndex("username_admin")));
                admin.setKode_perusahaan_admin(cursor.getLong(cursor.getColumnIndex("kode_perusahaan_admin")));
                admin.setPassword_admin(cursor.getString(cursor.getColumnIndex("password_admin")));
                admin.setNama_lengkap_admin(cursor.getString(cursor.getColumnIndex("nama_lengkap_admin")));
                admin.setNo_telepon_admin(cursor.getString(cursor.getColumnIndex("no_telepon_admin")));
                admins.add(admin);
            }
        }

        return admins;
    }

    public void updateAdmin(Admin admin){
        ContentValues contentValues = new ContentValues();
        contentValues.put("username_admin", admin.getUsername_admin());
        contentValues.put("kode_perusahaan_admin", admin.getKode_perusahaan_admin());
        contentValues.put("password_admin", admin.getPassword_admin());
        contentValues.put("nama_lengkap_admin", admin.getNama_lengkap_admin());
        contentValues.put("no_telepon_admin", admin.getNo_telepon_admin());
        database.update("admin", contentValues, "username_admin=?", new String[]{admin.getUsername_admin()});
    }

    public void deleteAdmin(Admin admin){
        database.delete("admin", "username_admin=?", new String[]{admin.getUsername_admin()});
    }
}
