<?php

namespace backend\models;

use Yii;

/**
 * This is the model class for table "produk".
 *
 * @property string $kode_produk
 * @property string $jenis_produk
 * @property string $kategori_produk
 * @property string $nama_produk
 * @property string $deskripsi_produk
 * @property int $harga_jual_produk
 * @property int $harga_beli_produk
 * @property string $satuan_produk
 * @property string $gambar_produk
 * @property int $stok_produk
 * @property int $stok_kritis_produk
 * @property string $status_produk
 *
 * @property ListProdukBundle[] $listProdukBundles
 * @property ListProdukRestock[] $listProdukRestocks
 * @property ListProdukTerjual[] $listProdukTerjuals
 * @property ProdukDiskon[] $produkDiskons
 */
class Produk extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'produk';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_produk', 'jenis_produk', 'kategori_produk', 'nama_produk', 'deskripsi_produk', 'harga_jual_produk', 'harga_beli_produk', 'satuan_produk', 'gambar_produk', 'stok_produk', 'stok_kritis_produk', 'status_produk'], 'required'],
            [['deskripsi_produk'], 'string'],
            [['harga_jual_produk', 'harga_beli_produk', 'stok_produk', 'stok_kritis_produk'], 'integer'],
            [['kode_produk'], 'string', 'max' => 13],
            [['jenis_produk'], 'string', 'max' => 6],
            [['kategori_produk', 'nama_produk', 'satuan_produk'], 'string', 'max' => 25],
            [['gambar_produk'], 'string', 'max' => 50],
            [['status_produk'], 'string', 'max' => 5],
            [['kode_produk'], 'unique'],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'kode_produk' => 'Kode Produk',
            'jenis_produk' => 'Jenis Produk',
            'kategori_produk' => 'Kategori Produk',
            'nama_produk' => 'Nama Produk',
            'deskripsi_produk' => 'Deskripsi Produk',
            'harga_jual_produk' => 'Harga Jual Produk',
            'harga_beli_produk' => 'Harga Beli Produk',
            'satuan_produk' => 'Satuan Produk',
            'gambar_produk' => 'Gambar Produk',
            'stok_produk' => 'Stok Produk',
            'stok_kritis_produk' => 'Stok Kritis Produk',
            'status_produk' => 'Status Produk',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getListProdukBundles()
    {
        return $this->hasMany(ListProdukBundle::className(), ['kode_produk_list_bundle' => 'kode_produk']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getListProdukRestocks()
    {
        return $this->hasMany(ListProdukRestock::className(), ['kode_produk_list_restock' => 'kode_produk']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getListProdukTerjuals()
    {
        return $this->hasMany(ListProdukTerjual::className(), ['kode_produk_list_terjual' => 'kode_produk']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getProdukDiskons()
    {
        return $this->hasMany(ProdukDiskon::className(), ['kode_produk_diskon' => 'kode_produk']);
    }
}
