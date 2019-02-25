<?php

namespace backend\models;

use Yii;

/**
 * This is the model class for table "restock".
 *
 * @property int $kode_restock
 * @property int $kode_supplier_restock
 * @property string $username_pegawai_restock
 * @property string $tanggal_transaksi_restock
 * @property string $tanggal_jatuh_tempo
 * @property string $bukti_transaksi_restock
 *
 * @property ListProdukRestock[] $listProdukRestocks
 * @property Supplier $kodeSupplierRestock
 * @property Pegawai $usernamePegawaiRestock
 */
class Restock extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'restock';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_supplier_restock', 'username_pegawai_restock', 'tanggal_transaksi_restock', 'tanggal_jatuh_tempo'], 'required'],
            [['kode_supplier_restock'], 'integer'],
            [['tanggal_transaksi_restock', 'tanggal_jatuh_tempo'], 'safe'],
            [['username_pegawai_restock'], 'string', 'max' => 25],
            [['bukti_transaksi_restock'], 'string', 'max' => 50],
            [['kode_supplier_restock'], 'exist', 'skipOnError' => true, 'targetClass' => Supplier::className(), 'targetAttribute' => ['kode_supplier_restock' => 'kode_supplier']],
            [['username_pegawai_restock'], 'exist', 'skipOnError' => true, 'targetClass' => Pegawai::className(), 'targetAttribute' => ['username_pegawai_restock' => 'username_pegawai']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'kode_restock' => 'Kode Restock',
            'kode_supplier_restock' => 'Kode Supplier Restock',
            'username_pegawai_restock' => 'Username Pegawai Restock',
            'tanggal_transaksi_restock' => 'Tanggal Transaksi Restock',
            'tanggal_jatuh_tempo' => 'Tanggal Jatuh Tempo',
            'bukti_transaksi_restock' => 'Bukti Transaksi Restock',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getListProdukRestocks()
    {
        return $this->hasMany(ListProdukRestock::className(), ['kode_restock_list' => 'kode_restock']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getKodeSupplierRestock()
    {
        return $this->hasOne(Supplier::className(), ['kode_supplier' => 'kode_supplier_restock']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getUsernamePegawaiRestock()
    {
        return $this->hasOne(Pegawai::className(), ['username_pegawai' => 'username_pegawai_restock']);
    }
}
