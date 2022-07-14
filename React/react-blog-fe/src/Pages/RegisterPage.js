import React, { useEffect, useState } from "react";
import { Container, Row } from "react-bootstrap";
import { register } from "../lib/api";
import RegistrationSuccess from "../Components/RegistrationSuccess";
import RegistrationForm from "../Components/Forms/RegistrationForm";

const RegisterPage = (props) => {
  const [isRegistrationSuccess, setIsRegistrationSuccess] = useState(false);
  const [registrationMessage, setRegistrationMessage] = useState("");

  useEffect(() => {
    setTimeout(() => {
      if (isRegistrationSuccess) {
        setIsRegistrationSuccess(false);
      }
    }, 5000);
  }, [isRegistrationSuccess]);

  const onSubmit = (values, formikHelpers) => {
    setTimeout(() => {
      register(values)
        .then((data) => {
          formikHelpers.resetForm();
          setRegistrationMessage(data.message);
          setIsRegistrationSuccess(true);
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
        className="py-3 d-flex flex-column align-content-center"
        style={{
          marginTop: props.headerHeight,
          marginBottom: props.footerHeight,
        }}
      >
        <RegistrationForm onSubmit={onSubmit} />
        {isRegistrationSuccess && (
          <RegistrationSuccess message={registrationMessage} />
        )}
      </Row>
    </Container>
  );
};

export default RegisterPage;
