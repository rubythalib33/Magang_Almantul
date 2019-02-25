<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\TransaksiPenjualan */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="transaksi-penjualan-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'username_pegawai_penjualan')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'tanggal_transaksi_penjualan')->textInput() ?>

    <div class="form-group">
        <?= Html::submitButton('Save', ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
