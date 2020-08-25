import axios from "axios";
import {message} from 'antd';
import {action, computed, observable, reaction} from "mobx";

class EntrancesService {
    deliveryPositions = [];

    getDeliveryPositions(){
        return axios.get(`http://localhost:3001/entrances/getDeliveryPositions`)
           /* .then(function (response) {
                message.success("Success");
                if (response.data.data.length){
                    entrancesService.deliveryPositions = response.data.data;
                    //console.log(entrancesService.deliveryPositions);
                }
            })
            .catch(function () {
                message.error("Error");
            });*/
    };

}
const entrancesService = new EntrancesService();
export default entrancesService;