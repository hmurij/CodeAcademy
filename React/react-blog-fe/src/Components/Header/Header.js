import React from "react";
import { Container, Dropdown, Nav, Navbar } from "react-bootstrap";
import { Link, NavLink } from "react-router-dom";

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
              <Dropdown>
                <Dropdown.Toggle variant="outline-secondary">
                  Languages
                </Dropdown.Toggle>

                <Dropdown.Menu>
                  <Dropdown.Item href="#/action-1">Lithuanian</Dropdown.Item>
                  <Dropdown.Divider />
                  <Dropdown.Item href="#/action-2">English</Dropdown.Item>
                </Dropdown.Menu>
              </Dropdown>

              <Link
                className="me-auto btn btn-outline-secondary ms-1 mt-1 mb-1 text-decoration-none"
                to="/new-post"
                as={NavLink}
              >
                New Post
              </Link>

              <div
                className="btn mt-2 mb-2 text-secondary"
                style={{ cursor: "default" }}
              >
                <span>Signed in as: {"User Name"}</span>
              </div>

              <Nav>
                <Link
                  className="btn btn-outline-secondary me-1 mt-1 mb-1 text-decoration-none"
                  to="/login"
                  as={NavLink}
                >
                  Login
                </Link>
                <Link
                  className="btn btn-outline-secondary me-1 mt-1  mb-1 text-decoration-none"
                  to="/"
                  as={NavLink}
                >
                  Logout
                </Link>
                <Link
                  className="btn btn-outline-secondary me-1 mt-1 mb-1 text-decoration-none"
                  to="/register"
                  as={NavLink}
                >
                  Register
                </Link>
              </Nav>
            </Navbar.Collapse>
          </Container>
        </Navbar>
        <div className="btn" style={{ cursor: "default" }}>
          <h1>Spring Rest API Blog</h1>
        </div>
      </Container>
    );
  }
}

export default Header;
