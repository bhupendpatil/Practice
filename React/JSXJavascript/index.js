function getMood(){
    const moods = ['Angry','Happy','Sad'];
    return moods[Math.floor(Math.random() * moods.length)];
}    

class JSXJavascript extends React.Component {
    render(){
        return(
        <h1>My Current Mood is: {getMood()}</h1>
        )
    }
}

ReactDOM.render(<JSXJavascript/>,document.getElementById('root'));