const express = require('express');
const router = express.Router();
const db = require('../db')
const multiConfigDB = require("../config/multiConfigDB");
const bodyParser = require("body-parser");
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken')

/* GET users listing. */

/*
router.post('/register', function(req, res, next) {
  req.params.id
  let sql = `SELECT * FROM users`;
  db.query(sql, function(err, data, fields){
    if (err) console.log(err);
    res.json({
      status: 200,
      data,
      message: 'successfully'
    })
  })
});*/

router.use(async (req, res, next) => {
  res.setHeader('Access-Control-Allow-Origin', multiConfigDB.CLIENT_DOMAIN);
  res.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
  res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
  next();
});

router.post('/login' , function(req, res, next) {
  if (!req.body){
    res.sendStatus(400);
  }

  let nickname = req.body.username;
  let password = req.body.password;
  const sql = "SELECT id, nickname, password, id_role FROM users WHERE nickname =?";
  let dataSql = [nickname];

  db.query(sql, dataSql, function(err, data, fields) {
    if (err){
      next(new Error('Ошибка сервера!'));
    }
    else if (!data.length) {
      next(new Error('Введены некорректные данные!'));
    }
    else {
    bcrypt.compare(password, data[0].password).then((result) => {
      if (result === true){
        const userData={
          id: data[0].id,
          nickname: data[0].nickname,
          id_role: data[0].id_role,
        };
        const token = jwt.sign(userData, multiConfigDB.SECRET);
          userData.token = token;
        console.log(token);
        res.json({
          status: 200,
          message: 'access is allowed',
          user: userData
        })}
        else{
          next(new Error('Введены некорректные данные!'));
        }
      })
    }});
}, function(err, req, res, next) {
  res.json({
    status: 501,
    message: err.message
  })
});

router.post('/register' , function(req, res, next) {
  if (!req.body){
    res.sendStatus(400);
  }

  const nickname = req.body.username;
  const password = req.body.password;
  console.log("User: " + nickname);
  console.log("Password: " + password);

  const salt = bcrypt.genSaltSync(10);
  const hash = bcrypt.hashSync(req.body.password, salt);
  console.log("Hash: " + hash);

  res.sendStatus(200);
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
