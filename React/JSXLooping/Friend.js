class Friend extends React.Component {
    render() {
        const {name, hobbies} = this.props;
        return (
            <div>
                <h1>{name}</h1>
                <ul>
                    {hobbies.map(hobbie => <li>{hobbie}</li>)}
                </ul>
            </div>
        );
    }
}