<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\ListProdukTerjual */

$this->title = 'Update List Produk Terjual: ' . $model->id_list_produk_terjual;
$this->params['breadcrumbs'][] = ['label' => 'List Produk Terjuals', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->id_list_produk_terjual, 'url' => ['view', 'id' => $model->id_list_produk_terjual]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="list-produk-terjual-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
