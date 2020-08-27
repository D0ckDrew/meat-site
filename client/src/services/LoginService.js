import axios from "axios";
import {message} from 'antd';
import {action, computed, observable, reaction} from "mobx";

class LoginService {
    registerUser(nickname, password){
        //axios.get(`http://localhost:3001/users`)


    }

    loginUser(loginData){
        console.log(JSON.stringify(loginData));
        axios.post("http://localhost:3001/users/login", loginData).then(function (result){
            if (result.data["status"] === 200){
                message.success("Success");
                console.log(result.data["token"]);
            }
            else {
                message.error(result.data["message"]);
            }

        }).catch(function(){message.error("Error")})
    }
}

const loginService = new LoginService();
export default loginService;