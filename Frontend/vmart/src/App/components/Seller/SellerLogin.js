import React from "react";
import { Helmet } from "react-helmet";
import "../../../Assects/css/main.css";
import logo from "../..//..//Assects//img//vmart-logo.png";
import { SELLER_LOGIN_URL,makeid } from "../../config/Config";
import axios from "axios";
import { Redirect } from "react-router-dom";

class SellerLogin extends React.Component {
  constructor(props) {
    super(props);
    const seller_sess_token=localStorage.getItem("seller_sess_token");
    let sloggedIn=true;
    if(seller_sess_token==null)
    {
      sloggedIn=false;
    }
    this.state = {
      name: "",
      password: "",
      sloggedIn
    };
  }

  validation() {
    var flag = true;
    if (this.state.name === "") {
      this.errormsg("err_email", "Enter email");
      flag = false;
    }
    if (this.state.password === "") {
      this.errormsg("err_password", "Enter password");
      flag = false;
    }
    return flag;
  }

  errormsg(getElementByIdName, warningMessage) {
    var variableName = document.getElementById(getElementByIdName);
    variableName.style.display = "block";
    variableName.innerHTML = warningMessage;
  }

  txt_tracker(event) {
    document.getElementById("err_" + event.target.id).style.display = "none";
  }

  handleNameChange = (event) => {
    this.setState({
      name: event.target.value,
    });
  };

  handlePasswordChange = (event) => {
    this.setState({
      password: event.target.value,
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    if (this.validation()) {
      this.login_seller();
    }
  };

  login_seller() {
    axios
      .post(
        SELLER_LOGIN_URL +
          `name=${this.state.name}&password=${this.state.password}`
      )
      .then((response) => {
        this.responseController(response);
        // console.log(response);  
      })
      .catch((error) => {
        console.log(error);
      });
  }

  responseController(response) {
    if (response.status === 200) {
      if (response.data.existence_check === "not_found") {
        this.errormsg("err_email", "Email does not exist. Sign Up first");
      } else {
        if (response.data.login_status === "successful") {
          localStorage.setItem("seller_session_token",makeid(15));
          localStorage.setItem("sid",response.data.sid);
          localStorage.setItem("sname",response.data.name);
          this.setState({
            sloggedIn:true
          })
        } else {
          this.errormsg("err_name", "Invalid credential");
          this.errormsg("err_password", "Invalid credential");
        }
      }
    }
  }

  render() {
    if(this.state.sloggedIn)
    {
      return <Redirect to="/SellerDashBoard"/>
    }
    return (
      <div className="Login">
        <Helmet>
          <title>VMart Seller Login</title>
        </Helmet>
        <div className="head">
          <img className="head_logo" src={logo} alt="Logo" />
        </div>
        <div className="form_container">
          <div className="form_head">Seller Login</div>
          <br />
          <form onSubmit={this.handleSubmit}>
            <label className="form">
              <b>Seller Name</b>
            </label>
            <br />
            <input
              className="form_ed"
              type="name"
              onKeyDown={this.txt_tracker}
              maxLength="64"
              name="name"
              id="name"
              value={this.state.name}
              onChange={this.handleNameChange}
            />
            <br />
            <label className="form_error" id="err_name"></label>
            <br />
            <label className="form">
              <b>Password</b>
            </label>
            <br />
            <input
              className="form_ed"
              type="password"
              onKeyDown={this.txt_tracker}
              maxLength="1024"
              name="password"
              id="password"
              value={this.state.password}
              onChange={this.handlePasswordChange}
            />
            <br />
            <label className="form_error" id="err_password"></label>
            <br />
            <input className="form_btn" type="submit" value="Continue" />
          </form>
          <br />
          <br />
          <label className="form">
            Don't have a Seller account?{" "}
            <a className="emphasis_link" href="sellerRegister">
              Sign Up
            </a>
          </label>
        </div>
      </div>
    );
  }
}

export default SellerLogin;
