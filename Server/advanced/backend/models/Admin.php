<?php

namespace backend\models;

use Yii;

/**
 * This is the model class for table "admin".
 *
 * @property string $username_admin
 * @property int $kode_perusahaan_admin
 * @property string $password_admin
 * @property string $nama_lengkap_admin
 * @property string $no_telepon_admin
 *
 * @property Perusahaan $kodePerusahaanAdmin
 */
class Admin extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'admin';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['username_admin', 'kode_perusahaan_admin', 'password_admin', 'nama_lengkap_admin', 'no_telepon_admin'], 'required'],
            [['kode_perusahaan_admin'], 'integer'],
            [['username_admin', 'password_admin'], 'string', 'max' => 25],
            [['nama_lengkap_admin'], 'string', 'max' => 50],
            [['no_telepon_admin'], 'string', 'max' => 14],
            [['username_admin'], 'unique'],
            [['kode_perusahaan_admin'], 'exist', 'skipOnError' => true, 'targetClass' => Perusahaan::className(), 'targetAttribute' => ['kode_perusahaan_admin' => 'kode_perusahaan']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'username_admin' => 'Username Admin',
            'kode_perusahaan_admin' => 'Kode Perusahaan Admin',
            'password_admin' => 'Password Admin',
            'nama_lengkap_admin' => 'Nama Lengkap Admin',
            'no_telepon_admin' => 'No Telepon Admin',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getKodePerusahaanAdmin()
    {
        return $this->hasOne(Perusahaan::className(), ['kode_perusahaan' => 'kode_perusahaan_admin']);
    }
}
