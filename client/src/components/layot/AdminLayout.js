import React from 'react';
import {useState} from 'react';
import {Row, Col, Layout, Menu, Avatar} from "antd";

import {
    MenuUnfoldOutlined,
    MenuFoldOutlined,
    UserOutlined,
    VideoCameraOutlined,
    UploadOutlined,
    LineChartOutlined,
    ShopOutlined,
    ReconciliationOutlined,
    ScheduleOutlined,
    ReloadOutlined,
    TableOutlined, KeyOutlined
} from '@ant-design/icons';

import '../../styles/LayoutStyles.css';
import {Link} from "react-router-dom";

const {Header, Sider, Content, Footer} = Layout;

const AdminLayout = (props) => {
        const [collapsed, setCollapsed] = useState(false);

        function toggle() {
            setCollapsed(!collapsed);
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
                    <div className="logo"/>
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
                        {/*<Menu.Item key="3" icon={<ReloadOutlined/>}>*/}
                        {/*    Перерабоки*/}
                        {/*</Menu.Item>*/}
                        <Menu.Item key="3" icon={<ShopOutlined/>}>
                            <a href="/admin/sale-page">
                                Продажи
                            </a>
                        </Menu.Item>
                        {/*<Menu.Item key="5" icon={<ReconciliationOutlined/>}>*/}
                        {/*    Склад*/}
                        {/*</Menu.Item>*/}
                        <Menu.Item key="4" icon={<LineChartOutlined/>}>
                            <a href="/admin/analytic-page">
                                Аналитика
                            </a>
                        </Menu.Item>
                        {/*<Menu.Item key="6" icon={<KeyOutlined/>}>*/}
                        {/*    Администрирование*/}
                        {/*</Menu.Item>*/}
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
                                <Link to={'/login'}>
                                    <strong className="login">user_user1 &nbsp;<Avatar size={32}
                                                                                       icon={<UserOutlined/>}/></strong>
                                </Link>
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
