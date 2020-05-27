import React from "react";

import { Helmet } from "react-helmet";
import logo from "../..//..//Assects//img//vmart-logo.png";
import { BACKEND_URL } from "../../config/Config";
import Dropdown from 'react-dropdown';
import 'react-dropdown/style.css';
import axios from "axios";




class SellerAddProduct extends React.Component {
  constructor(props) {
    super(props);
    const seller_sess_token = localStorage.getItem("seller_sess_token");
    // let catName = []
    let loggedIn = true;
    if (seller_sess_token == null) {
      loggedIn = false;
    }
    this.state = {
      name: "",
      price : "",
      sellername: localStorage.getItem("sname"),
      descreption:"",
      catName: [],
      categories:"",
      discount:[],
      percentage:"",
      specefecation: "",
      piclist: "",
      loggedIn
    };
    // this.catRender = this.catRender.bind(this);

  }

  handleProductNameChange = (event) => {
    this.setState({
      name: event.target.value,
    });
  };


  handlePriceChange = (event) => {
    this.setState({
      price: event.target.value,
    });
  };

  handleProductDescreptionChange = (event) => {
    this.setState({
      descreption: event.target.value,
    });
  };

  handleCategoryChange = (event) => {
    this.setState({
      percentage: event.target.value,
    });
  };

  handleProductpercentageChange = (event) => {
    this.setState({
      percentage: event.target.value,
    });
  };

  handleProductspecefecationChange = (event) => {
    this.setState({
      specefecation : event.target.value,
    });
  };

  handlePiclistChange = (event) => {
    this.setState({
      piclist : event.target.value,
    });
  };



  getallcategory(){
    const list = []
    axios.get(BACKEND_URL+ `/allCategory`)
    .then((res)=> {
      var cat = res['data']['categories']
      var catlen = cat.length
    for (let index = 0; index < catlen; index++) {
      const element = cat[index]["catName"];
      list.push(element)
      this.state.catName.push(element)
    }
      return list
    }
    )
    .catch((e)=>{
      console.log(e)
    })
}

getalldiscount(){
  const list = []
  axios.get(BACKEND_URL+ `/all_discounts`)
  .then((res)=> {
    console.log(res)
    var dis = res['data']['discounts']
    var dislen = dis.length
  for (let index = 0; index < dislen; index++) {
    const element = dis[index]["discount getPercentage"];
    list.push(element)
    this.state.discount.push(element)
  } 
    console.log(list)
    return list
  }
  )
  .catch((e)=>{
    console.log(e)
  })
}

// catRender(){
//   var catView = '';
//   catView += (
//     '<select>');
//     for (let index = 0; index < this.state.catName.length; index++) {
//       console.log(index)
//       catView += '<option value='+this.state.catName[index]+'>'+this.state.catName[index]+'</option> </br>'
//     }
//     catView += ('</select>')
//     return catView;
// }


componentDidMount(){
  this.getalldiscount()
  this.getallcategory()
  console.log(this.state.catName)
  console.log(this.state.discount)
}


  addProduct(){
    axios
      .post(BACKEND_URL + `/SellerAddProduct?name=${this.state.name}&price=${this.state.price}&sellername=${this.state.sellername}`+
                  `&descreption=${this.state.descreption}&catName=${this.state.categories}&percentage=${this.state.percentage}`+
                  `&specification=${this.state.specefecation}&piclist=${this.state.piclist}`)
  }


  handleSubmit = (e) => {
    e.preventDefault();
    // alert('cat' + this.state.catName)
    // alert('desc' + this.state.descreption)
    // alert('discount ' + this.state.discount)
    // // alert('perst' + this.state.percentage)
    // alert('spec' + this.state.specefecation)
    // alert('name' + this.state.name)
    // alert('prics' + this.state.price)
    // alert('categories' + this.state.categories)
    // alert('cat' + this.state.categories)
    this.addProduct()
    alert('product added successfully ')
  }

  render(){

    return(
      <div className="Login">
        <Helmet>
          <title>VMart Seller AddProducts</title>
        </Helmet>
        <div className="head">
          <img className="head_logo" src={logo} alt="Logo" />
        </div>
        <div className="form_container">
          <div className="form_head">Seller Add Product</div>
          <br />
          <form onSubmit={this.handleSubmit}>
            <label className="form">
              <b>Product Name</b>
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
              onChange={this.handleProductNameChange}
            />
            <br />
            <label className="form_error" id="err_name"></label>
            <br />
            <label className="form">
              <b>Price</b>
            </label>
            <br />
            <input
              className="form_ed"
              type="name"
              onKeyDown={this.txt_tracker}
              maxLength="24"
              name="price"
              id="price"
              value={this.state.price}
              onChange={this.handlePriceChange}
            />
            <br />
            
            <label className="form_error" id="err_name"></label>
            <br />
            <label className="form">
              <b>Descreption</b>
            </label>
            <br />
            <input
              className="form_ed"
              type="text"
              onKeyDown={this.txt_tracker}
              maxLength="1024"
              name="descreption"
              id="password"
              value={this.state.descreption}
              onChange={this.handleProductDescreptionChange}
            />
            <br />
            <label className="form_error" id="err_name"></label>
            <br />
            <label className="form">
              <b>Catarory Name </b>
            </label>
            <br />

            <Dropdown options={this.state.catName} onChange={(values)=>this.setState({categories:values.value})} placeholder="Select an option" value={this.state.categories}/>
            
            <br />
            <label className="form_error" id="err_name"></label>
            <br />
            <label className="form">
              <b>Discount</b>
            </label>
            <br />
            <Dropdown options={this.state.discount} onChange={(values)=>this.setState({percentage:Number(values.value)})} placeholder="Select an discount" value={this.state.percentage}/>
            <br />
            <label className="form_error" id="err_name"></label>
            <br />
            <label className="form">
              <b>Specefecation</b>
            </label>
            <br />
            <input
              className="form_ed"
              type="test"
              onKeyDown={this.txt_tracker}
              maxLength="1024"
              name="Specefication"
              value={this.state.specefecation}
              onChange={this.handleProductspecefecationChange}
            />
            <br />
            <br />
            <label className="form_error" id="err_name"></label>
            <br />
            <label className="form">
              <b>PicList</b>
            </label>
            <br />
            <input
              className="form_ed"
              type="test"
              onKeyDown={this.txt_tracker}
              maxLength="1024"
              name="Piclist"
              placeholder="enter url in comma seperated values"
              value={this.state.piclist}
              onChange={this.handlePiclistChange}
            />
            <br />
            <label className="form_error" id="err_password"></label>
            <br />
            <input className="form_btn" type="submit" value="Continue" />
            
          </form>
          <button lassName="form_btn" href="/SellerDashBoard">Back</button>
          <br />
        </div>
      </div>
    )
  }


}

export default SellerAddProduct;