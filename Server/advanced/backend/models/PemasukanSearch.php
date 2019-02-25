<?php

namespace backend\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use backend\models\Pemasukan;

/**
 * PemasukanSearch represents the model behind the search form of `backend\models\Pemasukan`.
 */
class PemasukanSearch extends Pemasukan
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_data_pemasukan', 'kode_toko_pemasukan', 'jumlah_pemasukan'], 'integer'],
            [['kode_pemasukan', 'tanggal_pemasukan'], 'safe'],
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
        $query = Pemasukan::find();

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
            'kode_data_pemasukan' => $this->kode_data_pemasukan,
            'kode_toko_pemasukan' => $this->kode_toko_pemasukan,
            'tanggal_pemasukan' => $this->tanggal_pemasukan,
            'jumlah_pemasukan' => $this->jumlah_pemasukan,
        ]);

        $query->andFilterWhere(['like', 'kode_pemasukan', $this->kode_pemasukan]);

        return $dataProvider;
    }
}
