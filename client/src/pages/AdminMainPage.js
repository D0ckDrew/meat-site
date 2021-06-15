import React, {useEffect} from 'react';
import {Row, Col, Card, Divider} from "antd";
import entrancesService from "../services/EntrancesService";
import {Table, Skeleton} from "antd";
import {observer} from "mobx-react";
import AdminLayout from "../components/layot/AdminLayout";
import Title from "antd/es/typography/Title";
import Paragraph from "antd/es/typography/Paragraph";

const AdminMainPage = observer(() => {

    return (
        <div>
            <AdminLayout>
                <Title level={2}>Добро пожаловать в web-приложение учета и анализа деятельности малого предприятия по
                    производству мясной продукции!</Title>
                <Divider/>
                <Paragraph>Здесь представлены основные функции по управлению и анализу деятельности
                    предприятия.</Paragraph>
                <Paragraph>В зависимости от ваших полномочий вам могут быть доступны следующие функции, увидеть которые
                    можно в левом всплывающем меню:
                    <ul>
                        <li>Поставки. Управление и добавление новых поставок в систему;</li>
                        <li>Продажи. Служит для оформления продаж произведенной продукции;</li>
                        <li>Аналитика. Позволяет анализировать деятельность предприятия.</li>
                    </ul>
                </Paragraph>
                <Paragraph>Данные разделы имеют не конечный вид и будут дополняться в зависимости от потребностей
                    предприятия.
                </Paragraph>
            </AdminLayout>
        </div>
    )
});

export default AdminMainPage;