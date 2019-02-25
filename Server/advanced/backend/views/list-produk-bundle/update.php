<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\ListProdukBundle */

$this->title = 'Update List Produk Bundle: ' . $model->id_list_produk_bundle;
$this->params['breadcrumbs'][] = ['label' => 'List Produk Bundles', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->id_list_produk_bundle, 'url' => ['view', 'id' => $model->id_list_produk_bundle]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="list-produk-bundle-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
