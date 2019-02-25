<?php

namespace backend\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use backend\models\TransaksiPenjualan;

/**
 * TransaksiPenjualanSearch represents the model behind the search form of `backend\models\TransaksiPenjualan`.
 */
class TransaksiPenjualanSearch extends TransaksiPenjualan
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_penjualan'], 'integer'],
            [['username_pegawai_penjualan', 'tanggal_transaksi_penjualan'], 'safe'],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function scenarios()
    {
        // bypass scenarios() implementation in the parent class
        return Model::scenarios();
    }

    /**
     * Creates data provider instance with search query applied
     *
     * @param array $params
     *
     * @return ActiveDataProvider
     */
    public function search($params)
    {
        $query = TransaksiPenjualan::find();

        // add conditions that should always apply here

        $dataProvider = new ActiveDataProvider([
            'query' => $query,
        ]);

        $this->load($params);

        if (!$this->validate()) {
            // uncomment the following line if you do not want to return any records when validation fails
            // $query->where('0=1');
            return $dataProvider;
        }

        // grid filtering conditions
        $query->andFilterWhere([
            'kode_penjualan' => $this->kode_penjualan,
            'tanggal_transaksi_penjualan' => $this->tanggal_transaksi_penjualan,
        ]);

        $query->andFilterWhere(['like', 'username_pegawai_penjualan', $this->username_pegawai_penjualan]);

        return $dataProvider;
    }
}
