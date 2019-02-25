<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\Toko */

$this->title = 'Update Toko: ' . $model->kode_toko;
$this->params['breadcrumbs'][] = ['label' => 'Tokos', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->kode_toko, 'url' => ['view', 'id' => $model->kode_toko]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="toko-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
