<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\ProdukDiskon */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="produk-diskon-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'kode_produk_diskon')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'besar_diskon(%)')->textInput() ?>

    <?= $form->field($model, 'tanggal_mulai_berlaku_diskon')->textInput() ?>

    <?= $form->field($model, 'tanggal_berakhir_diskon')->textInput() ?>

    <div class="form-group">
        <?= Html::submitButton('Save', ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
