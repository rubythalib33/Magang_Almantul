<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\Pemasukan */

$this->title = 'Update Pemasukan: ' . $model->kode_data_pemasukan;
$this->params['breadcrumbs'][] = ['label' => 'Pemasukans', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->kode_data_pemasukan, 'url' => ['view', 'id' => $model->kode_data_pemasukan]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="pemasukan-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
