import React, {useEffect, useState} from 'react';
import {Row, Col, Card, Form, InputNumber, Button, Input, Tag, Space, Select, Modal} from "antd";
import entrancesService from "../services/EntrancesService";
import {Table, Skeleton} from "antd";
import {observer} from "mobx-react";
import AdminLayout from "../components/layot/AdminLayout";
import deliveryService from "../services/DeliveryService";
import materialWarehouseService from "../services/MaterialWarehouseService";
import {MinusCircleOutlined, PlusOutlined} from "@ant-design/icons";
import Title from "antd/es/typography/Title";

const AdminMainPage = observer(() => {
    const [visibleModal1, setVisibleModel1] = useState(false);

    function getColor(count) {
        if (count >= 100) {
            return "green"
        } else if (count < 100 && count > 30) {
            return "gold"
        } else {
            return "red"
        }
    }

    const columns = [
        {
            title: '№',
            dataIndex: 'id',
            key: 'id',
        },
        {
            title: 'Продукт',
            dataIndex: 'product',
            key: 'product',
        },
        {
            title: 'Цена',
            dataIndex: 'price',
            key: 'price',
            render: price => (
                <>
                    {price} руб.
                </>
            ),
        },
        {
            title: 'Кол-во на складе',
            dataIndex: 'count',
            key: 'count',
            render: count => (
                <Tag color={getColor(count)}>
                    {count} кг.
                </Tag>
            ),
        },
    ];

    const data = [
        {
            id: 4,
            product: "Грудинка копченая",
            price: "345",
            count: "104.2"
        },
        {
            id: 1,
            product: "Карбонат копченый",
            price: "360",
            count: "53.6"
        },
        {
            id: 2,
            product: "Курица копченая",
            price: "320",
            count: "20.0"
        },
        {
            id: 3,
            product: "Бустурма",
            price: "460",
            count: "10.3"
        },
    ]

    return (
        <div>
            <AdminLayout>
                <Row gutter={[16, 16]}>
                    <Col sm={24} ms={24} lg={24} xl={24}>
                        <Card>
                            <Button type="primary" shape="round" onClick={() => setVisibleModel1(true)}>
                                Создать продажу
                            </Button>
                        </Card>
                    </Col>
                    <Col sm={24} ms={24} lg={24} xl={24}>
                        <Card>
                            <Form
                                name="customized_form_controls"
                                layout="inline"
                            >
                                <Form.Item style={{width: '80%'}} name="search-product" label="Поиск продукции">
                                    <Input/>
                                </Form.Item>
                                <Form.Item>
                                    <Button type="primary" htmlType="submit">
                                        Поиск
                                    </Button>
                                </Form.Item>
                            </Form>
                        </Card>
                    </Col>
                    <Col sm={24} ms={24} lg={24} xl={24}>
                        <Card title="Продукция">
                            <Table dataSource={data} columns={columns}/>
                        </Card>
                    </Col>
                </Row>
            </AdminLayout>
            <Modal
                title="Создание продажи #"
                visible={visibleModal1}
                onOk={() => {
                    setVisibleModel1(false);
                }}
                onCancel={() => setVisibleModel1(false)}
                okText="Создать"
                cancelText="Отмена"
                width={1000}
            >
                <Form name="dynamic_form_nest_item" autoComplete="off">
                    <Form.List name="entrances">
                        {(fields, {add, remove}) => (
                            <>
                                {fields.map(({key, name, fieldKey, ...restField}) => (
                                    <Space key={key} style={{display: 'flex', marginBottom: 8}} align="baseline">
                                        <Form.Item
                                            {...restField}
                                            name={[name, 'product']}
                                            fieldKey={[fieldKey, 'product']}
                                        >
                                            <Select
                                                style={{
                                                    minWidth: 200
                                                }}
                                                onChange ={(value) =>{

                                                    console.log(value)}
                                                }
                                                showSearch
                                                placeholder="Выберите товар"
                                                optionFilterProp="children"
                                                filterOption={(input, option) =>
                                                    option.children.toLowerCase().indexOf(input.toLowerCase()) >= 0
                                                }
                                            >
                                                {data.map(item => (
                                                    <Select.Option key={item.id} value={item.id}>
                                                        {item.product}
                                                    </Select.Option>
                                                ))}
                                            </Select>
                                        </Form.Item>
                                        <Form.Item
                                            {...restField}
                                            name={[name, 'quantity']}
                                            fieldKey={[fieldKey, 'quantity']}
                                        >
                                            <InputNumber
                                                style={{
                                                    minWidth: 200
                                                }}
                                                min="0"
                                                max="99999"
                                                step="0.00001"
                                                stringMode
                                            /> кг.
                                        </Form.Item>
                                        <Form.Item
                                            {...restField}
                                            name={[name, 'cost']}
                                            fieldKey={[fieldKey, 'cost']}>
                                            Стоимость: <InputNumber disabled={true} defaultValue={360} style={{color:'black'}}/>
                                        </Form.Item>
                                        <Form.Item>
                                            Сумма: <InputNumber disabled={true} defaultValue={1080} style={{color:'black'}}/>
                                        </Form.Item>
                                        <MinusCircleOutlined onClick={() => remove(name)}/>
                                    </Space>
                                ))}
                                <Form.Item>
                                    <Button type="dashed" onClick={() => add()} block icon={<PlusOutlined/>}>
                                        Добавить позицию
                                    </Button>
                                </Form.Item>
                                <Form.Item>
                                    <Title level={3}>Итого: 1080 руб.</Title>
                                </Form.Item>
                            </>
                        )}
                    </Form.List>
                </Form>
            </Modal>
        </div>
    )
});

export default AdminMainPage;