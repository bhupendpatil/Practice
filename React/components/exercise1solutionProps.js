import React from "react";
import ReactDOM from "react-dom";

const Message = (props) => {
  return (
    <div className="ui message">
      <div className="header">{props.header}</div>
      <p>{props.text}</p>
    </div>
  );
};

const App = () => {
  return (
    <div>
      <Message
        header="Changes in Service"
        text="We just updated our privacy policy here to better service our customers."
      />
    </div>
  );
};

ReactDOM.render(<App />, document.querySelector("#root"));
