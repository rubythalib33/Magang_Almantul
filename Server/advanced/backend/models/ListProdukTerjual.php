<?php

namespace backend\models;

use Yii;

/**
 * This is the model class for table "list_produk_terjual".
 *
 * @property int $id_list_produk_terjual
 * @property int $kode_penjualan_list
 * @property string $kode_produk_list_terjual
 * @property int $jumlah_produk_terjual
 *
 * @property TransaksiPenjualan $kodePenjualanList
 * @property Produk $kodeProdukListTerjual
 */
class ListProdukTerjual extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'list_produk_terjual';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_penjualan_list', 'kode_produk_list_terjual', 'jumlah_produk_terjual'], 'required'],
            [['kode_penjualan_list', 'jumlah_produk_terjual'], 'integer'],
            [['kode_produk_list_terjual'], 'string', 'max' => 13],
            [['kode_penjualan_list'], 'exist', 'skipOnError' => true, 'targetClass' => TransaksiPenjualan::className(), 'targetAttribute' => ['kode_penjualan_list' => 'kode_penjualan']],
            [['kode_produk_list_terjual'], 'exist', 'skipOnError' => true, 'targetClass' => Produk::className(), 'targetAttribute' => ['kode_produk_list_terjual' => 'kode_produk']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'id_list_produk_terjual' => 'Id List Produk Terjual',
            'kode_penjualan_list' => 'Kode Penjualan List',
            'kode_produk_list_terjual' => 'Kode Produk List Terjual',
            'jumlah_produk_terjual' => 'Jumlah Produk Terjual',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getKodePenjualanList()
    {
        return $this->hasOne(TransaksiPenjualan::className(), ['kode_penjualan' => 'kode_penjualan_list']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getKodeProdukListTerjual()
    {
        return $this->hasOne(Produk::className(), ['kode_produk' => 'kode_produk_list_terjual']);
    }
}
