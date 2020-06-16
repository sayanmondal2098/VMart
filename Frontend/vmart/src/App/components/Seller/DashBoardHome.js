import React from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import { Helmet } from "react-helmet";
import "../../../Assects/css/DashBoaed.css";

import SellerDashBoard from "./SellerDashBoard";
import DashBoardHeader from "./DashBoardHeader";

class DashBoardHome extends React.Component {

    render() {
      return (
          <div>
              <DashBoardHeader />
              <SellerDashBoard />
          </div>
      );
    }
  }
  
  export default DashBoardHome;
  