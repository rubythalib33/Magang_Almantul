<?php

use yii\helpers\Html;
use yii\grid\GridView;

/* @var $this yii\web\View */
/* @var $searchModel backend\models\RestockSearch */
/* @var $dataProvider yii\data\ActiveDataProvider */

$this->title = 'Restocks';
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="restock-index">

    <h1><?= Html::encode($this->title) ?></h1>
    <?php // echo $this->render('_search', ['model' => $searchModel]); ?>

    <p>
        <?= Html::a('Create Restock', ['create'], ['class' => 'btn btn-success']) ?>
    </p>

    <?= GridView::widget([
        'dataProvider' => $dataProvider,
        'filterModel' => $searchModel,
        'columns' => [
            ['class' => 'yii\grid\SerialColumn'],

            'kode_restock',
            'kode_supplier_restock',
            'username_pegawai_restock',
            'tanggal_transaksi_restock',
            'tanggal_jatuh_tempo',
            //'bukti_transaksi_restock',

            ['class' => 'yii\grid\ActionColumn'],
        ],
    ]); ?>
</div>
