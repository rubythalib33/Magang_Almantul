<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\Admin */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="admin-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'username_admin')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'kode_perusahaan_admin')->textInput() ?>

    <?= $form->field($model, 'password_admin')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'nama_lengkap_admin')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'no_telepon_admin')->textInput(['maxlength' => true]) ?>

    <div class="form-group">
        <?= Html::submitButton('Save', ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
