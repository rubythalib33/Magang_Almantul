<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\PerusahaanSearch */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="perusahaan-search">

    <?php $form = ActiveForm::begin([
        'action' => ['index'],
        'method' => 'get',
    ]); ?>

    <?= $form->field($model, 'kode_perusahaan') ?>

    <?= $form->field($model, 'nama_pemilik_perusahaan') ?>

    <?= $form->field($model, 'alamat_perusahaan') ?>

    <?= $form->field($model, 'tanggal_berdiri_perusahaan') ?>

    <?= $form->field($model, 'email_perusahaan') ?>

    <?php // echo $form->field($model, 'no_telepon_perusahaan') ?>

    <div class="form-group">
        <?= Html::submitButton('Search', ['class' => 'btn btn-primary']) ?>
        <?= Html::resetButton('Reset', ['class' => 'btn btn-default']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
