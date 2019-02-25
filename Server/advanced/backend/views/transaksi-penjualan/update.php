<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\TransaksiPenjualan */

$this->title = 'Update Transaksi Penjualan: ' . $model->kode_penjualan;
$this->params['breadcrumbs'][] = ['label' => 'Transaksi Penjualans', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->kode_penjualan, 'url' => ['view', 'id' => $model->kode_penjualan]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="transaksi-penjualan-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
