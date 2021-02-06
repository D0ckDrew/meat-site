import React, { Component } from 'react';
import {Row, Col} from "antd";
import LoginForm from "../components/LoginForm";

export default class LoginPage extends Component{
    render () {
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