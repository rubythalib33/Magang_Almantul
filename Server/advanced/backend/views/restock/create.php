<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\Restock */

$this->title = 'Create Restock';
$this->params['breadcrumbs'][] = ['label' => 'Restocks', 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="restock-create">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
