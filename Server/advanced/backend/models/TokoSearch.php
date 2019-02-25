<?php

namespace backend\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use backend\models\Toko;

/**
 * TokoSearch represents the model behind the search form of `backend\models\Toko`.
 */
class TokoSearch extends Toko
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_toko', 'kode_perusahaan_toko'], 'integer'],
            [['manager_toko', 'alamat_toko', 'no_telepon_toko'], 'safe'],
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
        $query = Toko::find();

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
            'kode_toko' => $this->kode_toko,
            'kode_perusahaan_toko' => $this->kode_perusahaan_toko,
        ]);

        $query->andFilterWhere(['like', 'manager_toko', $this->manager_toko])
            ->andFilterWhere(['like', 'alamat_toko', $this->alamat_toko])
            ->andFilterWhere(['like', 'no_telepon_toko', $this->no_telepon_toko]);

        return $dataProvider;
    }
}
