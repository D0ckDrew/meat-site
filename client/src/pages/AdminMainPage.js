import React, {Component, useEffect} from 'react';
import Header from "../components/Header";
import entrancesService from "../services/EntrancesService";



const AdminMainPage = () => {
    useEffect(()=>{
        //console.log("1");
        entrancesService.getDeliveryPositions();
    },[])

        return (
            <div>
                <Header disableLogin/>
            </div>
        )
}

export default AdminMainPage;