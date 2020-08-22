const express = require('express');
const router = express.Router();
const db = require('../db')

router.get('/', function(req, res, next) {
    let sql = `SELECT * FROM users`;
    db.query(sql, function(err, data, fields){
        if (err) throw err;
        res.json({
            status: 200,
            data,
            message: 'successfully'
        })
    })
    res.render('index', { title: 'Express' });
});
