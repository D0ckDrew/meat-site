import React, {useEffect, useState} from 'react';
import {Row, Col, Card, Statistic, Tabs} from "antd";
import {observer} from "mobx-react";
import AdminLayout from "../components/layot/AdminLayout";
import deliveryService from "../services/DeliveryService";
import {
    VictoryChart,
    VictoryTheme,
    VictoryLine,
    VictoryZoomContainer,
    VictoryBrushContainer,
} from 'victory';
import {ArrowDownOutlined, ArrowUpOutlined} from "@ant-design/icons";

const {TabPane} = Tabs;

const AdminMainPage = observer(() => {

    const [zoomDomain, setZoomDomain] = useState({x: [new Date(2021, 5, 1), new Date(2021, 5, 6)]});

    function handleZoom(domain) {
        setZoomDomain(domain);
    }

    useEffect(() => {
        deliveryService.getDelivery();
    }, []);

    return (
        <div>
            <AdminLayout>
                <Tabs defaultActiveKey="1">
                    <TabPane tab="Общая информация" key="1">
                        <Row gutter={[16, 16]}>
                            <Col sm={24} ms={24} lg={24} xl={6}>
                                <Card>
                                    <Statistic
                                        title="Сумма продаж"
                                        value={11.28}
                                        precision={2}
                                        valueStyle={{color: '#3f8600'}}
                                        prefix={<ArrowUpOutlined/>}
                                        suffix="%"
                                    />
                                    103 453 ₽
                                </Card>
                            </Col>
                            <Col sm={24} ms={24} lg={24} xl={6}>
                                <Card>
                                    <Statistic
                                        title="Кол-во продаж"
                                        value={9.3}
                                        precision={2}
                                        valueStyle={{color: '#cf1322'}}
                                        prefix={<ArrowDownOutlined/>}
                                        suffix="%"
                                    />
                                    26
                                </Card>
                            </Col>
                            <Col sm={24} ms={24} lg={24} xl={6}>
                                <Card>
                                    <Statistic title="Товар дня" value="Грудинка копченая"/>
                                </Card>
                            </Col>
                        </Row>
                    </TabPane>
                    <TabPane tab="Статистика продаж" key="2">
                        <Card title="Статистика продаж">
                            <VictoryChart height={200} scale={{x: "time"}}
                                          padding={{top: 10, left: 50, right: 50, bottom: 30}}
                                          theme={VictoryTheme.material}
                                          containerComponent={
                                              <VictoryZoomContainer
                                                  zoomDimension="x"
                                                  zoomDomain={zoomDomain}
                                                  onZoomDomainChange={handleZoom.bind(this)}
                                              />
                                          }
                            >
                                <VictoryLine
                                    style={{
                                        data: {stroke: "tomato"}
                                    }}
                                    data={[
                                        {a: new Date(2021, 5, 1), b: 25},
                                        {a: new Date(2021, 5, 2), b: 31},
                                        {a: new Date(2021, 5, 3), b: 32},
                                        {a: new Date(2021, 5, 4), b: 40},
                                        {a: new Date(2021, 5, 5), b: 30},
                                        {a: new Date(2021, 5, 6), b: 24},
                                        {a: new Date(2021, 5, 7), b: 15},
                                        {a: new Date(2021, 5, 8), b: 56},
                                        {a: new Date(2021, 5, 9), b: 32},
                                        {a: new Date(2021, 5, 10), b: 41},
                                        {a: new Date(2021, 5, 11), b: 12},
                                        {a: new Date(2021, 5, 12), b: 45},
                                        {a: new Date(2021, 5, 13), b: 46},
                                        {a: new Date(2021, 5, 14), b: 23},
                                        {a: new Date(2021, 5, 15), b: 25},
                                        {a: new Date(2021, 5, 16), b: 56},
                                        {a: new Date(2021, 5, 17), b: 64},
                                        {a: new Date(2021, 5, 18), b: 67},
                                        {a: new Date(2021, 5, 19), b: 71},
                                        {a: new Date(2021, 5, 20), b: 62},
                                        {a: new Date(2021, 5, 21), b: 63},
                                        {a: new Date(2021, 5, 22), b: 54},
                                        {a: new Date(2021, 5, 23), b: 65},
                                        {a: new Date(2021, 5, 24), b: 67},
                                        {a: new Date(2021, 5, 25), b: 65},
                                        {a: new Date(2021, 5, 26), b: 70}
                                    ]}
                                    x="a"
                                    y="b"
                                />

                            </VictoryChart>
                            <VictoryChart
                                padding={{top: 10, left: 50, right: 50, bottom: 0}}
                                width={600} height={100} scale={{x: "time"}}
                                containerComponent={
                                    <VictoryBrushContainer
                                        brushDimension="x"
                                        brushDomain={zoomDomain}
                                        onBrushDomainChange={handleZoom.bind(this)}
                                    />
                                }
                            >
                                <VictoryLine
                                    style={{
                                        data: {stroke: "tomato"}
                                    }}
                                    data={[
                                        {a: new Date(2021, 5, 1), b: 25},
                                        {a: new Date(2021, 5, 2), b: 31},
                                        {a: new Date(2021, 5, 3), b: 32},
                                        {a: new Date(2021, 5, 4), b: 40},
                                        {a: new Date(2021, 5, 5), b: 30},
                                        {a: new Date(2021, 5, 6), b: 24},
                                        {a: new Date(2021, 5, 7), b: 15},
                                        {a: new Date(2021, 5, 8), b: 56},
                                        {a: new Date(2021, 5, 9), b: 32},
                                        {a: new Date(2021, 5, 10), b: 41},
                                        {a: new Date(2021, 5, 11), b: 12},
                                        {a: new Date(2021, 5, 12), b: 45},
                                        {a: new Date(2021, 5, 13), b: 46},
                                        {a: new Date(2021, 5, 14), b: 23},
                                        {a: new Date(2021, 5, 15), b: 25},
                                        {a: new Date(2021, 5, 16), b: 56},
                                        {a: new Date(2021, 5, 17), b: 64},
                                        {a: new Date(2021, 5, 18), b: 67},
                                        {a: new Date(2021, 5, 19), b: 71},
                                        {a: new Date(2021, 5, 20), b: 62},
                                        {a: new Date(2021, 5, 21), b: 63},
                                        {a: new Date(2021, 5, 22), b: 54},
                                        {a: new Date(2021, 5, 23), b: 65},
                                        {a: new Date(2021, 5, 24), b: 67},
                                        {a: new Date(2021, 5, 25), b: 65},
                                        {a: new Date(2021, 5, 26), b: 70}
                                    ]}
                                    x="a"
                                    y="b"
                                />
                            </VictoryChart>
                        </Card>
                    </TabPane>
                </Tabs>
            </AdminLayout>
        </div>
    )
});

export default AdminMainPage;