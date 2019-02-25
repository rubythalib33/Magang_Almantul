<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\Perusahaan */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="perusahaan-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'nama_pemilik_perusahaan')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'alamat_perusahaan')->textarea(['rows' => 6]) ?>

    <?= $form->field($model, 'tanggal_berdiri_perusahaan')->textInput() ?>

    <?= $form->field($model, 'email_perusahaan')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'no_telepon_perusahaan')->textInput(['maxlength' => true]) ?>

    <div class="form-group">
        <?= Html::submitButton('Save', ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
