import React from "react";
import Pokecard from "../pokecard/pokecard.component";

import "./pokedex.styles.scss";

class Pokedex extends React.Component {
  render() {
    let title;
    if (this.props.isWinner) {
      title = <h1 className="winner">Winning Hand</h1>;
    } else {
      title = <h1 className="looser">Looser Hand</h1>;
    }
    return (
      <div className="pokedex">
        {title}
        <h4>Total Experience: {this.props.exp}</h4>
        <div className="pokedex-card">
          {this.props.pokemon.map((detail) => (
            <Pokecard
              key={detail.id}
              id={detail.id}
              name={detail.name}
              type={detail.type}
              exp={detail.base_experience}
            />
          ))}
        </div>
      </div>
    );
  }
}

export default Pokedex;
