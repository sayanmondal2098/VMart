import React from "react";
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import AppBar from '@material-ui/core/AppBar';
import Button from '@material-ui/core/Button';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import ReactTable from 'react-table-6';
import 'react-table-6/react-table.css';
import SellerLogin from './SellerLogin'

// import { ReactMUIDatatable } from "react-material-ui-datatable";


import "../../../Assects/css/DashBoaed.css";
import { BACKEND_URL } from "../../config/Config";
import { Redirect } from "react-router-dom";
import Axios from "axios";



class SellerDashBoard extends React.Component {
  constructor(props) {
    super(props);
    const seller_sess_token = localStorage.getItem("seller_sess_token");
    let sloggedIn = true;
    if (seller_sess_token == null) {
      sloggedIn = false;
    }
    this.state = {
      SellesData: [],
      totalItems:"",
      sloggedIn
    };
    this.handleLogout = this.handleLogout.bind(this);
    this.apicall = this.apicall.bind(this);

  }

  apicall(){
    Axios.post(BACKEND_URL+`/SellergetAllProducts?sellerName=`+localStorage.getItem("sname"))
    // .then(response => response.json())
    // .then(data => console.log((data.data)))
    .then(res =>{
      var cat = res['data']['products']
      var ml = cat.length
      console.log(ml)
      this.setState({
        tatalItems : ml
      })
    })
    // .then(this.setState({
    //   totalItems : data.length
    // }))
    
  }

  componentDidMount() {
    if (localStorage.getItem("sid")==null) {
      return SellerLogin
    }
    const url = BACKEND_URL + `/`;
    this.apicall()
    fetch(url, {
      method: "POST",
    }).then(response => response.json())
    // .then(this.apicall())
      .then(data =>
        this.setState({
          posts: data,
        }, console.log(data)),
        console.log("Seller Id"),
        console.log(localStorage.getItem("sid") + " ~test~ " + localStorage.getItem("sname")),
        console.log(this.state.totalItems)
      )
  }

  handleLogout(event) {
    localStorage.removeItem("seller_session_token")
    localStorage.removeItem("sid");
    localStorage.removeItem("sname");

    this.setState({
      sloggedIn: false,
    });

  }



