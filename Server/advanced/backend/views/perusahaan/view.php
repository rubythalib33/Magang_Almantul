<?php

use yii\helpers\Html;
use yii\widgets\DetailView;

/* @var $this yii\web\View */
/* @var $model backend\models\Perusahaan */

$this->title = $model->kode_perusahaan;
$this->params['breadcrumbs'][] = ['label' => 'Perusahaans', 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
\yii\web\YiiAsset::register($this);
?>
<div class="perusahaan-view">

    <h1><?= Html::encode($this->title) ?></h1>

    <p>
        <?= Html::a('Update', ['update', 'id' => $model->kode_perusahaan], ['class' => 'btn btn-primary']) ?>
        <?= Html::a('Delete', ['delete', 'id' => $model->kode_perusahaan], [
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
            'kode_perusahaan',
            'nama_pemilik_perusahaan',
            'alamat_perusahaan:ntext',
            'tanggal_berdiri_perusahaan',
            'email_perusahaan:email',
            'no_telepon_perusahaan',
        ],
    ]) ?>

</div>
