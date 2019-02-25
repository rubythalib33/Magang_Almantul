<?php

use yii\helpers\Html;
use yii\grid\GridView;

/* @var $this yii\web\View */
/* @var $searchModel backend\models\TransaksiPenjualanSearch */
/* @var $dataProvider yii\data\ActiveDataProvider */

$this->title = 'Transaksi Penjualans';
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="transaksi-penjualan-index">

    <h1><?= Html::encode($this->title) ?></h1>
    <?php // echo $this->render('_search', ['model' => $searchModel]); ?>

    <p>
        <?= Html::a('Create Transaksi Penjualan', ['create'], ['class' => 'btn btn-success']) ?>
    </p>

    <?= GridView::widget([
        'dataProvider' => $dataProvider,
        'filterModel' => $searchModel,
        'columns' => [
            ['class' => 'yii\grid\SerialColumn'],

            'kode_penjualan',
            'username_pegawai_penjualan',
            'tanggal_transaksi_penjualan',

            ['class' => 'yii\grid\ActionColumn'],
        ],
    ]); ?>
</div>
