import React, {useEffect} from 'react';
import {Row, Col, Card} from "antd";
import entrancesService from "../services/EntrancesService";
import {Table, Skeleton} from "antd";
import {observer} from "mobx-react";
import AdminLayout from "../components/layot/AdminLayout";
import deliveryService from "../services/DeliveryService";

const AdminMainPage = observer(() => {

    useEffect(()=>{
        deliveryService.getDelivery();
    },[]);

    const columns = [
        {
            title: '№',
            dataIndex: 'id',
            key: 'id',
        },
        {
            title: 'Дата',
            dataIndex: 'date',
            key: 'date',
        },
        {
            title: 'Поставщик',
            dataIndex: 'suppliersBySuppliersId.name',
            key: 'suppliersBySuppliersId.name',
        },
    ];

        return (
            <div>
                <AdminLayout>
                    <Row gutter={[16, 16]}>
                        <Col sm={24} ms={24} lg={24} xl={24}>
                            <Card title="Поставки">
                                {deliveryService.delivery.length ?
                                    <Table dataSource={deliveryService.delivery} columns={columns}/>:
                                    <Skeleton active />}
                            </Card>
                        </Col>
                        {/*<Col sm={24} ms={24} lg={24} xl={8}>*/}
                        {/*    <Card title="Находится в переработке">*/}
                        {/*        None*/}
                        {/*    </Card>*/}
                        {/*</Col>*/}
                    </Row>
                </AdminLayout>
            </div>
        )
});

export default AdminMainPage;