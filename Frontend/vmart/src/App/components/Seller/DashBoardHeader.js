import React from "react";
import logo from "../../../Assects/img/vmart-logo.png";
import logout from "../../../Assects/img/logout-icon.ico";

import "../../../Assects/css/DashBoaed.css";

class DashBoardHeader extends React.Component {
  constructor(props) {
    super(props);
    const seller_sess_token = localStorage.getItem("seller_sess_token");
    let loggedIn = true;
    if (seller_sess_token == null) {
      loggedIn = false;
    }
    this.state = {
      search: "",
      customerName: localStorage.getItem("name"),
      showAcMenu: false,
      loggedIn,
    };

    this.handleSearchChange = this.handleSearchChange.bind(this);
    this.handleSearch = this.handleSearch.bind(this);
    this.handleAccountHover = this.handleAccountHover.bind(this);
    this.handleAccountLeave = this.handleAccountLeave.bind(this);
    this.handleLogout = this.handleLogout.bind(this);
  }

  handleSearchChange(event) {
    this.setState({
      search: event.target.value,
    });
  }

  handleSearch(event) {
    event.preventDefault();
  }

  handleAccountHover(event) {
    this.setState({
      showAcMenu: true,
    });
  }
  handleAccountLeave(event) {
    this.setState({
      showAcMenu: false,
    });
  }

  handleLogout(event) {
    this.setState({
      loggedIn: false,
    });
    localStorage.removeItem("seller_sess_token");
    localStorage.removeItem("sid");
    localStorage.removeItem("sname");
  }

  render() {
    return (
        <div className="">
            <div className="sidebar-wrapper bg-right border-right">
                <div className="sidebar-heading"> TEST HEADING </div>
                <div className="list-group list-group-flush">
                    <a href="http://google.com" className="list-group-item list-group-item-action bg-light">1</a>
                    <a href="http://google.com" className="list-group-item list-group-item-action bg-light">1</a>

                    <a href="http://google.com" className="list-group-item list-group-item-action bg-light">1</a>

                    <a href="http://google.com" className="list-group-item list-group-item-action bg-light">1</a>

                    <a href="http://google.com" className="list-group-item list-group-item-action bg-light">1</a>

                </div>
            </div>
        </div>
    );
  }
}

export default DashBoardHeader;
