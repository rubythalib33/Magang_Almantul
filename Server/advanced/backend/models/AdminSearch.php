<?php

namespace backend\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use backend\models\Admin;

/**
 * AdminSearch represents the model behind the search form of `backend\models\Admin`.
 */
class AdminSearch extends Admin
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['username_admin', 'password_admin', 'nama_lengkap_admin', 'no_telepon_admin'], 'safe'],
            [['kode_perusahaan_admin'], 'integer'],
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
        $query = Admin::find();

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
            'kode_perusahaan_admin' => $this->kode_perusahaan_admin,
        ]);

        $query->andFilterWhere(['like', 'username_admin', $this->username_admin])
            ->andFilterWhere(['like', 'password_admin', $this->password_admin])
            ->andFilterWhere(['like', 'nama_lengkap_admin', $this->nama_lengkap_admin])
            ->andFilterWhere(['like', 'no_telepon_admin', $this->no_telepon_admin]);

        return $dataProvider;
    }
}
