import React, { Component } from "react";
import { Helmet } from "react-helmet";
import { BACKEND_URL } from "../config/Config";
import axios from "axios";
import renderHTML from "react-render-html";
import ProductCard from "./ProductCard";
import ReactDOMServer from 'react-dom/server';

export default class ProductsCategory extends Component {
  constructor(props) {
    super(props);

    this.state = {
      catID: this.props.match.params.catID,
      catName:decodeURI(this.props.match.params.catName),
      prodID: [],
      images: [],
      names: [],
      discounts: [],
      prices: [],
      promiseIsResolved: false,
    };
    this.getProducts = this.getProducts.bind(this);
    this.prodView = this.prodView.bind(this);
  }

  componentDidMount() {
    this.getProducts();
  }

  getProducts() {
    if (!this.state.promiseIsResolved) {
      axios
        .get(BACKEND_URL + `/products?cat_id=` + this.state.catID)
        .then((response) => {
          this.responseController(response);
        })
        .catch((error) => {
          console.log(error);
        });
    }
  }

  prodView(){
    var retView = '';
    retView += (
      '<table className="categoryhome_table">'
      +'<tr>');
      for(var i=0;i<this.state.prodID.length;i++)
      {
        retView+='<td>';
        retView+=ReactDOMServer.renderToString(<ProductCard pid={this.state.prodID[i]} image={this.state.images[i]} name={this.state.names[i]} discount={this.state.discounts[i]} price={this.state.prices[i]}/>);
        retView+='</td>';  
        if((i+1)%5===0)
            {
                retView+=('</tr><tr>');
            }
      }
        retView+=('</tr>');
        retView+=('</table>');
    return retView;
  }

  responseController(response) {
    if (response.status === 200) {
      if (
        response.data.status === "error" &&
        response.data.message === "no_products_found"
      ) {
        console.log("products not found");
      } else if (
        response.data.status === "success" &&
        response.data.message === "products_found"
      ) {
        for (var i = 0; i < response.data.products.length; i++) {
          console.log(response.data.products[i]);
          var urls = [];
          for (var k = 0; k < response.data.products[i].pictures.length; k++) {
            urls[k] = response.data.products[i].pictures[k].url;
          }
          this.setState({
            images: [...this.state.images, urls],
            names: [...this.state.names, response.data.products[i].name],
            discounts: [
              ...this.state.discounts,
              response.data.products[i].discount,
            ],
            prices: [...this.state.prices, response.data.products[i].price],
            prodID: [...this.state.prodID, response.data.products[i].pid],
          });
        }
        this.setState({
          ...this.state,
          promiseIsResolved: true,
        });
      }
    }
  }

  render() {
    if (!this.state.promiseIsResolved) {
      return null;
    } else {
      return (
        <div className="ProductsCategory">   
        <Helmet>
          <title>{this.state.catName} | VMart</title>
        </Helmet>
          <br/><br/>
          <label className="blackHeadlbl">{this.state.catName}</label>
              <br /><br/>
          {renderHTML(this.prodView())}
        </div>
      );
    }
  }
}
