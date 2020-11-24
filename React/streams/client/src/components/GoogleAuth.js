import React from "react";

class GoogleAuth extends React.Component {
  componentDidMount() {
    window.gapi.load("client:auth2", () => {
      window.gapi.client.init({
        clientId:
          "376720544470-dvpgn4oelg7ta07v9smnr5kkh74c48uq.apps.googleusercontent.com #ignoreline",
        scope: "email",
      });
    });
  }
  render() {
    return <div>Google Auth</div>;
  }
}

export default GoogleAuth;
