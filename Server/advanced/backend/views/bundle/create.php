<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\Bundle */

$this->title = 'Create Bundle';
$this->params['breadcrumbs'][] = ['label' => 'Bundles', 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="bundle-create">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
