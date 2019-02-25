<?php

namespace backend\models;

use Yii;

/**
 * This is the model class for table "produk_diskon".
 *
 * @property int $kode_diskon
 * @property string $kode_produk_diskon
 * @property int $besar_diskon(%)
 * @property string $tanggal_mulai_berlaku_diskon
 * @property string $tanggal_berakhir_diskon
 *
 * @property Produk $kodeProdukDiskon
 */
class ProdukDiskon extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'produk_diskon';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_produk_diskon', 'besar_diskon(%)', 'tanggal_mulai_berlaku_diskon', 'tanggal_berakhir_diskon'], 'required'],
            [['besar_diskon(%)'], 'integer'],
            [['tanggal_mulai_berlaku_diskon', 'tanggal_berakhir_diskon'], 'safe'],
            [['kode_produk_diskon'], 'string', 'max' => 13],
            [['kode_produk_diskon'], 'exist', 'skipOnError' => true, 'targetClass' => Produk::className(), 'targetAttribute' => ['kode_produk_diskon' => 'kode_produk']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'kode_diskon' => 'Kode Diskon',
            'kode_produk_diskon' => 'Kode Produk Diskon',
            'besar_diskon(%)' => 'Besar Diskon(%)',
            'tanggal_mulai_berlaku_diskon' => 'Tanggal Mulai Berlaku Diskon',
            'tanggal_berakhir_diskon' => 'Tanggal Berakhir Diskon',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getKodeProdukDiskon()
    {
        return $this->hasOne(Produk::className(), ['kode_produk' => 'kode_produk_diskon']);
    }
}