  render() {
    const sellsData = [{
      Header: 'userId',
      accessor: 'userId'
    }, {
      Header: 'id',
      accessor: 'id'
    },
    {
      Header: 'title',
      accessor: 'title'
    },
    {
      Header: 'body',
      accessor: 'body'
    }
    ]
    return (
      <div>
        <AppBar>
          <Toolbar>
            <Typography variant="h6">Seller Dashboard</Typography>
            <div className="menubar-buttons right-align">
              <Grid container alignContent={"center"} spacing={15}>
                <Button variant="contained" color="primary" href="/SellerAddProduct">
                  Add Products
              </Button>
                <Button variant="contained" color="secondary" onClick={this.handleLogout} href="/">
                  Log Out
              </Button>
              </Grid>
            </div>
          </Toolbar>
        </AppBar>
        <div className="root">
          <div className="summary-box-heading">Account OverView</div>
          <Grid container spacing={5}>
            <Grid item xs={"auto"}>
              <Paper className="paper summary-box revenue-box">
                <div className="revenue-box">
                  <div className="overviewBoxHeading">
                    Total Revenue
                  </div>
                  <div className="overviewValue">
                    Rs. 1000
                  </div>
                  <div>
                    <Grid container spacing={3}>
                      <Grid item={"auto"}>
                        <div className="revenue-box-infoDiv">
                          <Paper className="paper gridSmallInfoBox revenue-box-info">
                            <div className="revenue-box-info">
                              <div>1</div>
                            </div>
                          </Paper>
                        </div>
                      </Grid>

                      <Grid item={"auto"}>
                        <div className="revenue-box-infoDiv">
                          <Paper className="paper gridSmallInfoBox revenue-box-info">
                            <div className="revenue-box-info">
                              <div>1</div>
                            </div>
                          </Paper>
                        </div>
                      </Grid>

                      <Grid item={"auto"}>
                        <div className="revenue-box-infoDiv">
                          <Paper className="paper gridSmallInfoBox revenue-box-info">
                            <div className="revenue-box-info">
                              <div>1</div>
                            </div>
                          </Paper>
                        </div>
                      </Grid>

                    </Grid>
                  </div>
                </div>

              </Paper>
            </Grid>
            <Grid item xs={"auto"}>
              <Paper className="paper summary-box selling-box">
                <div className="revenue-box">
                  <div className="overviewBoxHeading">
                    Total Product 
                  </div>
                  <div className="overviewValue">
                    {this.state.totalItems}
                  </div>
                  <div>
                    <Grid container spacing={3}>
                      <Grid item={"auto"}>
                        <div className="revenue-box-infoDiv">
                          <Paper className="paper gridSmallInfoBox revenue-box-info">
                            <div className="revenue-box-info">
                              <div>1</div>
                            </div>
                          </Paper>
                        </div>
                      </Grid>

                      <Grid item={"auto"}>
                        <div className="revenue-box-infoDiv">
                          <Paper className="paper gridSmallInfoBox revenue-box-info">
                            <div className="revenue-box-info">
                              <div>1</div>
                            </div>
                          </Paper>
                        </div>
                      </Grid>

                      <Grid item={"auto"}>
                        <div className="revenue-box-infoDiv">
                          <Paper className="paper gridSmallInfoBox revenue-box-info">
                            <div className="revenue-box-info">
                              <div>1</div>
                            </div>
                          </Paper>
                        </div>
                      </Grid>

                    </Grid>
                  </div>
                </div>

              </Paper>
            </Grid>
            <Grid item xs={"auto"}>
              <Paper className="paper summary-box cart-box">
                <div className="cart-box">
                  <div className="overviewBoxHeading">
                    Total Revenue
                  </div>
                  <div className="overviewValue">
                    Rs. 1000
                  </div>
                  <div>
                    <Grid container spacing={3}>
                      <Grid item={"auto"}>
                        <div className="revenue-box-infoDiv">
                          <Paper className="paper gridSmallInfoBox revenue-box-info">
                            <div className="revenue-box-info">
                              <div>1</div>
                            </div>
                          </Paper>
                        </div>
                      </Grid>

                      <Grid item={"auto"}>
                        <div className="revenue-box-infoDiv">
                          <Paper className="paper gridSmallInfoBox revenue-box-info">
                            <div className="revenue-box-info">
                              <div>1</div>
                            </div>
                          </Paper>
                        </div>
                      </Grid>

                      <Grid item={"auto"}>
                        <div className="revenue-box-infoDiv">
                          <Paper className="paper gridSmallInfoBox revenue-box-info">
                            <div className="revenue-box-info">
                              <div>1</div>
                            </div>
                          </Paper>
                        </div>
                      </Grid>

                    </Grid>
                  </div>
                </div>

              </Paper>
            </Grid>
            <Grid item xs={"auto"}>
              <Paper className="paper summary-box monthlyOverview-box">
                <div className="monthlyOverview-box">
                  <div className="overviewBoxHeading">
                    Total Revenue
                  </div>
                  <div className="overviewValue">
                    Rs. 1000
                  </div>
                  <div>
                    <Grid container spacing={3}>
                      <Grid item={"auto"}>
                        <div className="revenue-box-infoDiv">
                          <Paper className="paper gridSmallInfoBox revenue-box-info">
                            <div className="revenue-box-info">
                              <div>1</div>
                            </div>
                          </Paper>
                        </div>
                      </Grid>

                      <Grid item={"auto"}>
                        <div className="revenue-box-infoDiv">
                          <Paper className="paper gridSmallInfoBox revenue-box-info">
                            <div className="revenue-box-info">
                              <div>1</div>
                            </div>
                          </Paper>
                        </div>
                      </Grid>

                      <Grid item={"auto"}>
                        <div className="revenue-box-infoDiv">
                          <Paper className="paper gridSmallInfoBox revenue-box-info">
                            <div className="revenue-box-info">
                              <div>1</div>
                            </div>
                          </Paper>
                        </div>
                      </Grid>

                    </Grid>
                  </div>
                </div>

              </Paper>
            </Grid>
          </Grid>

          {/* <div>
            <div className="sellsgraph-box-heading">
              Sells Graph
            </div>
            <Grid container alignContent="center" spacing={5}>
              <Grid item xs={5}>
                <Paper className="paper">xs=6</Paper>
              </Grid>
              <Grid item xs={5}>
                <Paper className="paper">xs=6</Paper>
              </Grid>
            </Grid>
          </div> */}

          <div className="">
            <Grid item xs={10}>
              <div className="transaction-box-heading">
                Transaction Details and Status
              </div>
              <Paper className="paper">
                <div className="container">
                  <ReactTable
                    columns={sellsData}
                    data={this.state.posts} >

                  </ReactTable>
                </div>
              </Paper>
            </Grid>
          </div>

        </div>
      </div>
    )
  }
}

export default SellerDashBoard;