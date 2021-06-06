import axios from "axios";
import {message} from 'antd';
import {action, decorate, observable} from "mobx";
import API from "../utils/API";

class MaterialWarehouseService {
    materials = [];


    getMaterials(){
        API.get("/materialWarehouse/getMaterials")
            .then(function (result) {
                console.log(result);
                if (result.status === 200){
                    message.success("Success");
                    materialWarehouseService.materials = result.data;
                }
                else {
                    message.error(result.message);
                }
            })
            .catch(function () {
                message.error("Ошибка сервера!");
            });
    };
}

decorate(MaterialWarehouseService,{
    materials : observable,
    getMaterials : action,
});

const materialWarehouseService = new MaterialWarehouseService();
export default materialWarehouseService;