import React, {Component, useEffect, useState} from 'react';
import Header from "../components/Header";
import entrancesService from "../services/EntrancesService";
import {Table, Skeleton} from "antd";
import {observer} from "mobx-react";

const AdminMainPage = observer(() => {
    const [dataSource, setDataSource] = useState([]);

    useEffect(()=>{
        //console.log("1");
        entrancesService.getDeliveryPositions().then((response)=>{
            setDataSource(response.data.data);
        });
        //setDataSource(entrancesService.deliveryPositions);
    },[])

  //  useEffect(()=>{
        //console.log("1");
        //entrancesService.getDeliveryPositions();
  //      setDataSource(entrancesService.deliveryPositions);
   // },[entrancesService.deliveryPositions])


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
                {dataSource.length ?
                <Table dataSource={dataSource} columns={columns}/>:
                    <Skeleton active />}
            </div>
        )
})

export default AdminMainPage;