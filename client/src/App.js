import React, { Component } from 'react';
import 'antd/dist/antd.css';
import './App.css';
import {Route, Switch, Redirect, withRouter} from "react-router-dom";
import MainPage from './pages/MainPage';
import LoginPage from './pages/LoginPage';
import AdminMainPage from "./pages/AdminMainPage";
import AdminDeliveryPage from "./pages/AdminDeliveryPage";
import AdminSalePage from "./pages/AdminSalePage";
import AdminAnalyticPage from "./pages/AdminAnalyticPage";

class App extends Component {
  render() {
    return (
        <Switch>
            <Route exact path='/' component={MainPage}/>
            <Route exact path='/login' component={LoginPage}/>
            <Route exact path='/admin/main-page' component={AdminMainPage}/>
            <Route exact path='/admin/delivery-page' component={AdminDeliveryPage}/>
            <Route exact path='/admin/sale-page' component={AdminSalePage}/>
            <Route exact path='/admin/analytic-page' component={AdminAnalyticPage}/>
            <Redirect from='/go' to='/login'/>
        </Switch>
    );
  }
}

export default  withRouter(App);
