import React from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import { Helmet } from "react-helmet";
import "../../Assects/css/main.css";
import Header from "./Header";
import Footer from "./Footer";
import ProductsCategory from "./ProductsCategory";
import HomeView from "./HomeView";
import ProductPage from "./ProductPage";

class Home extends React.Component {

  render() {
    return (
      <BrowserRouter>
      <Header />
        <div className="Home">
        <Helmet>
          <title>VMart</title>
        </Helmet>
          <Switch>
            <Route path="/products/:catID/:catName" component={ProductsCategory} />
            <Route path="/product/:pID/:pName" component={ProductPage} />
            <Route path="/" component={HomeView} />
          </Switch>

          <Footer />
        </div>
      </BrowserRouter>
    );
  }
}

export default Home;
