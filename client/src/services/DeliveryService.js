import axios from "axios";
import {message} from 'antd';
import {action, decorate, observable} from "mobx";
import API from "../utils/API";

class DeliveryService {
    delivery = [];
    suppliers = [];
    receipts = [];


    getSuppliers(){
        API.get("/delivery/getSuppliers")
            .then(function (result) {
                console.log(result);
                if (result.status === 200){
                    message.success("Success");
                    deliveryService.suppliers = result.data;
                }
                else {
                    message.error(result.message);
                }
            })
            .catch(function () {
                message.error("Ошибка сервера!");
            });
    };

    getDelivery(){
        API.get("/delivery/getDeliveries")
           .then(function (result) {
               console.log(result);
               if (result.status === 200){
                   message.success("Success");
                   deliveryService.delivery = [];
                       result.data.map(item => {
                           item.suppliersName = item.suppliersBySuppliersId.name;
                           item.key = item.id;
                           deliveryService.delivery.push(item);
                       })
               }
               else {
                   message.error(result.message);
               }
            })
            .catch(function () {
                message.error("Ошибка сервера!");
            });
    };

    getReceiptsByDeliveryId(deliveryId){
        const params = new URLSearchParams({'deliveryId': deliveryId});
        API.get("/delivery/getReceiptsByDeliveryId", {params})
            .then(function (result) {
                console.log(result);
                if (result.status === 200){
                    message.success("Success");
                    deliveryService.receipts = result.data;
                }
                else {
                    message.error(result.message);
                }
            })
            .catch(function () {
                message.error("Ошибка сервера!");
            });
    };

    addDelivery(delivery){
        console.log(delivery);
        const params = new URLSearchParams(delivery);
        API.post("/delivery/addDelivery", null,{params})
            .then(function (result) {
                console.log(result);
                if (result.status === 200){
                    message.success("Success");
                    deliveryService.delivery = result.data;
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

decorate(DeliveryService,{
    delivery : observable,
    getDelivery : action,

    suppliers : observable,
    getSuppliers : action,

    receipts: observable,
    getReceiptsByDeliveryId: action
});

const deliveryService = new DeliveryService();
export default deliveryService;