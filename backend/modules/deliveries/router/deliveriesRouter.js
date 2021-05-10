const express = require('express');
const router = express.Router();
const multiConfigDB = require("../../../config/multiConfigDB");

const deliveriesService = require("../service/deliveriesService");
const AddStatus = require("../model/addStatus");


router.use(async (req, res, next) => {
    res.setHeader('Access-Control-Allow-Origin', multiConfigDB.CLIENT_DOMAIN);
    res.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
    res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
    next();
});

router.get('/getReceiptMaterial', async function (req, res, next) {
    if (!req.body) {
        res.sendStatus(400);
    }

    const receiptId = req.body.receiptId;

    const data = await deliveriesService.getReceiptMaterial(receiptId);
    res.json({
        status: 200,
        data: data
    })
});

router.get('/getDeliveryMaterials', async function (req, res, next) {
    if (!req.body) {
        res.sendStatus(400);
    }

    const deliveryId = req.body.deliveryId;

    const data = await deliveriesService.getDeliveryMaterials(deliveryId);
    res.json({
        status: 200,
        data: data
    })
});


router.post('/addDelivery', async function (req, res, next) {
    if (!req.body) {
        res.sendStatus(400);
    }

    const delivery = {
        date: req.body.date,
        note: req.body.note,
        suppliersId: req.body.suppliersId,
        userId: req.body.userId
    }

    const data = await deliveriesService.addDelivery(delivery);

    if (data.status !== AddStatus.OK) {
        next(new Error(data));
    } else {
        res.json({
            status: 200,
            data: data
        })
    }

}, function (err, req, res, next) {
    res.json({
        status: 501,
        message: data
    })
});

router.post('/addReceipts', async function (req, res, next) {
    if (!req.body) {
        res.sendStatus(400);
    }

    const receipt = {
        deliveryId: req.body.deliveryId,
        quantity : req.body.quantity,
        quantityRemains: req.body.quantityRemains,
        date: req.body.date,
        materialsId: req.body.materialsId,
        receiptsReasonId: req.body.receiptsReasonId,
        userId: req.body.userId
    }

    const data = await deliveriesService.addReceipts(receipt);

    if (data.status !== AddStatus.OK) {
        next(new Error(data));
    } else {
        res.json({
            status: 200,
            user: data
        })
    }

}, function (err, req, res, next) {
    res.json({
        status: 501,
        message: data
    })
});

module.exports = router;