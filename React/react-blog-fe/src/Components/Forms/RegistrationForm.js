import React from "react";
import * as Yup from "yup";
import { Card, Col, Form } from "react-bootstrap";
import { Formik } from "formik";
import SubmitButton from "../SubmitButton";

const RegistrationForm = (props) => {
  return (
    <Formik
      initialValues={{
        userName: "",
        email: "",
        password: "",
      }}
      validationSchema={Yup.object({
        userName: Yup.string()
          .min(3, "Must be at least 3 characters")
          .max(15, "Must be 15 characters of less")
          .required("Required"),
        email: Yup.string().email().required("Required"),
        password: Yup.string()
          .min(5, "Must be at least 5 characters")
          .max(15, "Must be 15 characters of less")
          .required("Required"),
      })}
      onSubmit={props.onSubmit}
    >
      {(formik) => (
        <Col sm={10} md={8} lg={6}>
          <Card className="roundedBorder boxShadow">
            <Card.Header className="fst-italic">Register form</Card.Header>
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
                    formik.errors.register
                  }
                />
                <Form.Control.Feedback type="invalid">
                  {formik.errors.userName}
                </Form.Control.Feedback>
                <Form.Control.Feedback type="invalid">
                  {formik.errors.register}
                </Form.Control.Feedback>
              </Form.Group>

              <Form.Group className="mb-3" controlId="email">
                <Form.Label>Email</Form.Label>
                <Form.Control
                  type="email"
                  placeholder="Enter email"
                  name="email"
                  onChange={formik.handleChange}
                  onBlur={formik.handleBlur}
                  value={formik.values.email}
                  isValid={
                    formik.touched.email &&
                    !formik.errors.email &&
                    formik.values.email
                  }
                  isInvalid={formik.touched.email && formik.errors.email}
                />
                <Form.Control.Feedback type="invalid">
                  {formik.errors.email}
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
                  isInvalid={formik.touched.password && formik.errors.password}
                />
                <Form.Control.Feedback type="invalid">
                  {formik.errors.password}
                </Form.Control.Feedback>
              </Form.Group>

              <SubmitButton
                isSubmitting={formik.isSubmitting}
                name="Register"
              />
            </Form>
          </Card>
        </Col>
      )}
    </Formik>
  );
};

export default RegistrationForm;
