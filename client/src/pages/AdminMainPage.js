import React, {useEffect, useState} from 'react';
import Header from "../components/Header";
import entrancesService from "../services/EntrancesService";
import {Table, Skeleton} from "antd";
import {observer} from "mobx-react";

const AdminMainPage = observer(() => {

    useEffect(()=>{
        entrancesService.getDeliveryPositions();
    },[])

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
                <Header disableLogin/>
                {entrancesService.deliveryPositions.length ?
                <Table dataSource={entrancesService.deliveryPositions} columns={columns}/>:
                    <Skeleton active />}
            </div>
        )
})

export default AdminMainPage;