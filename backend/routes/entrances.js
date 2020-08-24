const express = require('express');
const router = express.Router();
const db = require('../db')
const multiConfigDB = require('../config/multiConfigDB');

router.get('/getDeliveryPositions', function(req, res, next) {
    let sql = `SELECT * FROM delivery_positions`;
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
