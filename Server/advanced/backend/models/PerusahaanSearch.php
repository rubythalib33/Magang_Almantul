<?php

namespace backend\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use backend\models\Perusahaan;

/**
 * PerusahaanSearch represents the model behind the search form of `backend\models\Perusahaan`.
 */
class PerusahaanSearch extends Perusahaan
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_perusahaan'], 'integer'],
            [['nama_pemilik_perusahaan', 'alamat_perusahaan', 'tanggal_berdiri_perusahaan', 'email_perusahaan', 'no_telepon_perusahaan'], 'safe'],
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
        $query = Perusahaan::find();

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
            'kode_perusahaan' => $this->kode_perusahaan,
            'tanggal_berdiri_perusahaan' => $this->tanggal_berdiri_perusahaan,
        ]);

        $query->andFilterWhere(['like', 'nama_pemilik_perusahaan', $this->nama_pemilik_perusahaan])
            ->andFilterWhere(['like', 'alamat_perusahaan', $this->alamat_perusahaan])
            ->andFilterWhere(['like', 'email_perusahaan', $this->email_perusahaan])
            ->andFilterWhere(['like', 'no_telepon_perusahaan', $this->no_telepon_perusahaan]);

        return $dataProvider;
    }
}
