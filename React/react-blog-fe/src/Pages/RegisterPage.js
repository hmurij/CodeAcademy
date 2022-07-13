import React from "react";
import { Button, Container, Form, Row, Spinner } from "react-bootstrap";
import * as Yup from "yup";
import { Formik } from "formik";
import { register } from "../lib/api";

const RegisterPage = (props) => {
  const onSubmit = (values, formikHelpers) => {
    setTimeout(() => {
      register(values)
        .then((data) => {
          console.log(data);
          console.log("show user created message");
          formikHelpers.resetForm();
        })
        .catch((error) => {
          // console.log(error.message);
          formikHelpers.setFieldError("register", error.message);
        })
        .finally(() => {
          formikHelpers.setSubmitting(false);
        });
    }, 1000);
  };
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
              .min(6, "Must be at least 6 characters")
              .max(15, "Must be 15 characters of less")
              .required("Required"),
          })}
          onSubmit={onSubmit}
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
              <div className="d-flex justify-content-end">
                <Button
                  variant="outline-primary"
                  className={`${
                    formik.isSubmitting ? "disabled button" : "button"
                  }`}
                  type="submit"
                >
                  <Spinner
                    as="span"
                    animation="border"
                    size="sm"
                    role="status"
                    aria-hidden="true"
                    className={`${!formik.isSubmitting && "visually-hidden"}`}
                  />
                  <span className="ms-1">
                    {!formik.isSubmitting ? "Register" : "Submitting"}
                  </span>
                </Button>
              </div>
            </Form>
          )}
        </Formik>
      </Row>
    </Container>
  );
};

export default RegisterPage;
