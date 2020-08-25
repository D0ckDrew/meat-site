const express = require('express');
const router = express.Router();
const db = require('../db')
const multiConfigDB = require('../config/multiConfigDB');

router.get('/getDeliveryPositions', function(req, res, next) {
    let sql = `SELECT delivery_positions.id AS "key",
    delivery_positions.weight,
    delivery_positions.id_product_positions,
    product_positions.name_ru AS "product_positions_name",
    delivery_positions.id_vendors,
    vendors.name_ru AS "vendors_name",
    delivery_positions.id_entrances,
    entrances.date
    FROM delivery_positions 
    JOIN product_positions ON delivery_positions.id_product_positions=product_positions.id
    JOIN entrances ON delivery_positions.id_entrances=entrances.id
    JOIN vendors ON delivery_positions.id_vendors=vendors.id`;
    db.query(sql, function(err, data, fields){
        if (err) console.log(err);
        res.header("Access-Control-Allow-Origin", multiConfigDB.CLIENT_DOMAIN);
        res.json({
            status: 200,
            data,
            message: 'successfully'
        })
    })
    //res.render('index', { title: 'Express' });
});

module.exports = router;
