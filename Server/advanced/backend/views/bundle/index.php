<?php

use yii\helpers\Html;
use yii\grid\GridView;

/* @var $this yii\web\View */
/* @var $searchModel backend\models\BundleSearch */
/* @var $dataProvider yii\data\ActiveDataProvider */

$this->title = 'Bundles';
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="bundle-index">

    <h1><?= Html::encode($this->title) ?></h1>
    <?php // echo $this->render('_search', ['model' => $searchModel]); ?>

    <p>
        <?= Html::a('Create Bundle', ['create'], ['class' => 'btn btn-success']) ?>
    </p>

    <?= GridView::widget([
        'dataProvider' => $dataProvider,
        'filterModel' => $searchModel,
        'columns' => [
            ['class' => 'yii\grid\SerialColumn'],

            'kode_bundle',
            'nama_bundle',
            'harga_bundle',
            'tanggal_mulai_berlaku_bundle',
            'tanggal_berakhir_bundle',

            ['class' => 'yii\grid\ActionColumn'],
        ],
    ]); ?>
</div>
