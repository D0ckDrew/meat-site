import axios from "axios";
import {message} from 'antd';
import {action, decorate, observable} from "mobx";

class EntrancesService {
    deliveryPositions = [];

    getDeliveryPositions(){
        axios.get(`http://localhost:3001/entrances/getDeliveryPositions`)
           .then(function (result) {
               if (result.data["status"] === 200){
                   message.success("Success");
                   entrancesService.deliveryPositions = result.data.data;
               }
               else {
                   message.error(result.data["message"]);
               }
            })
            .catch(function () {
                message.error("Неизвестная ошибка!");
            });
    };
}

decorate(EntrancesService,{
    deliveryPositions : observable,
    getDeliveryPositions : action
})

const entrancesService = new EntrancesService();
export default entrancesService;