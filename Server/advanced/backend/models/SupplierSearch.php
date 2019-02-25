<?php

namespace backend\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use backend\models\Supplier;

/**
 * SupplierSearch represents the model behind the search form of `backend\models\Supplier`.
 */
class SupplierSearch extends Supplier
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_supplier'], 'integer'],
            [['nama_supplier', 'email_supplier', 'no_telepon_supplier', 'alamat_supplier'], 'safe'],
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
        $query = Supplier::find();

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
            'kode_supplier' => $this->kode_supplier,
        ]);

        $query->andFilterWhere(['like', 'nama_supplier', $this->nama_supplier])
            ->andFilterWhere(['like', 'email_supplier', $this->email_supplier])
            ->andFilterWhere(['like', 'no_telepon_supplier', $this->no_telepon_supplier])
            ->andFilterWhere(['like', 'alamat_supplier', $this->alamat_supplier]);

        return $dataProvider;
    }
}
