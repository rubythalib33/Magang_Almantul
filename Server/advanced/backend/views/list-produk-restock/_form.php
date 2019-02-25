<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\ListProdukRestock */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="list-produk-restock-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'kode_restock_list')->textInput() ?>

    <?= $form->field($model, 'kode_produk_list_restock')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'jumlah_produk_restock')->textInput() ?>

    <div class="form-group">
        <?= Html::submitButton('Save', ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
