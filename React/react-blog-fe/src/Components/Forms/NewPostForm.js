import React, { useContext, useEffect, useRef } from "react";
import { Card, Col, Form } from "react-bootstrap";
import SubmitButton from "../SubmitButton";
import AuthContext from "../../store/auth-context";
import { Formik } from "formik";
import * as Yup from "yup";

const NewPostForm = ({ onSubmit }) => {
  const textAreaRef = useRef(null);
  const authCtx = useContext(AuthContext);

  useEffect(() => {
    textAreaRef.current.style.height = "300px";
  });
  return (
    <Formik
      initialValues={{
        title: "",
        content: "",
      }}
      validationSchema={Yup.object({
        title: Yup.string()
          .min(3, "Must be at least 3 characters")
          .max(30, "Must be 15 characters of less")
          .required("Required"),
        content: Yup.string()
          .min(250, "Must be at least 250 characters")
          .max(5000, "Must be 15 characters of less")
          .required("Required"),
      })}
      onSubmit={onSubmit}
    >
      {(formik) => (
        <Col>
          <Card className="mt-4 boxShadow">
            <Card.Header className="fst-italic">{`New Post by ${authCtx.userName}`}</Card.Header>
            <Card.Body className="m-2 pb-3 border rounded-3">
              <Form onSubmit={formik.handleSubmit}>
                <Form.Group controlId="title">
                  <Form.Label>Title</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Enter post title"
                    name="title"
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                    value={formik.values.title}
                    isValid={
                      formik.touched.title &&
                      !formik.errors.title &&
                      formik.values.title
                    }
                    isInvalid={formik.touched.title && formik.errors.title}
                  ></Form.Control>
                  <Form.Control.Feedback type="invalid">
                    {formik.errors.title}
                  </Form.Control.Feedback>
                </Form.Group>

                <Form.Group className="my-2" controlId="content">
                  <Form.Label>Content</Form.Label>
                  <Form.Control
                    type="text"
                    name="content"
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                    value={formik.values.content}
                    isValid={
                      formik.touched.content &&
                      !formik.errors.content &&
                      formik.values.content
                    }
                    isInvalid={formik.touched.content && formik.errors.content}
                    ref={textAreaRef}
                    as="textarea"
                    style={{ overflow: "hidden" }}
                  />
                  <Form.Control.Feedback type="invalid">
                    {formik.errors.content}
                  </Form.Control.Feedback>
                </Form.Group>
                <div className="d-flex justify-content-end">
                  <SubmitButton
                    isSubmitting={formik.isSubmitting}
                    name="Add New Post"
                  />
                </div>
              </Form>
            </Card.Body>
          </Card>
        </Col>
      )}
    </Formik>
  );
};

export default NewPostForm;
