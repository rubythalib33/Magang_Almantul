<?php

use yii\helpers\Html;
use yii\widgets\DetailView;

/* @var $this yii\web\View */
/* @var $model backend\models\ListProdukTerjual */

$this->title = $model->id_list_produk_terjual;
$this->params['breadcrumbs'][] = ['label' => 'List Produk Terjuals', 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
\yii\web\YiiAsset::register($this);
?>
<div class="list-produk-terjual-view">

    <h1><?= Html::encode($this->title) ?></h1>

    <p>
        <?= Html::a('Update', ['update', 'id' => $model->id_list_produk_terjual], ['class' => 'btn btn-primary']) ?>
        <?= Html::a('Delete', ['delete', 'id' => $model->id_list_produk_terjual], [
            'class' => 'btn btn-danger',
            'data' => [
                'confirm' => 'Are you sure you want to delete this item?',
                'method' => 'post',
            ],
        ]) ?>
    </p>

    <?= DetailView::widget([
        'model' => $model,
        'attributes' => [
            'id_list_produk_terjual',
            'kode_penjualan_list',
            'kode_produk_list_terjual',
            'jumlah_produk_terjual',
        ],
    ]) ?>

</div>
