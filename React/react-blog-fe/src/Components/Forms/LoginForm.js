import React from "react";
import * as Yup from "yup";
import { Form } from "react-bootstrap";
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
      )}
    </Formik>
  );
};
export default LoginForm;
