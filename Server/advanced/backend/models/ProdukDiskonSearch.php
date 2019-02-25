<?php

namespace backend\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use backend\models\ProdukDiskon;

/**
 * ProdukDiskonSearch represents the model behind the search form of `backend\models\ProdukDiskon`.
 */
class ProdukDiskonSearch extends ProdukDiskon
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_diskon', 'besar_diskon(%)'], 'integer'],
            [['kode_produk_diskon', 'tanggal_mulai_berlaku_diskon', 'tanggal_berakhir_diskon'], 'safe'],
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
        $query = ProdukDiskon::find();

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
            'kode_diskon' => $this->kode_diskon,
            'besar_diskon(%)' => $this->besar_diskon(%),
            'tanggal_mulai_berlaku_diskon' => $this->tanggal_mulai_berlaku_diskon,
            'tanggal_berakhir_diskon' => $this->tanggal_berakhir_diskon,
        ]);

        $query->andFilterWhere(['like', 'kode_produk_diskon', $this->kode_produk_diskon]);

        return $dataProvider;
    }
}
