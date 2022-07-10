import React, { useEffect, useState } from "react";
import { Alert, Col, Container, Row } from "react-bootstrap";
import { useParams } from "react-router-dom";
import NewCommentForm from "../Components/Forms/NewCommentForm";
import CommentsList from "../Components/CommentsList";
import PostUpdateForm from "../Components/Forms/PostUpdateForm";
import Loading from "../Components/Loading";

const Post = (props) => {
  const [post, setPost] = useState({});
  const [comments, setComments] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState(null);
  const { id } = useParams();

  async function fetchPostById() {
    try {
      const response = await fetch("http://localhost:3000/api/posts/" + id);
      if (!response.ok) {
        console.log(response.status);
        throw new Error("Post with id: " + id + " not found");
      }
      const data = await response.json();
      setPost(data);
      setComments(data.comments);
    } catch (error) {
      setError(error.message);
    } finally {
      setIsLoading(false);
    }
  }

  useEffect(() => {
    setTimeout(() => {
      fetchPostById();
    }, Math.random() * 1000);

    // fetch("http://localhost:3000/api/posts/" + id)
    //   .then((response) => {
    //     return response.json();
    //   })
    //   .then((data) => {
    //     setPost(data);
    //     setComments(data.comments);
    //   });
  }, []);

  let content = <Loading />;

  if (error) {
    content = (
      <Alert variant={"secondary"} className="bg-white boxShadow">
        {error}
      </Alert>
    );
  }
  if (!isLoading && !error) {
    content = (
      <Col>
        <PostUpdateForm post={post} />

        <div className="ms-2 mt-2">
          <h5>Comments</h5>
        </div>

        <NewCommentForm />
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

export default Post;
