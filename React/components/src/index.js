import React from "react";
import ReactDOM from "react-dom";
import CommentDetail from "./CommentDetail";

const App = () => {
  return (
    <div className="ui container comments">
      <CommentDetail author="Bhupend" />
      <CommentDetail author="Harshad" />
      <CommentDetail author="Hitesh" />
      <CommentDetail author="None" />
    </div>
  );
};

ReactDOM.render(<App />, document.querySelector("#root"));
