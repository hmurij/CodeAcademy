import React from "react";
import MainPage from "./MainPage";
import LoginPage from "./LoginPage";
import RegisterPage from "./RegisterPage";
import NewPostPage from "./NewPostPage";
import PostPage from "./PostPage";
import { Route, Routes } from "react-router-dom";

const Pages = (props) => {
  return (
    <Routes>
      <Route
        path="/login"
        element={
          <LoginPage
            headerHeight={props.headerHeight}
            footerHeight={props.footerHeight}
          />
        }
      ></Route>
      <Route
        path="/register"
        element={
          <RegisterPage
            headerHeight={props.headerHeight}
            footerHeight={props.footerHeight}
          />
        }
      ></Route>
      <Route
        path="/new-post"
        element={
          <NewPostPage
            headerHeight={props.headerHeight}
            footerHeight={props.footerHeight}
          />
        }
      ></Route>
      <Route
        path="/post/:id"
        element={
          <PostPage
            headerHeight={props.headerHeight}
            footerHeight={props.footerHeight}
          />
        }
      ></Route>
      <Route
        path="/*"
        element={
          <MainPage
            headerHeight={props.headerHeight}
            footerHeight={props.footerHeight}
          />
        }
      ></Route>
    </Routes>
  );
};

export default Pages;
