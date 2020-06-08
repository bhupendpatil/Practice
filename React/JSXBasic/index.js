class JSXDemo extends React.Component {
    render(){
        return(
            <div>
                <h1>Image</h1>
                <img src="https://images.unsplash.com/photo-1591465182022-d34cf0e924a5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80"/>
            </div>
        )
    }
}

ReactDOM.render(<JSXDemo/>,document.getElementById('root'));