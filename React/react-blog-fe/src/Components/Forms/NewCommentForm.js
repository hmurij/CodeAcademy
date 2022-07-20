import React, { useContext, useEffect, useRef, useState } from "react";
import { Card, FloatingLabel, Form } from "react-bootstrap";
import { Formik } from "formik";
import * as Yup from "yup";
import SubmitButton from "../SubmitButton";
import Banner from "../Banner";
import AuthContext from "../../store/auth-context";
import { submitNewComment } from "../../lib/api";

const NewCommentForm = ({ postId, onContentChange }) => {
  const [isSubmitted, setIsSubmitted] = useState(false);
  const authCtx = useContext(AuthContext);
  const textAreaRef = useRef(null);

  const onSubmit = (comment, formikHelpers) => {
    setTimeout(() => {
      submitNewComment({ id: postId, ...comment }, authCtx.token)
        .then(() => {
          formikHelpers.resetForm();
          setIsSubmitted(true);
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          formikHelpers.setSubmitting(false);
        });
    }, 2000);
  };

  useEffect(() => {
    setTimeout(() => {
      if (isSubmitted) {
        setIsSubmitted(false);
        onContentChange();
      }
    }, 2000);
  }, [isSubmitted]);

  useEffect(() => {
    textAreaRef.current.style.height = "100px";
  });

  return (
    <Formik
      initialValues={{
        content: "",
      }}
      validationSchema={Yup.object({
        content: Yup.string()
          .min(5, "Must be at least 5 characters")
          .max(1000, "Must be 1000 characters of less")
          .required("Required"),
      })}
      onSubmit={onSubmit}
    >
      {(formik) => (
        <>
          <Card className="mb-4 py-2 px-3 bg-light boxShadow">
            <Form onSubmit={formik.handleSubmit}>
              <Form.Group className="mb-2" controlId="content">
                <FloatingLabel label="Add new comment">
                  <Form.Control
                    type="text"
                    as="textarea"
                    name="content"
                    ref={textAreaRef}
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                    value={formik.values.content}
                    isValid={
                      formik.touched.content &&
                      !formik.errors.content &&
                      formik.values.content
                    }
                    isInvalid={formik.touched.content && formik.errors.content}
                  ></Form.Control>
                  <Form.Control.Feedback type="invalid">
                    {formik.errors.content}
                  </Form.Control.Feedback>
                </FloatingLabel>
              </Form.Group>
              <div className="d-flex mb-2 justify-content-end">
                <SubmitButton
                  // isSubmitted={isSubmitted}
                  isSubmitting={formik.isSubmitting}
                  name="Add New Comment"
                />
              </div>
            </Form>
          </Card>
          {isSubmitted && (
            <Banner
              className="text-success border-success mb-4"
              message={`New comment added by ${authCtx.userName}`}
            />
          )}
        </>
      )}
    </Formik>
  );
};

export default NewCommentForm;
