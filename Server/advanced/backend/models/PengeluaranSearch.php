<?php

namespace backend\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use backend\models\Pengeluaran;

/**
 * PengeluaranSearch represents the model behind the search form of `backend\models\Pengeluaran`.
 */
class PengeluaranSearch extends Pengeluaran
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_data_pengeluaran', 'kode_toko_pengeluaran', 'jumlah_pengeluaran'], 'integer'],
            [['kode_pengeluaran', 'tanggal_pengeluaran'], 'safe'],
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
        $query = Pengeluaran::find();

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
            'kode_data_pengeluaran' => $this->kode_data_pengeluaran,
            'kode_toko_pengeluaran' => $this->kode_toko_pengeluaran,
            'tanggal_pengeluaran' => $this->tanggal_pengeluaran,
            'jumlah_pengeluaran' => $this->jumlah_pengeluaran,
        ]);

        $query->andFilterWhere(['like', 'kode_pengeluaran', $this->kode_pengeluaran]);

        return $dataProvider;
    }
}
