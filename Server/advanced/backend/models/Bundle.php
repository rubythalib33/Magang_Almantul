<?php

namespace backend\models;

use Yii;

/**
 * This is the model class for table "bundle".
 *
 * @property int $kode_bundle
 * @property string $nama_bundle
 * @property int $harga_bundle
 * @property string $tanggal_mulai_berlaku_bundle
 * @property string $tanggal_berakhir_bundle
 *
 * @property ListProdukBundle[] $listProdukBundles
 */
class Bundle extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'bundle';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['nama_bundle', 'harga_bundle', 'tanggal_mulai_berlaku_bundle', 'tanggal_berakhir_bundle'], 'required'],
            [['harga_bundle'], 'integer'],
            [['tanggal_mulai_berlaku_bundle', 'tanggal_berakhir_bundle'], 'safe'],
            [['nama_bundle'], 'string', 'max' => 25],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'kode_bundle' => 'Kode Bundle',
            'nama_bundle' => 'Nama Bundle',
            'harga_bundle' => 'Harga Bundle',
            'tanggal_mulai_berlaku_bundle' => 'Tanggal Mulai Berlaku Bundle',
            'tanggal_berakhir_bundle' => 'Tanggal Berakhir Bundle',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getListProdukBundles()
    {
        return $this->hasMany(ListProdukBundle::className(), ['kode_bundle_list' => 'kode_bundle']);
    }
}
