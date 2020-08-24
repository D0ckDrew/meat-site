import axios from "axios";
import {message} from 'antd';
import {action, computed, observable, reaction} from "mobx";

class EntrancesService {
    getDeliveryPositions(){
        axios.get(`http://localhost:3001/entrances/getDeliveryPositions`)
            .then(function () {
                message.success("Success");
            })
            .catch(function () {
                message.error("Error");
            });
    };

}
const entrancesService = new EntrancesService();
export default entrancesService;