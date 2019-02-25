<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\ProdukDiskon */

$this->title = 'Create Produk Diskon';
$this->params['breadcrumbs'][] = ['label' => 'Produk Diskons', 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="produk-diskon-create">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
