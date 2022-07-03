import React from "react";
import { Container, Row } from "react-bootstrap";

const Main = (props) => {
  return (
    <Container
      id="content"
      fluid
      className="bg-light pt-2"
      style={{ height: "100vh" }}
    >
      <Row
        className="bg-white ms-1 me-1"
        style={{ marginTop: props.headerHeight }}
      >
        <h1>Main content</h1>
      </Row>
    </Container>
  );
};

export default Main;
