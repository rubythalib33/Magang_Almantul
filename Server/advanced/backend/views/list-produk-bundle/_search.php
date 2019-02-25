<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model backend\models\ListProdukBundleSearch */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="list-produk-bundle-search">

    <?php $form = ActiveForm::begin([
        'action' => ['index'],
        'method' => 'get',
    ]); ?>

    <?= $form->field($model, 'id_list_produk_bundle') ?>

    <?= $form->field($model, 'kode_bundle_list') ?>

    <?= $form->field($model, 'kode_produk_list_bundle') ?>

    <div class="form-group">
        <?= Html::submitButton('Search', ['class' => 'btn btn-primary']) ?>
        <?= Html::resetButton('Reset', ['class' => 'btn btn-default']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
