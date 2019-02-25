<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\Produk */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="produk-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'kode_produk')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'jenis_produk')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'kategori_produk')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'nama_produk')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'deskripsi_produk')->textarea(['rows' => 6]) ?>

    <?= $form->field($model, 'harga_jual_produk')->textInput() ?>

    <?= $form->field($model, 'harga_beli_produk')->textInput() ?>

    <?= $form->field($model, 'satuan_produk')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'gambar_produk')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'stok_produk')->textInput() ?>

    <?= $form->field($model, 'stok_kritis_produk')->textInput() ?>

    <?= $form->field($model, 'status_produk')->textInput(['maxlength' => true]) ?>

    <div class="form-group">
        <?= Html::submitButton('Save', ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
