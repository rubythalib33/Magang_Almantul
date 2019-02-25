<?php

namespace backend\models;

use Yii;

/**
 * This is the model class for table "transaksi_penjualan".
 *
 * @property int $kode_penjualan
 * @property string $username_pegawai_penjualan
 * @property string $tanggal_transaksi_penjualan
 *
 * @property ListProdukTerjual[] $listProdukTerjuals
 * @property Pegawai $usernamePegawaiPenjualan
 */
class TransaksiPenjualan extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'transaksi_penjualan';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['username_pegawai_penjualan', 'tanggal_transaksi_penjualan'], 'required'],
            [['tanggal_transaksi_penjualan'], 'safe'],
            [['username_pegawai_penjualan'], 'string', 'max' => 25],
            [['username_pegawai_penjualan'], 'exist', 'skipOnError' => true, 'targetClass' => Pegawai::className(), 'targetAttribute' => ['username_pegawai_penjualan' => 'username_pegawai']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'kode_penjualan' => 'Kode Penjualan',
            'username_pegawai_penjualan' => 'Username Pegawai Penjualan',
            'tanggal_transaksi_penjualan' => 'Tanggal Transaksi Penjualan',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getListProdukTerjuals()
    {
        return $this->hasMany(ListProdukTerjual::className(), ['kode_penjualan_list' => 'kode_penjualan']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getUsernamePegawaiPenjualan()
    {
        return $this->hasOne(Pegawai::className(), ['username_pegawai' => 'username_pegawai_penjualan']);
    }
}
