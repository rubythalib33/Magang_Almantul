<?php

namespace backend\models;

use Yii;

/**
 * This is the model class for table "toko".
 *
 * @property int $kode_toko
 * @property int $kode_perusahaan_toko
 * @property string $manager_toko
 * @property string $alamat_toko
 * @property string $no_telepon_toko
 *
 * @property Pegawai[] $pegawais
 * @property Pemasukan[] $pemasukans
 * @property Pengeluaran[] $pengeluarans
 * @property Perusahaan $kodePerusahaanToko
 */
class Toko extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'toko';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_perusahaan_toko', 'manager_toko', 'alamat_toko', 'no_telepon_toko'], 'required'],
            [['kode_perusahaan_toko'], 'integer'],
            [['alamat_toko'], 'string'],
            [['manager_toko'], 'string', 'max' => 50],
            [['no_telepon_toko'], 'string', 'max' => 14],
            [['kode_perusahaan_toko'], 'exist', 'skipOnError' => true, 'targetClass' => Perusahaan::className(), 'targetAttribute' => ['kode_perusahaan_toko' => 'kode_perusahaan']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'kode_toko' => 'Kode Toko',
            'kode_perusahaan_toko' => 'Kode Perusahaan Toko',
            'manager_toko' => 'Manager Toko',
            'alamat_toko' => 'Alamat Toko',
            'no_telepon_toko' => 'No Telepon Toko',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getPegawais()
    {
        return $this->hasMany(Pegawai::className(), ['kode_toko_pegawai' => 'kode_toko']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getPemasukans()
    {
        return $this->hasMany(Pemasukan::className(), ['kode_toko_pemasukan' => 'kode_toko']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getPengeluarans()
    {
        return $this->hasMany(Pengeluaran::className(), ['kode_toko_pengeluaran' => 'kode_toko']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getKodePerusahaanToko()
    {
        return $this->hasOne(Perusahaan::className(), ['kode_perusahaan' => 'kode_perusahaan_toko']);
    }
}
