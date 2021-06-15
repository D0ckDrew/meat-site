import React, { Component } from 'react';
import {Row, Col} from "antd";
import LoginForm from "../components/LoginForm";
import loginService from "../services/LoginService";
import {Redirect} from "react-router-dom";

export default class LoginPage extends Component{

    render () {
        console.log(loginService.user);

        if (loginService.username) {
            window.location.assign('/admin/main-page');
        }
        return (
            <div style={{height: "100vh"}} >
                <Row justify="space-around" align="middle" style={{height: "90vh"}}>
                    <Col sm={12} md={8} lg={6} >
                        <LoginForm/>
                    </Col>
                    </Row>
            </div>
        )
    }
}