import React from "react";
import logo from "../../Assects/img/vmart-logo.png";
import briefcase from "../../Assects/img/briefcase-icon.ico";
import cart from "../../Assects/img/cart-icon.ico";
import logout from "../../Assects/img/logout-icon.ico";

class Header extends React.Component {
  constructor(props) {
    super(props);
    const sess_token = localStorage.getItem("session_token");
    let loggedIn = true;
    if (sess_token == null) {
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
    localStorage.removeItem("session_token");
    localStorage.removeItem("uid");
    localStorage.removeItem("name");
  }

  render() {
    let button, signout;
    if (!this.state.loggedIn) {
      button = (
        <a href="/login">
          <button className="btn_login" type="button">
            Login
          </button>
        </a>
      );
      signout = null;
    } else {
      button = (
        <label
          className="tab"
          onMouseOver={this.handleAccountHover}
          onMouseLeave={this.handleAccountLeave}
        >
          {this.state.customerName}
        </label>
      );
      signout = (
        <div className="head_tab" id="logout" onClick={this.handleLogout}>
          <label className="tab">
            <img className="inline" src={logout} alt="logoutIcon" />
            Logout
          </label>
        </div>
      );
    }
    return (
      <div className="Header">
        <a href="/"><img className="header_logo" src={logo} alt="Logo" /></a>
        <form className="search_form" onSubmit={this.handleSearch}>
          <input
            className="search_ed"
            type="text"
            maxLength="64"
            name="search"
            id="search"
            placeholder="Search for products, brands and more"
            value={this.state.search}
            onChange={this.handleSearchChange}
          />
        </form>
        <div className="head_tab" id="seller">
          {button}

          <a href="/SellerLogin">
          <label className="tab">
            <img className="inline" src={briefcase} alt="sellIcon" />
            Sell on VMart
          </label>
          </a>
        </div>
        <div className="head_tab" id="cart">
          <label className="tab">
            <img className="inline" src={cart} alt="cartIcon" />
            Cart(0)
          </label>
        </div>
        {signout}
      </div>
    );
  }
}

export default Header;
