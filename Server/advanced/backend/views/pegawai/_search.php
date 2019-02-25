<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\PegawaiSearch */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="pegawai-search">

    <?php $form = ActiveForm::begin([
        'action' => ['index'],
        'method' => 'get',
    ]); ?>

    <?= $form->field($model, 'username_pegawai') ?>

    <?= $form->field($model, 'kode_toko_pegawai') ?>

    <?= $form->field($model, 'password_pegawai') ?>

    <?= $form->field($model, 'jabatan_pegawai') ?>

    <?= $form->field($model, 'nama_lengkap_pegawai') ?>

    <?php // echo $form->field($model, 'no_telepon_pegawai') ?>

    <div class="form-group">
        <?= Html::submitButton('Search', ['class' => 'btn btn-primary']) ?>
        <?= Html::resetButton('Reset', ['class' => 'btn btn-default']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
