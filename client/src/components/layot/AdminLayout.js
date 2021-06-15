import React from 'react';
import {useState} from 'react';
import {Row, Col, Layout, Menu, Avatar, Button, Dropdown, Image} from "antd";

import {
    MenuUnfoldOutlined,
    MenuFoldOutlined,
    UserOutlined,
    LineChartOutlined,
    ShopOutlined,
    ScheduleOutlined,
    TableOutlined
} from '@ant-design/icons';

import '../../styles/LayoutStyles.css';
import loginService from "../../services/LoginService";

const {Header, Sider, Content, Footer} = Layout;

const AdminLayout = (props) => {
        const [collapsed, setCollapsed] = useState(false);

        const userMenu = (
            <Menu>
                <Menu.Item danger>
                    <Button type="link" onClick={() => loginService.logOut()}>
                        Выйти
                    </Button>
                </Menu.Item>
            </Menu>
        );

        function toggle() {
            setCollapsed(!collapsed);
        }

        function getUsername() {
            if (loginService.username) {
                return loginService.username;
            } else {
                return "default_user"
            }
        }

        function selectedMenuKey() {
            const href = window.location.href;
            if (href.indexOf("/admin/main-page") !== -1) {
                return '1';
            } else if (href.indexOf("/admin/delivery-page") !== -1) {
                return '2';
            } else if (href.indexOf("/admin/sale-page") !== -1) {
                return '3';
            } else if (href.indexOf("/admin/analytic-page") !== -1) {
                return '4';
            } else {
                return '1';
            }
        }

        return (
            <Layout style={{minHeight: '100vh'}}>
                <Sider trigger={null} collapsible collapsed={collapsed}>
                    <div className="logo"><Image
                        height={'100%'}
                        style={{objectFit: 'cover'}}
                        src="http://localhost:3000/logo-meat.jpg"
                    /></div>
                    <Menu theme="dark" mode="inline" defaultSelectedKeys={[selectedMenuKey()]}>
                        <Menu.Item key="1" icon={<TableOutlined/>}>
                            <a href="/admin/main-page">
                                Главная
                            </a>
                        </Menu.Item>
                        <Menu.Item key="2" icon={<ScheduleOutlined/>}>
                            <a href="/admin/delivery-page">
                                Поставки
                            </a>
                        </Menu.Item>
                        <Menu.Item key="3" icon={<ShopOutlined/>}>
                            <a href="/admin/sale-page">
                                Продажи
                            </a>
                        </Menu.Item>
                        <Menu.Item key="4" icon={<LineChartOutlined/>}>
                            <a href="/admin/analytic-page">
                                Аналитика
                            </a>
                        </Menu.Item>
                    </Menu>
                </Sider>
                <Layout className="site-layout">
                    <Header className="header" style={{padding: 0, color: "#fff"}}>
                        <Row>
                            <Col span={12}>
                                {collapsed ? <MenuUnfoldOutlined className="trigger" onClick={() => toggle()}/> :
                                    <MenuFoldOutlined className="trigger" onClick={() => toggle()}/>}
                            </Col>
                            <Col span={12}>
                                <Button type="link" style={{float: 'right'}}>
                                    <Dropdown overlay={userMenu} trigger={['click']}>
                                        <strong className="login">
                                            {getUsername()}
                                            &nbsp;<Avatar size={32}
                                                          icon={<UserOutlined/>}/></strong>
                                    </Dropdown>
                                </Button>
                            </Col>
                        </Row>


                    </Header>
                    <Content
                        className="site-layout-background"
                        style={{
                            margin: '24px 16px',
                            padding: 24
                        }}
                    >
                        {props.children}
                    </Content>
                    <Footer style={{textAlign: 'center'}}>Copyright ©2020-2021 | Created by Красномясов А. А. 17ВИ1</Footer>
                </Layout>
            </Layout>
        )
    }
;

export default AdminLayout;
