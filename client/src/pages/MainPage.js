import React, { Component } from 'react';
import AdminLayout from "../components/layot/AdminLayout";


export default class MainPage extends Component{
    render () {
        return (
            <div>
                <AdminLayout>
                    Контент тут
                </AdminLayout>
            </div>
        )
    }
}