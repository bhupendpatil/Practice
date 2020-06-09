class App extends React.Component {
    render() {
        return (
            <div>
                <Hello
                    to="Bhupend"
                />
                <Hello
                    to="Bhupend"
                    from="Someone"
                    bangs={4}
                    img="https://images.unsplash.com/photo-1588774210246-a1dc467758df?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=667&q=80"
                />
            </div>
        );
    }
}

ReactDOM.render(<App />, document.getElementById('root'));