const express = require('express');
const router = express.Router();
const multiConfigDB = require("../../../config/multiConfigDB");

const userService = require("../service/userService");
const LoginStatus = require("../model/loginStatus");

router.use(async (req, res, next) => {
    res.setHeader('Access-Control-Allow-Origin', multiConfigDB.CLIENT_DOMAIN);
    res.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
    res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
    next();
});

router.post('/login', async function (req, res, next) {
    if (!req.body) {
        res.sendStatus(400);
    }

    let username = req.body.username;
    let password = req.body.password;

    const userData = await userService.login(username, password);
    if (userData.status === LoginStatus.INVALID_DATA){
        next(new Error('Введены некорректные данные!'));
    } else {
        console.log(userData);
        res.json({
            status: 200,
            message: 'access is allowed',
            user: userData
        })
    }
}, function (err, req, res, next) {
    res.json({
        status: 501,
        message: err.message
    })
});

router.post('/registration', function (req, res, next) {
    if (!req.body) {
        res.sendStatus(400);
    }

    const user = {
        username: req.body.username,
        password: req.body.password,
        name: req.body.name,
        surname: req.body.surname,
    }

    userService.registration(user);
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