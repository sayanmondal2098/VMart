import React from "react";

class Footer extends React.Component {
  constructor(props) {
    super(props);
    const sess_token = localStorage.getItem("session_token");
    let loggedIn = true;
    if (sess_token == null) {
      loggedIn = false;
    }
    this.state = {
      loggedIn,
    };
  }

  render() {
    return (
      <div className="Footer">
        <div className="foot_list_container">
          <label className="tab">Get to Know Us</label>
          <ul className="foot_list">
            <li className="foot_normal_lbl">About Us</li>
            <li className="foot_normal_lbl">Careers</li>
            <li className="foot_normal_lbl">Press Releases</li>
          </ul>
        </div>
        <div className="foot_list_container">
          <label className="tab">Connect with Us</label>
          <ul className="foot_list">
            <li className="foot_normal_lbl">Facebook</li>
            <li className="foot_normal_lbl">Instagram</li>
            <li className="foot_normal_lbl">Twitter</li>
          </ul>
        </div>
        <div className="foot_list_container">
          <label className="tab">Mail Us:</label>
          <br />
          <label className="foot_normal_lbl">
            VMart Internet Private Limited,
            <br />
            Buildings Alyssa, Begonia &<br />
            Clove Embassy Tech Village,
            <br />
            Outer Ring Road,
            <br />
            Devarabeesanahalli Village, Bengaluru, 560103,
            <br />
            Karnataka, India
          </label>
        </div>
        <div className="foot_list_container">
          <label className="tab">Registered Office Address:</label>
          <br />
          <label className="foot_normal_lbl">
            VMart Internet Private Limited,
            <br />
            Buildings Alyssa, Begonia &<br />
            Clove Embassy Tech Village,
            <br />
            Outer Ring Road,
            <br />
            Devarabeesanahalli Village, Bengaluru, 560103,
            <br />
            Karnataka, India
            <br />
            CIN : U51109KA2012PTC066107
            <br />
            Telephone: 1800 208 9898
          </label>
        </div>
        <br />
        <label className="foot_copyright">© 2019-2020 Vmart.com</label>
      </div>
    );
  }
}

export default Footer;
