<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\ProdukDiskon */

$this->title = 'Update Produk Diskon: ' . $model->kode_diskon;
$this->params['breadcrumbs'][] = ['label' => 'Produk Diskons', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->kode_diskon, 'url' => ['view', 'id' => $model->kode_diskon]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="produk-diskon-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
