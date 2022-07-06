import React from "react";
import { Col, Container, Row } from "react-bootstrap";

const Footer = () => {
  return (
    <Container fluid className="fixed-bottom border-top bg-white">
      <Row>
        <Col>
          <p className="text-center text-nowrap pt-3">
            &copy; 2022 MyCompany, Inc
          </p>
        </Col>
      </Row>
    </Container>
  );
};

export default Footer;
