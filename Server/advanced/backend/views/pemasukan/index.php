<?php

use yii\helpers\Html;
use yii\grid\GridView;

/* @var $this yii\web\View */
/* @var $searchModel backend\models\PemasukanSearch */
/* @var $dataProvider yii\data\ActiveDataProvider */

$this->title = 'Pemasukans';
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="pemasukan-index">

    <h1><?= Html::encode($this->title) ?></h1>
    <?php // echo $this->render('_search', ['model' => $searchModel]); ?>

    <p>
        <?= Html::a('Create Pemasukan', ['create'], ['class' => 'btn btn-success']) ?>
    </p>

    <?= GridView::widget([
        'dataProvider' => $dataProvider,
        'filterModel' => $searchModel,
        'columns' => [
            ['class' => 'yii\grid\SerialColumn'],

            'kode_data_pemasukan',
            'kode_toko_pemasukan',
            'kode_pemasukan',
            'tanggal_pemasukan',
            'jumlah_pemasukan',

            ['class' => 'yii\grid\ActionColumn'],
        ],
    ]); ?>
</div>
