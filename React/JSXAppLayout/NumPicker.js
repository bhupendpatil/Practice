function getNum() {
    return Math.floor(Math.random() * 10) + 1;
}

class NumPicker extends React.Component {
    render() {
        const num = getNum();
        let msg;
        if (num === 7) {
            msg = <div>
                <h2>Congrats you win!</h2>
                <img src="https://media.giphy.com/media/8YvrPkSANkqLZzTzeD/giphy.gif"/>
            </div>
        } else {
            msg = <h1>Bad!!!!</h1>
        }
        return (
            <div>
                <h1>Your number is: {num}</h1>
                <p>{num === 7 ? 'Congrats!' : 'Bye!'}</p>
                {num === 7 && <img src="https://media.giphy.com/media/26BGpAHdn5W4iVJD2/giphy.gif" />}
                {msg}
            </div>
        )
    }
}
