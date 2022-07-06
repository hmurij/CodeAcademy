import React from "react";
import { Container, Row } from "react-bootstrap";

const Register = (props) => {
  return (
    <Container>
      <Row
        className="g-2 pb-2"
        style={{
          marginTop: props.headerHeight,
          marginBottom: props.footerHeight,
        }}
      >
        <h1>Register page</h1>
      </Row>
    </Container>
  );
};

export default Register;
