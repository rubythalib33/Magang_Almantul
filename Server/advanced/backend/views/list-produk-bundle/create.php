<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\ListProdukBundle */

$this->title = 'Create List Produk Bundle';
$this->params['breadcrumbs'][] = ['label' => 'List Produk Bundles', 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="list-produk-bundle-create">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
