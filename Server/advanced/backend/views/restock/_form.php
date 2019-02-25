<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\Restock */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="restock-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'kode_supplier_restock')->textInput() ?>

    <?= $form->field($model, 'username_pegawai_restock')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'tanggal_transaksi_restock')->textInput() ?>

    <?= $form->field($model, 'tanggal_jatuh_tempo')->textInput() ?>

    <?= $form->field($model, 'bukti_transaksi_restock')->textInput(['maxlength' => true]) ?>

    <div class="form-group">
        <?= Html::submitButton('Save', ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
