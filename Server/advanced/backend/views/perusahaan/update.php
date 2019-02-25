<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\Perusahaan */

$this->title = 'Update Perusahaan: ' . $model->kode_perusahaan;
$this->params['breadcrumbs'][] = ['label' => 'Perusahaans', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->kode_perusahaan, 'url' => ['view', 'id' => $model->kode_perusahaan]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="perusahaan-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
