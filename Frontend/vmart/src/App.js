import React, { Component } from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import SignUp from "./App/components/Signup";
import "./Assects/css/main.css";
import Login from "./App/components/Login";
import Home from "./App/components/Home";

import SellerLogin from "./App/components/Seller/SellerLogin";
import SellerRegister from "./App/components/Seller/SellerRegister";
import SellerDashBoard from "./App/components/Seller/SellerDashBoard";
import SellerAddProduct from "./App/components/Seller/SellerAddProduct";

import Checkout from "./App/components/checkout/Checkout";

class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <div className="App">
          <Switch>
            <Route path="/signup" component={SignUp} />
            <Route path="/login" component={Login} />

            <Route path="/checkout" component={Checkout}/>

            <Route path="/sellerLogin" component={SellerLogin} />
            <Route path="/sellerRegister" component={SellerRegister}/>
            <Route path="/SellerDashBoard" component={SellerDashBoard} />
            <Route path="/SellerAddProduct" component={SellerAddProduct} />

            <Route path="/" component={Home} />
          </Switch>
        </div>
      </BrowserRouter>
    );
  }
}

export default App;
