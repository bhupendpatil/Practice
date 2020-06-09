class Hello extends React.Component {
    render() {
        let bangs = "!".repeat(this.props.bangs);
        return (
            <div>
                <p>Hi {this.props.to} from {this.props.from}{bangs}</p>
                <img src={this.props.img}/>
            </div>
        );
    }
}