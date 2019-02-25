<?php

namespace backend\models;

use Yii;

/**
 * This is the model class for table "pengeluaran".
 *
 * @property int $kode_data_pengeluaran
 * @property int $kode_toko_pengeluaran
 * @property string $kode_pengeluaran
 * @property string $tanggal_pengeluaran
 * @property int $jumlah_pengeluaran
 *
 * @property Toko $kodeTokoPengeluaran
 */
class Pengeluaran extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'pengeluaran';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_toko_pengeluaran', 'kode_pengeluaran', 'tanggal_pengeluaran', 'jumlah_pengeluaran'], 'required'],
            [['kode_toko_pengeluaran', 'jumlah_pengeluaran'], 'integer'],
            [['tanggal_pengeluaran'], 'safe'],
            [['kode_pengeluaran'], 'string', 'max' => 5],
            [['kode_toko_pengeluaran'], 'exist', 'skipOnError' => true, 'targetClass' => Toko::className(), 'targetAttribute' => ['kode_toko_pengeluaran' => 'kode_toko']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'kode_data_pengeluaran' => 'Kode Data Pengeluaran',
            'kode_toko_pengeluaran' => 'Kode Toko Pengeluaran',
            'kode_pengeluaran' => 'Kode Pengeluaran',
            'tanggal_pengeluaran' => 'Tanggal Pengeluaran',
            'jumlah_pengeluaran' => 'Jumlah Pengeluaran',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getKodeTokoPengeluaran()
    {
        return $this->hasOne(Toko::className(), ['kode_toko' => 'kode_toko_pengeluaran']);
    }
}
