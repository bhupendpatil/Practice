import React from "react";
import ReactDOM from "react-dom";

class Clock extends React.Component {
  state = { time: "" };
  componentDidMount() {
    setInterval(() => {
      this.setState({ time: new Date().toLocaleTimeString() });
    }, 1000);
  }

  render() {
    return <div>The time is: {this.state.time}</div>;
  }
}

ReactDOM.render(<Clock />, document.querySelector("#root"));
