<?php

namespace backend\models;

use Yii;

/**
 * This is the model class for table "list_produk_bundle".
 *
 * @property int $id_list_produk_bundle
 * @property int $kode_bundle_list
 * @property string $kode_produk_list_bundle
 *
 * @property Bundle $kodeBundleList
 * @property Produk $kodeProdukListBundle
 */
class ListProdukBundle extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'list_produk_bundle';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_bundle_list', 'kode_produk_list_bundle'], 'required'],
            [['kode_bundle_list'], 'integer'],
            [['kode_produk_list_bundle'], 'string', 'max' => 13],
            [['kode_bundle_list'], 'exist', 'skipOnError' => true, 'targetClass' => Bundle::className(), 'targetAttribute' => ['kode_bundle_list' => 'kode_bundle']],
            [['kode_produk_list_bundle'], 'exist', 'skipOnError' => true, 'targetClass' => Produk::className(), 'targetAttribute' => ['kode_produk_list_bundle' => 'kode_produk']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'id_list_produk_bundle' => 'Id List Produk Bundle',
            'kode_bundle_list' => 'Kode Bundle List',
            'kode_produk_list_bundle' => 'Kode Produk List Bundle',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getKodeBundleList()
    {
        return $this->hasOne(Bundle::className(), ['kode_bundle' => 'kode_bundle_list']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getKodeProdukListBundle()
    {
        return $this->hasOne(Produk::className(), ['kode_produk' => 'kode_produk_list_bundle']);
    }
}
