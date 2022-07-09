import React, { useEffect, useState } from "react";
import { Col, Container, Row } from "react-bootstrap";
import { useParams } from "react-router-dom";
import NewCommentForm from "../Components/Forms/NewCommentForm";
import CommentsList from "../Components/CommentsList";
import PostUpdateForm from "../Components/Forms/PostUpdateForm";

const Post = (props) => {
  const [post, setPost] = useState({});
  const [comments, setComments] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const { id } = useParams();

  async function fetchPostById() {
    setIsLoading(true);
    const response = await fetch("http://localhost:3000/api/posts/" + id);
    const data = await response.json();
    setPost(data);
    setComments(data.comments);
    setIsLoading(false);
  }

  useEffect(() => {
    fetchPostById();

    // fetch("http://localhost:3000/api/posts/" + id)
    //   .then((response) => {
    //     return response.json();
    //   })
    //   .then((data) => {
    //     setPost(data);
    //     setComments(data.comments);
    //   });
  }, []);

  return (
    <Container>
      <Row
        className="g-2 pb-2"
        style={{
          marginTop: props.headerHeight + 15 + "px",
          marginBottom: props.footerHeight,
        }}
      >
        <Col>
          <PostUpdateForm post={post} />
          <div className="ms-2 mt-2">
            <h5>Comments</h5>
          </div>

          <NewCommentForm />
          <CommentsList comments={comments} />
        </Col>
      </Row>
    </Container>
  );
};

export default Post;
