<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\ListProdukRestock */

$this->title = 'Create List Produk Restock';
$this->params['breadcrumbs'][] = ['label' => 'List Produk Restocks', 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="list-produk-restock-create">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
