<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\RestockSearch */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="restock-search">

    <?php $form = ActiveForm::begin([
        'action' => ['index'],
        'method' => 'get',
    ]); ?>

    <?= $form->field($model, 'kode_restock') ?>

    <?= $form->field($model, 'kode_supplier_restock') ?>

    <?= $form->field($model, 'username_pegawai_restock') ?>

    <?= $form->field($model, 'tanggal_transaksi_restock') ?>

    <?= $form->field($model, 'tanggal_jatuh_tempo') ?>

    <?php // echo $form->field($model, 'bukti_transaksi_restock') ?>

    <div class="form-group">
        <?= Html::submitButton('Search', ['class' => 'btn btn-primary']) ?>
        <?= Html::resetButton('Reset', ['class' => 'btn btn-default']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
