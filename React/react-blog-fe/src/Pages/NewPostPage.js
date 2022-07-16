import React, { useContext } from "react";
import { Container, Row } from "react-bootstrap";
import NewPostForm from "../Components/Forms/NewPostForm";
import { submitNewPost } from "../lib/api";
import AuthContext from "../store/auth-context";

const NewPostPage = (props) => {
  const authContext = useContext(AuthContext);
  const onSubmit = (newPost, formikHelpers) => {
    console.log(newPost);
    // console.log(formikHelpers);
    submitNewPost(newPost, authContext.token).then(() => {
      setTimeout(() => {
        // formikHelpers.resetForm();
        formikHelpers.setSubmitting(false);
      }, 2000);
    });
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
