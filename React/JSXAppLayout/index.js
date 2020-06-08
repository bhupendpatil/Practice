class App extends React.Component{
    render(){
        return (
            <div>
                <Hello/>
                <NumPicker/>
            </div>
        );
    }
}

ReactDOM.render(<App/>,document.getElementById("root"));