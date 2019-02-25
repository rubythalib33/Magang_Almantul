<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\Restock */

$this->title = 'Update Restock: ' . $model->kode_restock;
$this->params['breadcrumbs'][] = ['label' => 'Restocks', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->kode_restock, 'url' => ['view', 'id' => $model->kode_restock]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="restock-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
