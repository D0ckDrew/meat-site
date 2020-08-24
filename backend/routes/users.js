const express = require('express');
const router = express.Router();
const db = require('../db')

/* GET users listing. */


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
  //res.render('index', { title: 'Express' });

  // res.json([{
  //   id: 1,
  //   username: "samsepi0l"
  // }, {
  //   id: 2,
  //   username: "D0loresH4ze"
  // }]);
});

module.exports = router;
