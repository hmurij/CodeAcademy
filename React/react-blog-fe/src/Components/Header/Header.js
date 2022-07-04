import React from "react";
import { Container, Nav, Navbar, NavDropdown } from "react-bootstrap";
import { NavLink } from "react-router-dom";

class Header extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      height: 0,
    };
    this.resizeHandler = this.resizeHandler.bind(this);
  }

  resizeHandler() {
    const height = this.header.clientHeight;
    this.setState({ height });
    this.props.onHeightChange(height);
  }

  componentDidMount() {
    this.resizeHandler();
    window.addEventListener("resize", this.resizeHandler);
  }

  componentWillUnmount() {
    window.removeEventListener("resize", this.resizeHandler);
  }

  render() {
    return (
      <Container
        fluid
        className="fixed-top border-bottom bg-white text-center"
        ref={(header) => {
          this.header = header;
        }}
      >
        <Navbar bg="white" expand="sm">
          <Container fluid>
            <Navbar.Brand to="/" as={NavLink}>
              Home
            </Navbar.Brand>

            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
              <Nav className="me-auto">
                <NavDropdown title="Languages" id="basic-nav-dropdown">
                  <NavDropdown.Item href="#action/3.1">
                    English
                  </NavDropdown.Item>
                  <NavDropdown.Divider />
                  <NavDropdown.Item href="#action/3.2">
                    Lithuanian
                  </NavDropdown.Item>
                </NavDropdown>

                <Nav className=" bg-danger">
                  <Nav.Link
                    className="justify-content-end"
                    to="/login"
                    as={NavLink}
                  >
                    Login
                  </Nav.Link>

                  <Nav.Link to="/" as={NavLink}>
                    Logout
                  </Nav.Link>
                  <Nav.Link href="#link">Register</Nav.Link>
                </Nav>
              </Nav>
            </Navbar.Collapse>
          </Container>
        </Navbar>
        <h1>Spring Rest API Blog - Main Page</h1>
      </Container>
    );
  }
}

export default Header;
