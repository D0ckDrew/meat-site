import React from 'react';
import { useState } from 'react';
import {Row, Col, Layout, Menu, Avatar} from "antd";

import {
    MenuUnfoldOutlined,
    MenuFoldOutlined,
    UserOutlined,
    VideoCameraOutlined,
    UploadOutlined,
} from '@ant-design/icons';

import '../../styles/LayoutStyles.css';
import {Link} from "react-router-dom";

const { Header, Sider, Content, Footer } = Layout;

const AdminLayout = (props) =>{
    const [collapsed, setCollapsed] = useState(false);
    function toggle(){
        setCollapsed(!collapsed);
    }
    return(
        <Layout>
            <Sider trigger={null} collapsible collapsed={collapsed}>
                <div className="logo" />
                <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
                    <Menu.Item key="1" icon={<UserOutlined />}>
                        nav 1
                    </Menu.Item>
                    <Menu.Item key="2" icon={<VideoCameraOutlined />}>
                        nav 2
                    </Menu.Item>
                    <Menu.Item key="3" icon={<UploadOutlined />}>
                        nav 3
                    </Menu.Item>
                </Menu>
            </Sider>
            <Layout className="site-layout">
                <Header className="header" style={{ padding: 0}}>
                    <Row>
                        <Col span={12}>
                            {collapsed ? <MenuUnfoldOutlined className="trigger" onClick={() => toggle()}/> : <MenuFoldOutlined className="trigger" onClick={() => toggle()}/>}
                        </Col>
                        <Col span={12}>
                            <Link to={'/login'}>
                                <span className="login"><Avatar size={32} icon={<UserOutlined />} /> Войти</span>
                            </Link>
                        </Col>
                    </Row>


                </Header>
                <Content
                    className="site-layout-background"
                    style={{
                        margin: '24px 16px',
                        padding: 24,
                        minHeight: '80vh',
                    }}
                >
                    {props.children}
                </Content>
                <Footer style={{ textAlign: 'center' }}>DD ©2021 Created by DD</Footer>
            </Layout>
        </Layout>
    )
};

export default AdminLayout;
