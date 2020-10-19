import React from "react";
import ReactDOM from "react-dom";

class Clockk extends React.Component {
  state = { time: new Date().toLocaleTimeString() };
  componentDidMount() {
    setInterval(() => {
      this.setState({ time: new Date().toLocaleTimeString() });
    }, 1000);
  }

  render() {
    return <div>The time is: {this.state.time}</div>;
  }
}

ReactDOM.render(<Clockk />, document.querySelector("#root"));
