<?php

namespace backend\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use backend\models\Restock;

/**
 * RestockSearch represents the model behind the search form of `backend\models\Restock`.
 */
class RestockSearch extends Restock
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_restock', 'kode_supplier_restock'], 'integer'],
            [['username_pegawai_restock', 'tanggal_transaksi_restock', 'tanggal_jatuh_tempo', 'bukti_transaksi_restock'], 'safe'],
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
        $query = Restock::find();

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
            'kode_restock' => $this->kode_restock,
            'kode_supplier_restock' => $this->kode_supplier_restock,
            'tanggal_transaksi_restock' => $this->tanggal_transaksi_restock,
            'tanggal_jatuh_tempo' => $this->tanggal_jatuh_tempo,
        ]);

        $query->andFilterWhere(['like', 'username_pegawai_restock', $this->username_pegawai_restock])
            ->andFilterWhere(['like', 'bukti_transaksi_restock', $this->bukti_transaksi_restock]);

        return $dataProvider;
    }
}
