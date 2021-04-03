const db = require('../../../db')
const Roles = require("../model/roles");

class UserDao {

    getUser(username) {
        const sql = 'SELECT * FROM users WHERE username = ?';
        let dataSql = [username];

        return new Promise((resolve) => {
            db.query(sql, dataSql, function (err, data, fields) {
                resolve(data);
            })
        })
    };

    addUser(user) {
        const sql = 'INSERT users (username, password, name, surname, role) VALUES ?';
        let dataSql = [
            [
                user.username,
                user.password,
                user.name,
                user.surname,
                user.role ? user.role : Roles.ROLE_GUEST
            ]];

        db.query(sql, [dataSql], function (err, data, fields) {
            return data;
        })
    };
}

module.exports = new UserDao();