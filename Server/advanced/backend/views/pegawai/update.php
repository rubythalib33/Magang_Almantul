<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\Pegawai */

$this->title = 'Update Pegawai: ' . $model->username_pegawai;
$this->params['breadcrumbs'][] = ['label' => 'Pegawais', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->username_pegawai, 'url' => ['view', 'id' => $model->username_pegawai]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="pegawai-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
