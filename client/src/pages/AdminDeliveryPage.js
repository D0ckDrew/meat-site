import React, {useEffect, useState} from 'react';
import {Row, Col, Card, Button, Tooltip, Modal, Select, Form, Input, DatePicker, Space, InputNumber} from "antd";
import {Table, Skeleton} from "antd";
import {observer} from "mobx-react";
import AdminLayout from "../components/layot/AdminLayout";
import deliveryService from "../services/DeliveryService";
import {MinusCircleOutlined, PlusOutlined} from "@ant-design/icons";
import {Option} from "antd/es/mentions";
import useForm from "antd/es/form/hooks/useForm";
import materialWarehouseService from "../services/MaterialWarehouseService";

const AdminMainPage = observer(() => {
    const [visibleModal1, setVisibleModel1] = useState(false);
    const [visibleModal2, setVisibleModel2] = useState(false);

    const [formDelivery] = useForm();
    const [formEntrances] = useForm();

    useEffect(() => {
        deliveryService.getDelivery();
        deliveryService.getSuppliers();
        materialWarehouseService.getMaterials();
    }, []);

    function showModal() {
        setVisibleModel1(true);
    }

    function hideModal() {
        setVisibleModel1(false);
    }

    function showEntrancesModal(deliveryId){
        console.log(deliveryId);
        deliveryService.getReceiptsByDeliveryId(deliveryId);

        let formValues = [];
        deliveryService.receipts.map(item => {
            formValues.push({
                material: deliveryService.receipts.materialReceiptsLogById.materialId,
                quantity: deliveryService.receipts.materialReceiptsLogById.quantity
            });
        });

        formEntrances.setFields([
            {
                name: 'entrances',
                value: formValues,
                errors: ['error-string'],
            },
        ]);
        setVisibleModel2(true);
    }

    function addDelivery() {
        const delivery = {
            suppliersId: formDelivery.getFieldValue("supplier"),
            timestamp: Math.floor(formDelivery.getFieldValue("date").unix())
        };
        deliveryService.addDelivery(delivery);
        hideModal();
    }

    const layout = {
        labelCol: {span: 8},
        wrapperCol: {span: 16},
    };

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
            dataIndex: 'suppliersName',
            key: 'suppliersName',
        },
        {
            title: "Действия",
            key: "action",
            render: (text, record) => (
                <Space size="middle">
                    <Button onClick={() => showEntrancesModal(record.id)}>Редактировать позиции</Button>
                </Space>
            )
        }
    ];

    return (
        <div>
            <AdminLayout>
                <Row gutter={[16, 16]}>
                    <Col sm={24} ms={24} lg={24} xl={24}>
                        <Card title="Поставки" extra={
                            <Tooltip title="Добавить поступление">
                                <Button type="primary" shape="circle" icon={<PlusOutlined/>}
                                        onClick={() => showModal()}/>
                            </Tooltip>}>
                            {deliveryService.delivery.length ?
                                <Table dataSource={deliveryService.delivery} columns={columns}/> :
                                <Skeleton active/>}
                        </Card>
                    </Col>
                    {/*<Col sm={24} ms={24} lg={24} xl={8}>*/}
                    {/*    <Card title="Находится в переработке">*/}
                    {/*        None*/}
                    {/*    </Card>*/}
                    {/*</Col>*/}
                </Row>
            </AdminLayout>

            <Modal
                title="Добавление поставки"
                visible={visibleModal1}
                onOk={() => addDelivery()}
                onCancel={() => hideModal()}
                okText="Добавить"
                cancelText="Отмена"
                width={1000}
            >
                <Form
                    {...layout}
                    name="basic"
                    form={formDelivery}
                    initialValues={{remember: true}}
                    // onFinish={onFinish}
                    // onFinishFailed={onFinishFailed}
                >
                    <Form.Item
                        label="Поставщик"
                        name="supplier"
                        rules={[{required: true, message: 'Пожалуйста, выберите поставщика!'}]}
                    >
                        <Select
                            showSearch
                            placeholder="Select a person"
                            optionFilterProp="children"
                            // onChange={onChange}
                            // onFocus={onFocus}
                            // onBlur={onBlur}
                            // onSearch={onSearch}
                            filterOption={(input, option) =>
                                option.children.toLowerCase().indexOf(input.toLowerCase()) >= 0
                            }
                        >
                            {deliveryService.suppliers.map(item => (
                                <Select.Option key={item.id} value={item.id}>
                                    {item.name}
                                </Select.Option>
                            ))}
                        </Select>
                    </Form.Item>

                    <Form.Item
                        label="Дата поставки"
                        name="date"
                        rules={[{required: true, message: 'Пожалуйста, введите дату поставки!'}]}
                    >
                        <DatePicker showTime placeholder="Дата поставки"
                            //onChange={onChange} onOk={onOk}
                        />
                    </Form.Item>
                </Form>
            </Modal>

            <Modal
                title="Редактирование позиций"
                visible={visibleModal2}
                onOk={() => {setVisibleModel2(false); console.log(formEntrances.getFieldsValue())}}
                onCancel={() => setVisibleModel2(false)}
                okText="Добавить"
                cancelText="Отмена"
                width={1000}
            >
                <Form name="dynamic_form_nest_item" form={formEntrances} autoComplete="off">
                    <Form.List name="entrances">
                        {(fields, { add, remove }) => (
                            <>
                                {fields.map(({ key, name, fieldKey, ...restField }) => (
                                    <Space key={key} style={{ display: 'flex', marginBottom: 8 }} align="baseline">
                                        <Form.Item
                                            {...restField}
                                            name={[name, 'material']}
                                            fieldKey={[fieldKey, 'material']}
                                        >
                                            <Select
                                                style={{
                                                    minWidth: 200
                                                }}
                                                showSearch
                                                placeholder="Выберите материал"
                                                optionFilterProp="children"
                                                filterOption={(input, option) =>
                                                    option.children.toLowerCase().indexOf(input.toLowerCase()) >= 0
                                                }
                                            >
                                                {materialWarehouseService.materials.map(item => (
                                                    <Select.Option key={item.id} value={item.id}>
                                                        {item.name}
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
                                            />
                                        </Form.Item>
                                    </Space>
                                ))}
                                <Form.Item>
                                    <Button type="dashed" onClick={() => add()} block icon={<PlusOutlined />}>
                                        Добавить позицию
                                    </Button>
                                </Form.Item>
                            </>
                        )}
                    </Form.List>
                    <Form.Item>
                        <Button type="primary" htmlType="submit">
                            Submit
                        </Button>
                    </Form.Item>
                </Form>
            </Modal>
        </div>
    )
});

export default AdminMainPage;