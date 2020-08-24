import React, { Component } from 'react';
import Header from "../components/Header";
import LoginForm from "../components/LoginForm";
import {Row, Col} from "antd";

export default class LoginPage extends Component{
    render () {
        return (
            <div>
                <Header disableLogin/>
                <Row justify="center" align="middle" style={{margin:'10px'}}>
                    <Col span={16} style={{backgroundColor:'#E5F0FF', padding:'8px'}}>
                        <LoginForm/>
                    </Col>
                </Row>
            </div>
        )
    }
}