import React from "react";
import Main from "./Main";
import { Route, Routes } from "react-router-dom";
import Login from "./Login";
import Register from "./Register";
import NewPost from "./NewPost";
import Post from "./Post";

const Pages = (props) => {
  return (
    <Routes>
      <Route
        path="/login"
        element={
          <Login
            headerHeight={props.headerHeight}
            footerHeight={props.footerHeight}
          />
        }
      ></Route>
      <Route
        path="/register"
        element={
          <Register
            headerHeight={props.headerHeight}
            footerHeight={props.footerHeight}
          />
        }
      ></Route>
      <Route
        path="/new-post"
        element={
          <NewPost
            headerHeight={props.headerHeight}
            footerHeight={props.footerHeight}
          />
        }
      ></Route>
      <Route
        path="/post/:id"
        element={
          <Post
            headerHeight={props.headerHeight}
            footerHeight={props.footerHeight}
          />
        }
      ></Route>
      <Route
        path="/"
        element={
          <Main
            headerHeight={props.headerHeight}
            footerHeight={props.footerHeight}
          />
        }
      ></Route>
    </Routes>
  );
};

export default Pages;
