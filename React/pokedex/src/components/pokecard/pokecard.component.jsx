import React from "react";

import "./pokecard.styles.scss";

class Pokecard extends React.Component {
  padToThree = (number) => (number <= 999 ? `00${number}`.slice(-3) : number);
  render() {
    return (
      <div className="pokecard">
        <h1 className="poke-title">{this.props.name}</h1>
        <div className="poke-image">
          <img
            className="character-image"
            alt={this.props.name}
            src={`https://assets.pokemon.com/assets/cms2/img/pokedex/detail/${this.padToThree(
              this.props.id
            )}.png`}
          />
        </div>
        <div className="poke-data">Type: {this.props.type}</div>
        <div className="poke-data">EXP: {this.props.exp}</div>
      </div>
    );
  }
}

export default Pokecard;
