<?php

use yii\helpers\Html;
use yii\grid\GridView;

/* @var $this yii\web\View */
/* @var $searchModel backend\models\ListProdukBundleSearch */
/* @var $dataProvider yii\data\ActiveDataProvider */

$this->title = 'List Produk Bundles';
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="list-produk-bundle-index">

    <h1><?= Html::encode($this->title) ?></h1>
    <?php // echo $this->render('_search', ['model' => $searchModel]); ?>

    <p>
        <?= Html::a('Create List Produk Bundle', ['create'], ['class' => 'btn btn-success']) ?>
    </p>

    <?= GridView::widget([
        'dataProvider' => $dataProvider,
        'filterModel' => $searchModel,
        'columns' => [
            ['class' => 'yii\grid\SerialColumn'],

            'id_list_produk_bundle',
            'kode_bundle_list',
            'kode_produk_list_bundle',

            ['class' => 'yii\grid\ActionColumn'],
        ],
    ]); ?>
</div>
