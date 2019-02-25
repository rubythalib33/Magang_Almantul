<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\ListProdukBundle */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="list-produk-bundle-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'kode_bundle_list')->textInput() ?>

    <?= $form->field($model, 'kode_produk_list_bundle')->textInput(['maxlength' => true]) ?>

    <div class="form-group">
        <?= Html::submitButton('Save', ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
