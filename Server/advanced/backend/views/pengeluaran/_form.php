<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\Pengeluaran */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="pengeluaran-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'kode_toko_pengeluaran')->textInput() ?>

    <?= $form->field($model, 'kode_pengeluaran')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'tanggal_pengeluaran')->textInput() ?>

    <?= $form->field($model, 'jumlah_pengeluaran')->textInput() ?>

    <div class="form-group">
        <?= Html::submitButton('Save', ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
