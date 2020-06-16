import React, { Component } from "react";

export default class ProductCard extends Component {
  constructor(props) {
    super(props);

    this.state = {
      prodID: this.props.pid,
      image: this.props.image,
      name: this.props.name,
      sellPrice: Math.round(this.props.discount * this.props.price),
      price: this.props.price,
      offer: Math.round((1 - this.props.discount) * 100),
    };
  }

  render() {
    return (
      <a
        className="emphasis_link"
        href={
          "/product/" + this.state.prodID + "/" + encodeURI(this.state.name)
        }
        target="_blank"
        rel="noopener noreferrer"
      >
        <div className="ProductCard">
          <img
            className="card"
            src={this.state.image[0]}
            alt={this.state.name}
          />
          <br />
          <label className="boldtextH1">{this.state.name}</label>
          <br />
          <label className="boldtextH2">₹ {this.state.sellPrice}</label>
          <label className="textH2">₹ {this.state.price}</label>
          <label className="textoffer">({this.state.offer}% OFF)</label>
          <br />
        </div>
      </a>
    );
  }
}
