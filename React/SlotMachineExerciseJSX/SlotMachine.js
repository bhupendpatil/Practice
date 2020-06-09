class SlotMachine extends React.Component {
    render() {
        let { s1, s2, s3 } = this.props;
        let text = "";
        (s1 == s2 && s2 == s3) ? text = "You win!": text = "You lose!";
        
        return (
            <div className="MachineText">
                <p style={{ fontSize: '50px' }}>{s1} {s2} {s3}</p>
                <p className={ (s1 == s2 && s2 == s3) ? 'win' : 'lose'}>
                    {text}
                </p>
            </div>
        );
    }
}