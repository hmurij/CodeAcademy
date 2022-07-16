import React from "react";
import { Container, Row } from "react-bootstrap";
import NewPostForm from "../Components/Forms/NewPostForm";

const NewPostPage = (props) => {
  const onSubmit = (newPosts, formikHelpers) => {
    console.log(newPosts);
    console.log(formikHelpers);
  };
  return (
    <Container>
      <Row
        style={{
          marginTop: props.headerHeight,
          marginBottom: props.footerHeight,
        }}
      >
        <NewPostForm onSubmit={onSubmit} />
      </Row>
    </Container>
  );
};

export default NewPostPage;
