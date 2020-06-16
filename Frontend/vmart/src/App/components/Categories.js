import React, { Component } from "react";
import { BACKEND_URL } from "../config/Config";
import axios from "axios";
import renderHTML from "react-render-html";

export default class Categories extends Component {
  constructor(props) {
    super(props);

    this.state = {
      catIDs: [],
      catNames:[],
      catpicURLs: [],
      promiseIsResolved:false,
    };

    this.getCategories = this.getCategories.bind(this);
    this.catView = this.catView.bind(this);
  }

  componentDidMount(){
    this.getCategories()
  }

  catView() {
    var retView = '';
    retView += (
      '<table className="categoryhome_table">'
      +'<tr>');
      for(var i=0;i<this.state.catIDs.length;i++)
      {
        retView+=('<td><a href=/products/'+this.state.catIDs[i]+'/'+encodeURI(this.state.catNames[i])+'><img src='+this.state.catpicURLs[i]+'></a></td>');  
        if((i+1)%3===0)
            {
                retView+=('</tr><tr>');
            }
      }
        retView+=('</tr>');
        retView+=('</table>');
    return retView;
  }

  getCategories() {
    if (!this.state.promiseIsResolved) {
      axios
        .get(BACKEND_URL + `/allCategory`)
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
        response.data.message === "no_categories_found"
      ) {
        console.log("categories not found");
      } else if (
        response.data.status === "success" &&
        response.data.message === "categories_found"
      ) {
        for (var i = 0; i < response.data.categories.length; i++) {
          console.log(response.data.categories[i].catName);
          this.setState({
            catIDs: [...this.state.catIDs, response.data.categories[i].catid],
            catpicURLs: [
              ...this.state.catpicURLs,
              response.data.categories[i].picUrl,
            ],
            catNames: [
              ...this.state.catNames,
              response.data.categories[i].catName,
            ],
          });
        }
        this.setState({
            ...this.state,
            promiseIsResolved:true
        });
      }
    }
  }

  render() {
      if(!this.state.promiseIsResolved)
      {
          return null;
      }
      else
      {
        return (
            <div className="Categories">
              <label className="blackHeadlbl">#Shop Top Categories</label>
              <br /><br/>
              {renderHTML(this.catView())}
            </div>
          );
      }    
  }
}
