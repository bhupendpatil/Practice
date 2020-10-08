import React from "react";
import ReactDOM from "react-dom";

const App = () => {
  return (
    <div>
      <Segment>
        <div className="ui icon header">
          <i className="pdf file outline icon"></i>
          No documents are listed.
        </div>
        <div className="ui primary button">Add Document</div>
      </Segment>
      <Segment>
        <h4 className="ui header">For your information</h4>
        <p>
          Adadaindac ac abwhabd iag awydya dyag dauawdayug ag augdyu aydg auygd
          auyg dag ydg yg uyag dyagw yda ygayu yuag ag a aw .a diuab awagaywgayw
          y awda .a a a a hauw hahwiu hawu . auwhdiuahw uhawd hiuahwid uhaih
          iuahi
        </p>
      </Segment>
    </div>
  );
};

const Segment = (props) => {
  return <div className="ui placeholder segment">{props.children}</div>;
};

ReactDOM.render(<App />, document.querySelector("#root"));
