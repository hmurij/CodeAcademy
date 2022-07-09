import React from "react";
import { Button, Container, Form, Row } from "react-bootstrap";
import { Formik } from "formik";
import * as Yup from "yup";
import { useNavigate } from "react-router-dom";

const Login = (props) => {
  const navigate = useNavigate();
  async function login(user) {
    const response = await fetch("http://localhost:3000/api/login", {
      method: "POST",
      body: JSON.stringify(user),
      headers: {
        "Content-Type": "application/json",
      },
    });
    const data = await response.json();
    console.log(data);
    navigate("/");
  }
  return (
    <Container>
      <Row
        className="py-3 justify-content-center"
        style={{
          marginTop: props.headerHeight,
          marginBottom: props.footerHeight,
        }}
      >
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
              .min(6, "Must be at least 3 characters")
              .max(15, "Must be 15 characters of less")
              .required("Required"),
          })}
          onSubmit={(values, formikHelpers) => {
            console.log(values);
            login(values);
            formikHelpers.resetForm();
          }}
        >
          {(formik) => (
            <Form
              onSubmit={formik.handleSubmit}
              className="col-sm-10 col-md-8 col-lg-6 mt-2 p-4 roundedBorder boxShadow"
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
                    formik.touched &&
                    !formik.errors.userName &&
                    formik.values.userName
                  }
                  isInvalid={formik.errors.userName}
                />
                <Form.Control.Feedback type="invalid">
                  {formik.errors.userName}
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
                    formik.touched &&
                    !formik.errors.password &&
                    formik.values.password
                  }
                  isInvalid={formik.errors.password}
                />
                <Form.Control.Feedback type="invalid">
                  {formik.errors.password}
                </Form.Control.Feedback>
              </Form.Group>
              <div className="d-flex justify-content-end">
                <Button
                  variant="outline-primary"
                  className="button"
                  type="submit"
                >
                  Login
                </Button>
              </div>
            </Form>
          )}
        </Formik>
      </Row>
    </Container>
  );
};

export default Login;
