<?php

namespace backend\models;

use Yii;

/**
 * This is the model class for table "supplier".
 *
 * @property int $kode_supplier
 * @property string $nama_supplier
 * @property string $email_supplier
 * @property string $no_telepon_supplier
 * @property string $alamat_supplier
 *
 * @property Restock[] $restocks
 */
class Supplier extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'supplier';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['nama_supplier', 'email_supplier', 'no_telepon_supplier', 'alamat_supplier'], 'required'],
            [['alamat_supplier'], 'string'],
            [['nama_supplier', 'email_supplier'], 'string', 'max' => 25],
            [['no_telepon_supplier'], 'string', 'max' => 13],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'kode_supplier' => 'Kode Supplier',
            'nama_supplier' => 'Nama Supplier',
            'email_supplier' => 'Email Supplier',
            'no_telepon_supplier' => 'No Telepon Supplier',
            'alamat_supplier' => 'Alamat Supplier',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getRestocks()
    {
        return $this->hasMany(Restock::className(), ['kode_supplier_restock' => 'kode_supplier']);
    }
}
