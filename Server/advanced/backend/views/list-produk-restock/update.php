<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\ListProdukRestock */

$this->title = 'Update List Produk Restock: ' . $model->id_list_produk_restock;
$this->params['breadcrumbs'][] = ['label' => 'List Produk Restocks', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->id_list_produk_restock, 'url' => ['view', 'id' => $model->id_list_produk_restock]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="list-produk-restock-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
