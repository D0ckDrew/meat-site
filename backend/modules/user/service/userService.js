const userDao = require("../dao/userDao");
const LoginStatus = require("../model/loginStatus");
const multiConfigDB = require("../../../config/multiConfigDB");
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken')

class UserService {
    async login(username, password) {
        let data = await userDao.getUser(username);

        let userData = {status: LoginStatus.INVALID_DATA};

        return new Promise((resolve) => {
            if (data && data.length){
                bcrypt.compare(password, data[0].password).then((result) => {
                    if (result === true) {
                        userData = {
                            id: data[0].id,
                            nickname: data[0].username,
                            role: data[0].role,
                            status: LoginStatus.OK
                        };
                        userData.token = jwt.sign(userData, multiConfigDB.SECRET);
                        resolve(userData);
                    } else {
                        resolve(userData);
                    }
                })
            } else {
                resolve(userData);
            }
        })
    }

    registration(user) {
        const salt = bcrypt.genSaltSync(10);
        user.password = bcrypt.hashSync(user.password, salt);

        userDao.addUser(user);
    }
}

module.exports = new UserService();
