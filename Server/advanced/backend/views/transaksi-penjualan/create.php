<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\TransaksiPenjualan */

$this->title = 'Create Transaksi Penjualan';
$this->params['breadcrumbs'][] = ['label' => 'Transaksi Penjualans', 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="transaksi-penjualan-create">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
