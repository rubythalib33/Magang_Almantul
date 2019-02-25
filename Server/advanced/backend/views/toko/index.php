<?php

use yii\helpers\Html;
use yii\grid\GridView;

/* @var $this yii\web\View */
/* @var $searchModel backend\models\TokoSearch */
/* @var $dataProvider yii\data\ActiveDataProvider */

$this->title = 'Tokos';
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="toko-index">

    <h1><?= Html::encode($this->title) ?></h1>
    <?php // echo $this->render('_search', ['model' => $searchModel]); ?>

    <p>
        <?= Html::a('Create Toko', ['create'], ['class' => 'btn btn-success']) ?>
    </p>

    <?= GridView::widget([
        'dataProvider' => $dataProvider,
        'filterModel' => $searchModel,
        'columns' => [
            ['class' => 'yii\grid\SerialColumn'],

            'kode_toko',
            'kode_perusahaan_toko',
            'manager_toko',
            'alamat_toko:ntext',
            'no_telepon_toko',

            ['class' => 'yii\grid\ActionColumn'],
        ],
    ]); ?>
</div>
