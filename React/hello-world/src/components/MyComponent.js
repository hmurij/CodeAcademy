import React from "react";
// export  default  function MyComponent(){
//     return <h1>Hello, World!</h1>
// }

// export default (props) => <h1>Hell {props.name}, World!</h1>

export default class MyComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {name: this.props.name}
        // this.onChange = this.onChange.bind(this)
    }

    // onChange(e) {
    //     this.setState({name: e.target.value})
    // }

    onChange = (e) => {
        this.setState({name: e.target.value})
    }

    render() {
        return (
            // <React.Fragment>
            // </React.Fragment>
            <>
                <input onChange={this.onChange}/>
                <h1>Hello, {this.state.name}!</h1>
            </>
        )
    }
}
