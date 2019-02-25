<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\ListProdukTerjual */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="list-produk-terjual-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'kode_penjualan_list')->textInput() ?>

    <?= $form->field($model, 'kode_produk_list_terjual')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'jumlah_produk_terjual')->textInput() ?>

    <div class="form-group">
        <?= Html::submitButton('Save', ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
