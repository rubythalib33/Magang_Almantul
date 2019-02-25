<?php

namespace backend\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use backend\models\Pegawai;

/**
 * PegawaiSearch represents the model behind the search form of `backend\models\Pegawai`.
 */
class PegawaiSearch extends Pegawai
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['username_pegawai', 'password_pegawai', 'jabatan_pegawai', 'nama_lengkap_pegawai', 'no_telepon_pegawai'], 'safe'],
            [['kode_toko_pegawai'], 'integer'],
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
        $query = Pegawai::find();

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
            'kode_toko_pegawai' => $this->kode_toko_pegawai,
        ]);

        $query->andFilterWhere(['like', 'username_pegawai', $this->username_pegawai])
            ->andFilterWhere(['like', 'password_pegawai', $this->password_pegawai])
            ->andFilterWhere(['like', 'jabatan_pegawai', $this->jabatan_pegawai])
            ->andFilterWhere(['like', 'nama_lengkap_pegawai', $this->nama_lengkap_pegawai])
            ->andFilterWhere(['like', 'no_telepon_pegawai', $this->no_telepon_pegawai]);

        return $dataProvider;
    }
}
