<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\Pemasukan */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="pemasukan-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'kode_toko_pemasukan')->textInput() ?>

    <?= $form->field($model, 'kode_pemasukan')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'tanggal_pemasukan')->textInput() ?>

    <?= $form->field($model, 'jumlah_pemasukan')->textInput() ?>

    <div class="form-group">
        <?= Html::submitButton('Save', ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
