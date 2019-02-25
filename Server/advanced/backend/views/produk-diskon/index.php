<?php

use yii\helpers\Html;
use yii\grid\GridView;

/* @var $this yii\web\View */
/* @var $searchModel backend\models\ProdukDiskonSearch */
/* @var $dataProvider yii\data\ActiveDataProvider */

$this->title = 'Produk Diskons';
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="produk-diskon-index">

    <h1><?= Html::encode($this->title) ?></h1>
    <?php // echo $this->render('_search', ['model' => $searchModel]); ?>

    <p>
        <?= Html::a('Create Produk Diskon', ['create'], ['class' => 'btn btn-success']) ?>
    </p>

    <?= GridView::widget([
        'dataProvider' => $dataProvider,
        'filterModel' => $searchModel,
        'columns' => [
            ['class' => 'yii\grid\SerialColumn'],

            'kode_diskon',
            'kode_produk_diskon',
            'besar_diskon(%)',
            'tanggal_mulai_berlaku_diskon',
            'tanggal_berakhir_diskon',

            ['class' => 'yii\grid\ActionColumn'],
        ],
    ]); ?>
</div>
