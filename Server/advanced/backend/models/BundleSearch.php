<?php

namespace backend\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use backend\models\Bundle;

/**
 * BundleSearch represents the model behind the search form of `backend\models\Bundle`.
 */
class BundleSearch extends Bundle
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_bundle', 'harga_bundle'], 'integer'],
            [['nama_bundle', 'tanggal_mulai_berlaku_bundle', 'tanggal_berakhir_bundle'], 'safe'],
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
        $query = Bundle::find();

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
            'kode_bundle' => $this->kode_bundle,
            'harga_bundle' => $this->harga_bundle,
            'tanggal_mulai_berlaku_bundle' => $this->tanggal_mulai_berlaku_bundle,
            'tanggal_berakhir_bundle' => $this->tanggal_berakhir_bundle,
        ]);

        $query->andFilterWhere(['like', 'nama_bundle', $this->nama_bundle]);

        return $dataProvider;
    }
}
