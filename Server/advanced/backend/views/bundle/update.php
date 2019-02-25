<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\Bundle */

$this->title = 'Update Bundle: ' . $model->kode_bundle;
$this->params['breadcrumbs'][] = ['label' => 'Bundles', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->kode_bundle, 'url' => ['view', 'id' => $model->kode_bundle]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="bundle-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
