<?php

namespace backend\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use backend\models\ListProdukTerjual;

/**
 * ListProdukTerjualSearch represents the model behind the search form of `backend\models\ListProdukTerjual`.
 */
class ListProdukTerjualSearch extends ListProdukTerjual
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['id_list_produk_terjual', 'kode_penjualan_list', 'jumlah_produk_terjual'], 'integer'],
            [['kode_produk_list_terjual'], 'safe'],
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
        $query = ListProdukTerjual::find();

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
            'id_list_produk_terjual' => $this->id_list_produk_terjual,
            'kode_penjualan_list' => $this->kode_penjualan_list,
            'jumlah_produk_terjual' => $this->jumlah_produk_terjual,
        ]);

        $query->andFilterWhere(['like', 'kode_produk_list_terjual', $this->kode_produk_list_terjual]);

        return $dataProvider;
    }
}
