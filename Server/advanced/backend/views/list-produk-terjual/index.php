<?php

use yii\helpers\Html;
use yii\grid\GridView;

/* @var $this yii\web\View */
/* @var $searchModel backend\models\ListProdukTerjualSearch */
/* @var $dataProvider yii\data\ActiveDataProvider */

$this->title = 'List Produk Terjuals';
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="list-produk-terjual-index">

    <h1><?= Html::encode($this->title) ?></h1>
    <?php // echo $this->render('_search', ['model' => $searchModel]); ?>

    <p>
        <?= Html::a('Create List Produk Terjual', ['create'], ['class' => 'btn btn-success']) ?>
    </p>

    <?= GridView::widget([
        'dataProvider' => $dataProvider,
        'filterModel' => $searchModel,
        'columns' => [
            ['class' => 'yii\grid\SerialColumn'],

            'id_list_produk_terjual',
            'kode_penjualan_list',
            'kode_produk_list_terjual',
            'jumlah_produk_terjual',

            ['class' => 'yii\grid\ActionColumn'],
        ],
    ]); ?>
</div>
