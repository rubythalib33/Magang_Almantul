<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\Pegawai */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="pegawai-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'username_pegawai')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'kode_toko_pegawai')->textInput() ?>

    <?= $form->field($model, 'password_pegawai')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'jabatan_pegawai')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'nama_lengkap_pegawai')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'no_telepon_pegawai')->textInput(['maxlength' => true]) ?>

    <div class="form-group">
        <?= Html::submitButton('Save', ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
