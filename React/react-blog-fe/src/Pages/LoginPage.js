import React, { useEffect, useState } from "react";
import { Container, Row } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { login } from "../lib/api";
import LoginForm from "../Components/Forms/LoginForm";
import BannerSuccess from "../Components/RegistrationSuccess";

const LoginPage = (props) => {
  const [isLoginSuccess, setIsLoginSuccess] = useState(false);
  const [loginMessage, setLoginMessage] = useState("");
  const navigate = useNavigate();

  const onSubmit = (loginRequest, formikHelpers) => {
    setTimeout(() => {
      login(loginRequest)
        .then((loginResponse) => {
          console.log(loginResponse);
          setIsLoginSuccess(true);
          setLoginMessage(`Logged in as ${loginResponse.userName}`);
          formikHelpers.resetForm();
        })
        .catch((error) => {
          if (error.message.includes("password")) {
            formikHelpers.setFieldError("invalidPassword", error.message);
          } else {
            formikHelpers.setFieldError("invalidUsername", error.message);
          }
        })
        .finally(() => {
          formikHelpers.setSubmitting(false);
        });
    }, 1000);
  };

  useEffect(() => {
    setTimeout(() => {
      if (isLoginSuccess) {
        setIsLoginSuccess(false);
        navigate("/");
      }
    }, 3000);
  }, [isLoginSuccess]);

  return (
    <Container>
      <Row
        className="py-3 d-flex flex-column align-content-center"
        style={{
          marginTop: props.headerHeight,
          marginBottom: props.footerHeight,
        }}
      >
        <LoginForm onSubmit={onSubmit} />
        {isLoginSuccess && <BannerSuccess message={loginMessage} />}
      </Row>
    </Container>
  );
};

export default LoginPage;
