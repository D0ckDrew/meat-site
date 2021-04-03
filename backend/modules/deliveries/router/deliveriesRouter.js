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

    const data = deliveriesService.getReceiptMaterial();
    res.json({
        status: 200,
        user: data
    })
});

router.post('/addDelivery', async function (req, res, next) {
    if (!req.body) {
        res.sendStatus(400);
    }

    const statusCode = await deliveriesService.addDelivery();

    if (statusCode != AddStatus.OK) {
        next(new Error(statusCode));
    } else {
        res.json({
            status: 200,
            user: data
        })
    }

}, function (err, req, res, next) {
    res.json({
        status: 501,
        message: err.message
    })
});

router.post('/addDelivery', async function (req, res, next) {
    if (!req.body) {
        res.sendStatus(400);
    }

    const statusCode = await deliveriesService.addDelivery();

    if (statusCode != AddStatus.OK) {
        next(new Error(statusCode));
    } else {
        res.json({
            status: 200,
            user: data
        })
    }

}, function (err, req, res, next) {
    res.json({
        status: 501,
        message: err.message
    })
});

/*
router.get('/', function(req, res, next) {
  let sql = `SELECT * FROM users`;
  db.query(sql, function(err, data, fields){
    if (err) console.log(err);
    res.json({
      status: 200,
      data,
      message: 'successfully'
    })
  })
});
 */

module.exports = router;