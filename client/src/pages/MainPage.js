import React, { Component } from 'react';
import AdminLayout from "../components/layot/AdminLayout";
import {Button, Col, Row} from "antd";
import LoginForm from "../components/LoginForm";


export default class MainPage extends Component{
    render () {
        return (
            <div>
                <div style={{height: "100vh"}} >
                    <Row justify="space-around" align="middle" style={{height: "90vh"}}>
                        <Button href="/login" type="primary" shape="round" size='large' style={{minWidth: '200px'}}>
                            Войти
                        </Button>
                    </Row>
                </div>
            </div>
        )
    }
}