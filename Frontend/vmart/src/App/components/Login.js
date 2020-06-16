import React from "react";
import { Helmet } from "react-helmet";
import "../../Assects/css/main.css";
import logo from "../../Assects//img//vmart-logo.png";
import { BACKEND_URL,makeid } from "../config/Config";
import axios from "axios";
import { Redirect } from "react-router-dom";

class Login extends React.Component {
  constructor(props) {
    super(props);
    const sess_token=localStorage.getItem("session_token");
    let loggedIn=true;
    if(sess_token==null)
    {
      loggedIn=false;
    }
    this.state = {
      email: "",
      password: "",
      loggedIn
    };
  }

  validation() {
    var flag = true;
    if (this.state.email === "") {
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

  handleEmailChange = (event) => {
    this.setState({
      email: event.target.value,
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
      this.login_user();
    }
  };

  login_user() {
    axios
      .post(
        BACKEND_URL +
          `/login?email=${this.state.email}&password=${this.state.password}`
      )
      .then((response) => {
        this.responseController(response);
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
          localStorage.setItem("session_token",makeid(15));
          localStorage.setItem("uid",response.data.uid);
          localStorage.setItem("name",response.data.name);
          this.setState({
            loggedIn:true
          })
        } else {
          this.errormsg("err_email", "Invalid credential");
          this.errormsg("err_password", "Invalid credential");
        }
      }
    }
  }

  render() {
    if(this.state.loggedIn)
    {
      return <Redirect to="/"/>
    }
    return (
      <div className="Login">
        <Helmet>
          <title>VMart Login</title>
        </Helmet>
        <div className="head">
          <img className="head_logo" src={logo} alt="Logo" />
        </div>
        <div className="form_container">
          <div className="form_head">Login</div>
          <br />
          <form onSubmit={this.handleSubmit}>
            <label className="form">
              <b>Email</b>
            </label>
            <br />
            <input
              className="form_ed"
              type="email"
              onKeyDown={this.txt_tracker}
              maxLength="64"
              name="email"
              id="email"
              value={this.state.email}
              onChange={this.handleEmailChange}
            />
            <br />
            <label className="form_error" id="err_email"></label>
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
            Don't have an account?{" "}
            <a className="emphasis_link" href="signup">
              Sign Up
            </a>
          </label>
        </div>
      </div>
    );
  }
}

export default Login;
