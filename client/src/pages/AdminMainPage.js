import React, {useEffect} from 'react';
import {Row, Col, Card} from "antd";
import entrancesService from "../services/EntrancesService";
import {Table, Skeleton} from "antd";
import {observer} from "mobx-react";
import AdminLayout from "../components/layot/AdminLayout";

const AdminMainPage = observer(() => {

    useEffect(()=>{
        entrancesService.getDeliveryPositions();
    },[]);

    const columns = [
        {
            title: 'ID',
            dataIndex: 'key',
            key: 'key',
        },
        {
            title: 'Номер партии',
            dataIndex: 'id_entrances',
            key: 'id_entrances',
        },
        {
            title: 'Дата',
            dataIndex: 'date',
            key: 'date',
        },
        {
            title: 'Позиция',
            dataIndex: 'product_positions_name',
            key: 'product_positions_name',
        },
        {
            title: 'Поставщик',
            dataIndex: 'vendors_name',
            key: 'vendors_name',
        },
    ];

        return (
            <div>
                <AdminLayout>
                    <Row gutter={[16, 16]}>
                        <Col sm={24} ms={24} lg={24} xl={16}>
                            <Card title="Позиции на складе">
                                {entrancesService.deliveryPositions.length ?
                                    <Table dataSource={entrancesService.deliveryPositions} columns={columns}/>:
                                    <Skeleton active />}
                            </Card>
                        </Col>
                        <Col sm={24} ms={24} lg={24} xl={8}>
                            <Card title="Находится в переработке">
                                None
                            </Card>
                        </Col>
                    </Row>
                </AdminLayout>
            </div>
        )
});

export default AdminMainPage;