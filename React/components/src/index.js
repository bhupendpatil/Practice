import React from "react";
import ReactDOM from "react-dom";
import CommentDetail from "./CommentDetail";
import ApprovalCard from "./ApprovalCard";
import faker from "faker";

const App = () => {
  return (
    <div className="ui container comments">
      <ApprovalCard />
      <CommentDetail
        author="Bhupend"
        timeAgo="Today at 4:45PM"
        content="Nice blog!"
        avatar={faker.image.avatar()}
      />
      <CommentDetail
        author="Harshad"
        timeAgo="Today at 2:00AM"
        content="Good one!"
        avatar={faker.image.avatar()}
      />
      <CommentDetail
        author="Hitesh"
        timeAgo="Yesterday at 5:00PM"
        content="Nice"
        avatar={faker.image.avatar()}
      />
      <CommentDetail
        author="None"
        timeAgo="Yesterday at 4:45PM"
        content="woww!!"
        avatar={faker.image.avatar()}
      />
    </div>
  );
};

ReactDOM.render(<App />, document.querySelector("#root"));
