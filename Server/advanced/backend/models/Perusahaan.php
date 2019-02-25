<?php

namespace backend\models;

use Yii;

/**
 * This is the model class for table "perusahaan".
 *
 * @property int $kode_perusahaan
 * @property string $nama_pemilik_perusahaan
 * @property string $alamat_perusahaan
 * @property string $tanggal_berdiri_perusahaan
 * @property string $email_perusahaan
 * @property string $no_telepon_perusahaan
 *
 * @property Admin[] $admins
 * @property Toko[] $tokos
 */
class Perusahaan extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'perusahaan';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['nama_pemilik_perusahaan', 'alamat_perusahaan', 'tanggal_berdiri_perusahaan', 'email_perusahaan', 'no_telepon_perusahaan'], 'required'],
            [['alamat_perusahaan'], 'string'],
            [['tanggal_berdiri_perusahaan'], 'safe'],
            [['nama_pemilik_perusahaan', 'email_perusahaan'], 'string', 'max' => 50],
            [['no_telepon_perusahaan'], 'string', 'max' => 14],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'kode_perusahaan' => 'Kode Perusahaan',
            'nama_pemilik_perusahaan' => 'Nama Pemilik Perusahaan',
            'alamat_perusahaan' => 'Alamat Perusahaan',
            'tanggal_berdiri_perusahaan' => 'Tanggal Berdiri Perusahaan',
            'email_perusahaan' => 'Email Perusahaan',
            'no_telepon_perusahaan' => 'No Telepon Perusahaan',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getAdmins()
    {
        return $this->hasMany(Admin::className(), ['kode_perusahaan_admin' => 'kode_perusahaan']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getTokos()
    {
        return $this->hasMany(Toko::className(), ['kode_perusahaan_toko' => 'kode_perusahaan']);
    }
}
