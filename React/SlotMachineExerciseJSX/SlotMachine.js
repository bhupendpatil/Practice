class SlotMachine extends React.Component {
    render(){
        let s1 = this.props.s1;
        let s2 = this.props.s2;
        let s3 = this.props.s3;
        let text = "";
        if (s1 == s2 && s2 == s3){
            text = "You win!";
        } else {
            text = "You lose!";
        }
        return (
            <div>
                <p>{s1} {s2} {s3}</p>
                <p>{text}</p>
            </div>
        );
    }
}