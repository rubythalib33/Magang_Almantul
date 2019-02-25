<?php

namespace backend\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use backend\models\ListProdukRestock;

/**
 * ListProdukRestockSearch represents the model behind the search form of `backend\models\ListProdukRestock`.
 */
class ListProdukRestockSearch extends ListProdukRestock
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['id_list_produk_restock', 'kode_restock_list', 'jumlah_produk_restock'], 'integer'],
            [['kode_produk_list_restock'], 'safe'],
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
        $query = ListProdukRestock::find();

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
            'id_list_produk_restock' => $this->id_list_produk_restock,
            'kode_restock_list' => $this->kode_restock_list,
            'jumlah_produk_restock' => $this->jumlah_produk_restock,
        ]);

        $query->andFilterWhere(['like', 'kode_produk_list_restock', $this->kode_produk_list_restock]);

        return $dataProvider;
    }
}
