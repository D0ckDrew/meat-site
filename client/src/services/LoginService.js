import axios from "axios";
import {message} from 'antd';
import {action, computed, observable, reaction} from "mobx";
import {decorate} from "mobx/lib/mobx";
import API from "../utils/API.js"

class LoginService {
    user = {};

    constructor() {
        this.user = window.localStorage.getItem("user");

        reaction(() => this.user,
            (user) => {
                console.log("ленина свалили");
                console.log(this.user);
                this.user = user;
                console.log(this.user);
                window.localStorage.setItem("user", this.user);
            })
        //if (!this.user)
    }

    registerUser(nickname, password) {
        //axios.get(`http://localhost:3001/users`)
    }

    loginUser(loginData) {
        API.post("/users/login", loginData).then(function (result) {
            if (result.data["status"] === 200) {
                loginService.user = result.data["user"];
                message.success("Success");
            } else {
                message.error(result.data["message"]);
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