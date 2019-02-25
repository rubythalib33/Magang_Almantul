<?php

namespace backend\models;

use Yii;

/**
 * This is the model class for table "pemasukan".
 *
 * @property int $kode_data_pemasukan
 * @property int $kode_toko_pemasukan
 * @property string $kode_pemasukan
 * @property string $tanggal_pemasukan
 * @property int $jumlah_pemasukan
 *
 * @property Toko $kodeTokoPemasukan
 */
class Pemasukan extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'pemasukan';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_toko_pemasukan', 'kode_pemasukan', 'tanggal_pemasukan', 'jumlah_pemasukan'], 'required'],
            [['kode_toko_pemasukan', 'jumlah_pemasukan'], 'integer'],
            [['tanggal_pemasukan'], 'safe'],
            [['kode_pemasukan'], 'string', 'max' => 5],
            [['kode_toko_pemasukan'], 'exist', 'skipOnError' => true, 'targetClass' => Toko::className(), 'targetAttribute' => ['kode_toko_pemasukan' => 'kode_toko']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'kode_data_pemasukan' => 'Kode Data Pemasukan',
            'kode_toko_pemasukan' => 'Kode Toko Pemasukan',
            'kode_pemasukan' => 'Kode Pemasukan',
            'tanggal_pemasukan' => 'Tanggal Pemasukan',
            'jumlah_pemasukan' => 'Jumlah Pemasukan',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getKodeTokoPemasukan()
    {
        return $this->hasOne(Toko::className(), ['kode_toko' => 'kode_toko_pemasukan']);
    }
}
