import React from "react";
import "../../Assects/css/main.css";
import PromoImageSlider from "./PromoImageSlider";
import Categories from "./Categories";

class HomeView extends React.Component {
  constructor(props) {
    super(props);
    const sess_token = localStorage.getItem("session_token");
    let loggedIn = true;
    if (sess_token == null) {
      loggedIn = false;
    }
    this.state = {
      customerName: localStorage.getItem("name"),
      loggedIn,
    };
  }

  render() {
    return (
        <div className="HomeView">
        <PromoImageSlider/>
        <Categories/>
        </div>
    );
  }
}

export default HomeView;
