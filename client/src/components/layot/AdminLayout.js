import React from 'react';
import { useState } from 'react';
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
    TableOutlined
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
        <Layout style={{minHeight: '100vh'}}>
            <Sider trigger={null} collapsible collapsed={collapsed}>
                <div className="logo" />
                <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
                    <Menu.Item key="1" icon={<TableOutlined />}>
                        Главная
                    </Menu.Item>
                    <Menu.Item key="2" icon={<ReloadOutlined />}>
                        Перерабоки
                    </Menu.Item>
                    <Menu.Item key="3" icon={<ScheduleOutlined />}>
                        Поставки
                    </Menu.Item>
                    <Menu.Item key="4" icon={<ShopOutlined />}>
                        Продажи
                    </Menu.Item>
                    <Menu.Item key="5" icon={<ReconciliationOutlined />}>
                        Склад
                    </Menu.Item>
                    <Menu.Item key="6" icon={<LineChartOutlined />}>
                        Аналитика
                    </Menu.Item>

                </Menu>
            </Sider>
            <Layout className="site-layout">
                <Header className="header" style={{ padding: 0, color: "#fff"}}>
                    <Row>
                        <Col span={12}>
                            {collapsed ? <MenuUnfoldOutlined className="trigger" onClick={() => toggle()}/> : <MenuFoldOutlined className="trigger" onClick={() => toggle()}/>}
                        </Col>
                        <Col span={12}>
                            <Link to={'/login'}>
                                <strong className="login">user_user1 &nbsp;<Avatar size={32} icon={<UserOutlined />} /></strong>
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
                <Footer style={{ textAlign: 'center' }}>ИП Красномясов А. И.©2021 Created by DD</Footer>
            </Layout>
        </Layout>
    )
};

export default AdminLayout;
