import axios from "axios";
import {message} from 'antd';
import {action, computed, observable, reaction} from "mobx";
import {decorate} from "mobx/lib/mobx";
import API from "../utils/API.js"

class LoginService {
    username = "";

    constructor() {
        this.username = window.localStorage.getItem("username");

        reaction(() => this.username,
            (username) => {
                console.log(username);
                this.username = username;
                window.localStorage.setItem("username", this.username);
            })
        //if (!this.user)
    }

    registerUser(nickname, password) {
        //axios.get(`http://localhost:3001/users`)
    }

    logOut() {
        window.localStorage.removeItem("username");
        window.location.assign('/login');
    }

    loginUser(loginData) {
        const params = new URLSearchParams(loginData);
        API.post("/auth/login", null,{params})
            .then(function (result) {
            if (result.status === 200) {
                if (result.data.loginStatus.code === 0) {
                    loginService.username = loginData.username;
                    window.localStorage.setItem("username", loginData.username);
                    window.localStorage.setItem("token", loginData.token);
                    message.success(result.data.loginStatus.message);
                    window.location.assign('/admin/main-page');
                } else {
                    message.error(result.data.loginStatus.message);
                }

            } else {
                message.error("Error");
            }

        }).catch(function () {
            message.error("Error");
        })
    }
}

decorate(LoginService, {
    user: observable,
    loginUser: action
});

const loginService = new LoginService();
export default loginService;