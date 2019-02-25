<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\TransaksiPenjualanSearch */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="transaksi-penjualan-search">

    <?php $form = ActiveForm::begin([
        'action' => ['index'],
        'method' => 'get',
    ]); ?>

    <?= $form->field($model, 'kode_penjualan') ?>

    <?= $form->field($model, 'username_pegawai_penjualan') ?>

    <?= $form->field($model, 'tanggal_transaksi_penjualan') ?>

    <div class="form-group">
        <?= Html::submitButton('Search', ['class' => 'btn btn-primary']) ?>
        <?= Html::resetButton('Reset', ['class' => 'btn btn-default']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
