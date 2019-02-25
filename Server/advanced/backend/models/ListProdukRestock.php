<?php

namespace backend\models;

use Yii;

/**
 * This is the model class for table "list_produk_restock".
 *
 * @property int $id_list_produk_restock
 * @property int $kode_restock_list
 * @property string $kode_produk_list_restock
 * @property int $jumlah_produk_restock
 *
 * @property Restock $kodeRestockList
 * @property Produk $kodeProdukListRestock
 */
class ListProdukRestock extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'list_produk_restock';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_restock_list', 'kode_produk_list_restock', 'jumlah_produk_restock'], 'required'],
            [['kode_restock_list', 'jumlah_produk_restock'], 'integer'],
            [['kode_produk_list_restock'], 'string', 'max' => 13],
            [['kode_restock_list'], 'exist', 'skipOnError' => true, 'targetClass' => Restock::className(), 'targetAttribute' => ['kode_restock_list' => 'kode_restock']],
            [['kode_produk_list_restock'], 'exist', 'skipOnError' => true, 'targetClass' => Produk::className(), 'targetAttribute' => ['kode_produk_list_restock' => 'kode_produk']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'id_list_produk_restock' => 'Id List Produk Restock',
            'kode_restock_list' => 'Kode Restock List',
            'kode_produk_list_restock' => 'Kode Produk List Restock',
            'jumlah_produk_restock' => 'Jumlah Produk Restock',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getKodeRestockList()
    {
        return $this->hasOne(Restock::className(), ['kode_restock' => 'kode_restock_list']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getKodeProdukListRestock()
    {
        return $this->hasOne(Produk::className(), ['kode_produk' => 'kode_produk_list_restock']);
    }
}
