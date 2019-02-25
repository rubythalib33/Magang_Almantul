<?php

namespace backend\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use backend\models\ListProdukBundle;

/**
 * ListProdukBundleSearch represents the model behind the search form of `backend\models\ListProdukBundle`.
 */
class ListProdukBundleSearch extends ListProdukBundle
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['id_list_produk_bundle', 'kode_bundle_list'], 'integer'],
            [['kode_produk_list_bundle'], 'safe'],
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
        $query = ListProdukBundle::find();

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
            'id_list_produk_bundle' => $this->id_list_produk_bundle,
            'kode_bundle_list' => $this->kode_bundle_list,
        ]);

        $query->andFilterWhere(['like', 'kode_produk_list_bundle', $this->kode_produk_list_bundle]);

        return $dataProvider;
    }
}
