import React from "react";
import { Container, Row } from "react-bootstrap";
import Main from "./Main";
import { Route, Routes } from "react-router-dom";
import Login from "./Login";
import Register from "./Register";
import NewPost from "./NewPost";

const Pages = (props) => {
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
        <Routes>
          <Route path="/login" element={<Login />}></Route>
          <Route path="/register" element={<Register />}></Route>
          <Route path="/new-post" element={<NewPost />}></Route>
          <Route path="/" element={<Main />}></Route>
        </Routes>
      </Row>
    </Container>
  );
};

export default Pages;
