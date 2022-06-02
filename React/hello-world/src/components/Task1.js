import React from "react";

export default class Task1 extends React.Component {
    constructor(props) {
        super(props);
        this.state = {message: this.props.message}
        this.counter = 0;
    }

    onChange = () => {
        this.counter++;
        this.setState({message: this.counter})
    }

    render() {
        return (
            <>
                <h1>{this.state.message}</h1>
                <button onClick={this.onChange}>Click me</button>
            </>
        )
    }
}
