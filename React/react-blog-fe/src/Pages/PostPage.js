import React, { useContext, useEffect, useState } from "react";
import { Col, Container, Row } from "react-bootstrap";
import NewCommentForm from "../Components/Forms/NewCommentForm";
import CommentsList from "../Components/CommentsList";
import PostUpdateForm from "../Components/Forms/PostUpdateForm";
import Loading from "../Components/Loading";
import { getPostById } from "../lib/api";
import { useParams } from "react-router-dom";
import Banner from "../Components/Banner";
import AuthContext from "../store/auth-context";

const PostPage = (props) => {
  const [post, setPost] = useState({});
  const [comments, setComments] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState(null);
  const { id } = useParams();
  const authCtx = useContext(AuthContext);

  const fetchPostById = () => {
    getPostById(id)
      .then((post) => {
        setPost(post);
        setComments(post.comments);
      })
      .catch((error) => {
        // console.log(Error);
        setError(error.message);
      })
      .finally(() => {
        setIsLoading(false);
      });
  };

  useEffect(() => {
    setTimeout(() => {
      fetchPostById();
    }, Math.random() * 1000);
  }, []);

  let content = <Loading />;

  if (error) {
    content = <Banner className="text-danger border-danger" message={error} />;
  }
  if (!isLoading && !error) {
    content = (
      <Col>
        <PostUpdateForm post={post} />

        <div className="ms-2 my-3">
          <h5>Comments</h5>
        </div>

        {authCtx.isLoggedIn && <NewCommentForm />}
        <CommentsList comments={comments} />
      </Col>
    );
  }

  return (
    <Container>
      <Row
        className="pt-4 justify-content-center"
        style={{
          marginTop: props.headerHeight,
          marginBottom: props.footerHeight,
        }}
      >
        {content}
      </Row>
    </Container>
  );
};

export default PostPage;
