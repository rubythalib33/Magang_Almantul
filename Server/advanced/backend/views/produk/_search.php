<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\ProdukSearch */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="produk-search">

    <?php $form = ActiveForm::begin([
        'action' => ['index'],
        'method' => 'get',
    ]); ?>

    <?= $form->field($model, 'kode_produk') ?>

    <?= $form->field($model, 'jenis_produk') ?>

    <?= $form->field($model, 'kategori_produk') ?>

    <?= $form->field($model, 'nama_produk') ?>

    <?= $form->field($model, 'deskripsi_produk') ?>

    <?php // echo $form->field($model, 'harga_jual_produk') ?>

    <?php // echo $form->field($model, 'harga_beli_produk') ?>

    <?php // echo $form->field($model, 'satuan_produk') ?>

    <?php // echo $form->field($model, 'gambar_produk') ?>

    <?php // echo $form->field($model, 'stok_produk') ?>

    <?php // echo $form->field($model, 'stok_kritis_produk') ?>

    <?php // echo $form->field($model, 'status_produk') ?>

    <div class="form-group">
        <?= Html::submitButton('Search', ['class' => 'btn btn-primary']) ?>
        <?= Html::resetButton('Reset', ['class' => 'btn btn-default']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
