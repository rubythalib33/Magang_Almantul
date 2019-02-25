<?php

use yii\helpers\Html;
use yii\grid\GridView;

/* @var $this yii\web\View */
/* @var $searchModel backend\models\ProdukSearch */
/* @var $dataProvider yii\data\ActiveDataProvider */

$this->title = 'Produks';
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="produk-index">

    <h1><?= Html::encode($this->title) ?></h1>
    <?php // echo $this->render('_search', ['model' => $searchModel]); ?>

    <p>
        <?= Html::a('Create Produk', ['create'], ['class' => 'btn btn-success']) ?>
    </p>

    <?= GridView::widget([
        'dataProvider' => $dataProvider,
        'filterModel' => $searchModel,
        'columns' => [
            ['class' => 'yii\grid\SerialColumn'],

            'kode_produk',
            'jenis_produk',
            'kategori_produk',
            'nama_produk',
            'deskripsi_produk:ntext',
            //'harga_jual_produk',
            //'harga_beli_produk',
            //'satuan_produk',
            //'gambar_produk',
            //'stok_produk',
            //'stok_kritis_produk',
            //'status_produk',

            ['class' => 'yii\grid\ActionColumn'],
        ],
    ]); ?>
</div>
