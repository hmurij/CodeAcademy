import React from "react";
import { Button, Card, Container, Form, Row } from "react-bootstrap";

const Login = (props) => {
  return (
    <Container>
      <Row
        className="py-3 justify-content-center"
        style={{
          marginTop: props.headerHeight,
          marginBottom: props.footerHeight,
        }}
      >
        <Form
          as={Card}
          className="col-sm-10 col-md-8 col-lg-6 mt-2 p-4"
          style={{ boxShadow: "5px 5px 10px grey" }}
        >
          <Form.Group className="mb-3" controlId="formUserName">
            <Form.Label>User name</Form.Label>
            <Form.Control type="email" placeholder="Enter user name" />
          </Form.Group>

          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>Password</Form.Label>
            <Form.Control type="password" placeholder="Password" />
          </Form.Group>
          <div className="d-flex justify-content-end">
            <Button variant="outline-primary" className="button" type="submit">
              Login
            </Button>
          </div>
        </Form>
      </Row>
    </Container>
  );
};

export default Login;
