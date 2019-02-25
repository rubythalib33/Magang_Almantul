<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\Toko */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="toko-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'kode_perusahaan_toko')->textInput() ?>

    <?= $form->field($model, 'manager_toko')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'alamat_toko')->textarea(['rows' => 6]) ?>

    <?= $form->field($model, 'no_telepon_toko')->textInput(['maxlength' => true]) ?>

    <div class="form-group">
        <?= Html::submitButton('Save', ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
