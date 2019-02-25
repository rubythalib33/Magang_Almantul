<?php

namespace backend\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use backend\models\Produk;

/**
 * ProdukSearch represents the model behind the search form of `backend\models\Produk`.
 */
class ProdukSearch extends Produk
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['kode_produk', 'jenis_produk', 'kategori_produk', 'nama_produk', 'deskripsi_produk', 'satuan_produk', 'gambar_produk', 'status_produk'], 'safe'],
            [['harga_jual_produk', 'harga_beli_produk', 'stok_produk', 'stok_kritis_produk'], 'integer'],
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
        $query = Produk::find();

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
            'harga_jual_produk' => $this->harga_jual_produk,
            'harga_beli_produk' => $this->harga_beli_produk,
            'stok_produk' => $this->stok_produk,
            'stok_kritis_produk' => $this->stok_kritis_produk,
        ]);

        $query->andFilterWhere(['like', 'kode_produk', $this->kode_produk])
            ->andFilterWhere(['like', 'jenis_produk', $this->jenis_produk])
            ->andFilterWhere(['like', 'kategori_produk', $this->kategori_produk])
            ->andFilterWhere(['like', 'nama_produk', $this->nama_produk])
            ->andFilterWhere(['like', 'deskripsi_produk', $this->deskripsi_produk])
            ->andFilterWhere(['like', 'satuan_produk', $this->satuan_produk])
            ->andFilterWhere(['like', 'gambar_produk', $this->gambar_produk])
            ->andFilterWhere(['like', 'status_produk', $this->status_produk]);

        return $dataProvider;
    }
}
