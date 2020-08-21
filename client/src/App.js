import React, { Component } from 'react';
import logo from './logo.svg';
//import 'antd/dist/antd.css';
import './App.css';
import {Route, Switch, Redirect, withRouter} from "react-router-dom";
import MainPage from './pages/MainPage';
import LoginPage from './pages/LoginPage';

class App extends Component {
  render() {
    return (
        <Switch>
            <Route exact path='/' component={MainPage}/>
            <Route exact path='/login' component={LoginPage}/>
            <Redirect from='/go' to='/login'/>
        </Switch>
    );
  }
}

export default  withRouter(App);
