<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\BundleSearch */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="bundle-search">

    <?php $form = ActiveForm::begin([
        'action' => ['index'],
        'method' => 'get',
    ]); ?>

    <?= $form->field($model, 'kode_bundle') ?>

    <?= $form->field($model, 'nama_bundle') ?>

    <?= $form->field($model, 'harga_bundle') ?>

    <?= $form->field($model, 'tanggal_mulai_berlaku_bundle') ?>

    <?= $form->field($model, 'tanggal_berakhir_bundle') ?>

    <div class="form-group">
        <?= Html::submitButton('Search', ['class' => 'btn btn-primary']) ?>
        <?= Html::resetButton('Reset', ['class' => 'btn btn-default']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
