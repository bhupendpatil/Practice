class App extends React.Component {
    render() {
        return (
            <div>
                <Friend
                    name = "Bhupend"
                    hobbies = {["Coding","Playing","Boating"]}
                />
            </div>
        );
    }
}

ReactDOM.render(<App />, document.getElementById('root'));