<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\Bundle */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="bundle-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'nama_bundle')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'harga_bundle')->textInput() ?>

    <?= $form->field($model, 'tanggal_mulai_berlaku_bundle')->textInput() ?>

    <?= $form->field($model, 'tanggal_berakhir_bundle')->textInput() ?>

    <div class="form-group">
        <?= Html::submitButton('Save', ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
