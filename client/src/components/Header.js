import React from 'react';
import {Typography, Row, Col} from "antd";
import {Link} from "react-router-dom";

const {Title} = Typography;

const Header =(props) =>{
    return(
        <div>
    <Row style={{minHeight: "100px", backgroundColor:'#E5F0FF', padding:'8px'}} align="middle">
        <Col span={16}>
            <Link to={'/'}>
                <Title level={2}>ИП Красномясов А.И.</Title>
            </Link>
            </Col>
        {!props.disableLogin && <Col span={8}><Link to={`/login`} >Вход</Link></Col>}
    </Row>
        <div style={{width: '100%', height:'6px', backgroundColor:'#D4D4D4'}} />
        </div>
    )
}
export default Header;
