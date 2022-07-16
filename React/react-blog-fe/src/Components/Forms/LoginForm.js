import React from "react";
import * as Yup from "yup";
import { Card, Col, Form } from "react-bootstrap";
import { Formik } from "formik";
import SubmitButton from "../SubmitButton";

const LoginForm = ({ onSubmit }) => {
  return (
    <Formik
      initialValues={{
        userName: "",
        password: "",
      }}
      validationSchema={Yup.object({
        userName: Yup.string()
          .min(3, "Must be at least 3 characters")
          .max(15, "Must be 15 characters of less")
          .required("Required"),
        password: Yup.string()
          .min(5, "Must be at least 5 characters")
          .max(15, "Must be 15 characters of less")
          .required("Required"),
      })}
      onSubmit={onSubmit}
    >
      {(formik) => (
        <Col sm={10} md={8} lg={6}>
          <Card className="boxShadow">
            <Card.Header className="fst-italic">Login form</Card.Header>
            <Form
              className="m-2 p-4 border rounded-3"
              onSubmit={formik.handleSubmit}
            >
              <Form.Group className="mb-3" controlId="userName">
                <Form.Label>User name</Form.Label>
                <Form.Control
                  type="text"
                  placeholder="Enter user name"
                  name="userName"
                  onChange={formik.handleChange}
                  onBlur={formik.handleBlur}
                  value={formik.values.userName}
                  isValid={
                    formik.touched.userName &&
                    !formik.errors.userName &&
                    formik.values.userName
                  }
                  isInvalid={
                    (formik.touched.userName && formik.errors.userName) ||
                    formik.errors.invalidUsername
                  }
                />
                <Form.Control.Feedback type="invalid">
                  {formik.errors.userName}
                </Form.Control.Feedback>
                <Form.Control.Feedback type="invalid">
                  {formik.errors.invalidUsername}
                </Form.Control.Feedback>
              </Form.Group>

              <Form.Group className="mb-3" controlId="password">
                <Form.Label>Password</Form.Label>
                <Form.Control
                  type="password"
                  placeholder="Password"
                  name="password"
                  onChange={formik.handleChange}
                  onBlur={formik.handleBlur}
                  value={formik.values.password}
                  isValid={
                    formik.touched.password &&
                    !formik.errors.password &&
                    formik.values.password
                  }
                  isInvalid={
                    (formik.errors.password && formik.touched.password) ||
                    formik.errors.invalidPassword
                  }
                />
                <Form.Control.Feedback type="invalid">
                  {formik.errors.password}
                </Form.Control.Feedback>
                <Form.Control.Feedback type="invalid">
                  {formik.errors.invalidPassword}
                </Form.Control.Feedback>
              </Form.Group>
              <SubmitButton isSubmitting={formik.isSubmitting} name="Login" />
            </Form>
          </Card>
        </Col>
      )}
    </Formik>
  );
};
export default LoginForm;
