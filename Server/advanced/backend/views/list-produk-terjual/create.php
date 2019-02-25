<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\ListProdukTerjual */

$this->title = 'Create List Produk Terjual';
$this->params['breadcrumbs'][] = ['label' => 'List Produk Terjuals', 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="list-produk-terjual-create">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
