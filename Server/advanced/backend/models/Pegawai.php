<?php

namespace backend\models;

use Yii;

/**
 * This is the model class for table "pegawai".
 *
 * @property string $username_pegawai
 * @property int $kode_toko_pegawai
 * @property string $password_pegawai
 * @property string $jabatan_pegawai
 * @property string $nama_lengkap_pegawai
 * @property string $no_telepon_pegawai
 *
 * @property Toko $kodeTokoPegawai
 * @property Restock[] $restocks
 * @property TransaksiPenjualan[] $transaksiPenjualans
 */
class Pegawai extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'pegawai';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['username_pegawai', 'kode_toko_pegawai', 'password_pegawai', 'jabatan_pegawai', 'nama_lengkap_pegawai', 'no_telepon_pegawai'], 'required'],
            [['kode_toko_pegawai'], 'integer'],
            [['username_pegawai', 'password_pegawai'], 'string', 'max' => 25],
            [['jabatan_pegawai'], 'string', 'max' => 10],
            [['nama_lengkap_pegawai'], 'string', 'max' => 50],
            [['no_telepon_pegawai'], 'string', 'max' => 14],
            [['username_pegawai'], 'unique'],
            [['kode_toko_pegawai'], 'exist', 'skipOnError' => true, 'targetClass' => Toko::className(), 'targetAttribute' => ['kode_toko_pegawai' => 'kode_toko']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'username_pegawai' => 'Username Pegawai',
            'kode_toko_pegawai' => 'Kode Toko Pegawai',
            'password_pegawai' => 'Password Pegawai',
            'jabatan_pegawai' => 'Jabatan Pegawai',
            'nama_lengkap_pegawai' => 'Nama Lengkap Pegawai',
            'no_telepon_pegawai' => 'No Telepon Pegawai',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getKodeTokoPegawai()
    {
        return $this->hasOne(Toko::className(), ['kode_toko' => 'kode_toko_pegawai']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getRestocks()
    {
        return $this->hasMany(Restock::className(), ['username_pegawai_restock' => 'username_pegawai']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getTransaksiPenjualans()
    {
        return $this->hasMany(TransaksiPenjualan::className(), ['username_pegawai_penjualan' => 'username_pegawai']);
    }
}
