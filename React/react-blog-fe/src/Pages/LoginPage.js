import React, { useContext, useEffect, useState } from "react";
import { Container, Row } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { login } from "../lib/api";
import LoginForm from "../Components/Forms/LoginForm";
import AuthContext from "../store/auth-context";
import Banner from "../Components/Banner";

const LoginPage = (props) => {
  const [isLoginSuccess, setIsLoginSuccess] = useState(false);
  const [loginMessage, setLoginMessage] = useState("");
  const navigate = useNavigate();
  const authCtx = useContext(AuthContext);

  const onSubmit = (loginRequest, formikHelpers) => {
    setTimeout(() => {
      login(loginRequest)
        .then((loginResponse) => {
          console.log(loginResponse);
          setIsLoginSuccess(true);
          setLoginMessage(`Logged in as ${loginResponse.userName}`);
          formikHelpers.resetForm();
          authCtx.login(loginResponse);
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
    }, 2000);
  }, [isLoginSuccess]);

  return (
    <Container>
      <Row
        className="py-4 d-flex flex-column align-content-center"
        style={{
          marginTop: props.headerHeight,
          marginBottom: props.footerHeight,
        }}
      >
        <LoginForm onSubmit={onSubmit} />
        {isLoginSuccess && (
          <Banner
            className="text-success border-success mt-4"
            message={loginMessage}
          />
        )}
      </Row>
    </Container>
  );
};

export default LoginPage;
