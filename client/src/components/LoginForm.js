import React from 'react';
import { Form, Input, Button, Checkbox } from 'antd';
import { UserOutlined, LockOutlined } from '@ant-design/icons';
import loginService from "../services/LoginService";

const layout = {
    labelCol: {
        span: 8,
    },
    wrapperCol: {
        span: 16,
    },
};
const tailLayout = {
    wrapperCol: {
        offset: 8,
        span: 16,
    },
};

const LoginForm = () => {

    const onFinish = values => {
        loginService.loginUser(values);
        console.log('Success:', values);
    };

    const onFinishFailed = errorInfo => {
        console.log('Failed:', errorInfo);
    };

    return (
        <Form
            name="normal_login"
            className="login-form"
            initialValues={{ remember: true }}
            onFinish={onFinish}
        >
            <h2 style={{textAlign: "center"}}>Вход</h2><br/>
            <Form.Item
                name="username"
                rules={[{ required: true, message: 'Пожалуйста, введите свой никнейм!' }]}
            >
                <Input prefix={<UserOutlined className="site-form-item-icon" />} placeholder="Никнейм" />
            </Form.Item>
            <Form.Item
                name="password"
                rules={[{ required: true, message: 'Пожалуйста, введите свой пароль!' }]}
            >
                <Input
                    prefix={<LockOutlined className="site-form-item-icon" />}
                    type="password"
                    placeholder="Пароль"
                />
            </Form.Item>
            <Form.Item>
                <Form.Item name="remember" valuePropName="checked" noStyle>
                    <Checkbox>Запомнить меня</Checkbox>
                </Form.Item>
            </Form.Item>

            <Form.Item style={{textAlign: "center"}}>
                <Button style={{width: "90%"}} type="primary" htmlType="submit" className="login-form-button">
                    Войти
                </Button>
            </Form.Item>
        </Form>

    );
};

export default LoginForm;
