import React, { Component } from "react";
import { Slide } from "react-slideshow-image";
import { BACKEND_URL } from "../config/Config";
import axios from "axios";

export default class PromoImageSlider extends Component {
  constructor(props) {
    super(props);

    this.state = {
      slideImages: [],
      redirects: [],
    };

    this.getImages = this.getImages.bind(this);
  }

  getImages() {
    if (this.state.slideImages.length === 0) {
      axios
        .get(BACKEND_URL + `/promoimages`)
        .then((response) => {
          this.responseController(response);
        })
        .catch((error) => {
          console.log(error);
        });
    }
  }

  responseController(response) {
    if (response.status === 200) {
      if (
        response.data.status === "error" &&
        response.data.message === "no_images_found"
      ) {
        console.log("images not found for the slideshow");
      } else if (
        response.data.status === "success" &&
        response.data.message === "images_found"
      ) {
        for (var i = 0; i < response.data.images.length; i++) {
          console.log(response.data.images[i].url);
          this.setState({
            slideImages: [
              ...this.state.slideImages,
              response.data.images[i].url,
            ],
            redirects: [
              ...this.state.redirects,
              response.data.images[i].redirect,
            ],
          });
        }
      }
    }
  }

  render() {
    const properties = {
      duration: 5000,
      transitionDuration: 500,
      infinite: true,
      indicators: true,
      arrows: true,
      pauseOnHover: true,
    };
    return (
      <div className="PromoImageSlider">
        {this.getImages()}
        <Slide {...properties}>
          <a href={this.state.redirects[0]}>
            <div className="each-slide">
              <div
                style={{ backgroundImage: `url(${this.state.slideImages[0]})` }}
              ></div>
            </div>
          </a>
          <a href={this.state.redirects[0]}>
          <div className="each-slide">
            <div
              style={{ backgroundImage: `url(${this.state.slideImages[1]})` }}
            ></div>
          </div>
          </a>
          <a href={this.state.redirects[0]}>
          <div className="each-slide">
            <div
              style={{ backgroundImage: `url(${this.state.slideImages[2]})` }}
            ></div>
          </div>
          </a>
        </Slide>
      </div>
    );
  }
}
