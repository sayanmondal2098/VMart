// import React, { Component } from "react";
import React from "react";
import { Helmet } from "react-helmet";
import axios from "axios";
import { Redirect } from "react-router-dom";
import { BACKEND_URL,makeid } from "../config/Config";
import "../../Assects/css/main.css";
import logo from "../../Assects//img//vmart-logo.png";



class Signup extends React.Component {
  constructor(props) {
    super(props);
    const sess_token=localStorage.getItem("session_token");
    let loggedIn=true;
    if(sess_token==null)
    {
      loggedIn=false;
    }
    this.state = {
      name: "",
      email: "",
      password: "",
      repassword: "",
      loggedIn         
    };
  }

  validation() {
    var flag = true;
    if (this.state.name === "") {
      this.errormsg("err_name", "Enter name");
      flag = false;
    }
    if (this.state.email === "") {
      this.errormsg("err_email", "Enter email");
      flag = false;
    }
    if (this.state.password === "") {
      this.errormsg("err_password", "Enter password");
      flag = false;
    } else if (this.state.password.length < 6) {
      this.errormsg("err_password", "Password too small");
      flag = false;
    }
    if (this.state.repassword !== this.state.password) {
      this.errormsg("err_repassword", "Password doesn't match");
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

  handleRepasswordChange = (event) => {
    this.setState({
      repassword: event.target.value,
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    if (this.validation()) {
      // alert("Ready for form submission");
      this.register_user();
      console.log("Ready for form submission");
    } else {
      alert("Not ready for form submission");
    }
  };

  register_user() {
    axios
      .post(
        BACKEND_URL +
          `/register?name=${this.state.name}&email=${this.state.email}&password=${this.state.password}`
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
      if (response.data.existence_check === "found") {
        this.errormsg("err_email", "Email already in use");
      } else {
        if (response.data.registration_status === "successful") {
          localStorage.setItem("session_token",makeid(15));
          localStorage.setItem("uid",response.data.uid);
          localStorage.setItem("name",response.data.name);
          this.setState({
            loggedIn:true
          })
        } else {
          alert("User not registered");
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
      <div className="Signup">
        <Helmet>
          <title>VMart Registration</title>
        </Helmet>
        <div className="head">
          <img className="head_logo" src={logo} alt="Logo" />
        </div>
        <div className="form_container">
          <div className="form_head">Create Account</div>
          <br />
          <form onSubmit={this.handleSubmit}>
            <label className="form">
              <b>Your name</b>
            </label>
            <br />
            <input
              className="form_ed"
              type="text"
              onKeyDown={this.txt_tracker}
              maxLength="50"
              name="name"
              id="name"
              value={this.state.name}
              onChange={this.handleNameChange}
            />
            <br />
            <label className="form_error" id="err_name"></label>
            <br />
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
              maxLength="32"
              name="password"
              id="password"
              value={this.state.password}
              onChange={this.handlePasswordChange}
              placeholder="At least 6 characters"
            />
            <br />
            <label className="form_error" id="err_password"></label>
            <br />
            <label className="form">
              <b>Re-enter Password</b>
            </label>
            <br />
            <input
              className="form_ed"
              maxLength="32"
              onKeyDown={this.txt_tracker}
              type="password"
              name="repassword"
              id="repassword"
              value={this.state.repassword}
              onChange={this.handleRepasswordChange}
            />
            <br />
            <label className="form_error" id="err_repassword"></label>
            <br />
            <input className="form_btn" type="submit" value="Continue" />
          </form>
          <br />
          <br />
          <label className="form">
            Already have an account?{" "}
            <a className="emphasis_link" href="login">
              Sign in
            </a>
          </label>
        </div>
      </div>
    );
  }
}

export default Signup;
