import React, { useEffect, useRef, useState } from "react";
import { Card, Col, Container, Row } from "react-bootstrap";
import { useParams } from "react-router-dom";

const Post = (props) => {
  const [post, setPost] = useState({});
  const { id } = useParams();
  const textAreaRef = useRef(null);

  useEffect(() => {
    // console.log("fetching post id:" + id);
    fetch("http://localhost:8080/api/posts/" + id)
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        console.log(data);
        setPost(data);
      });
  }, []);

  useEffect(() => {
    textAreaRef.current.style.height = textAreaRef.current.scrollHeight + "px";
  });

  return (
    <Container>
      <Row
        className="g-2 pb-2"
        style={{
          marginTop: props.headerHeight,
          marginBottom: props.footerHeight,
        }}
      >
        <Col>
          <Card>
            <Card.Header className="fst-italic">{post.blogUser}</Card.Header>
            <Card.Body>
              <Card.Title className="fst-italic">{post.title}</Card.Title>
              <textarea
                ref={textAreaRef}
                defaultValue={post.content}
                readOnly={true}
                className="form-control bg-white"
                style={{ overflow: "hidden" }}
              />
            </Card.Body>
            <Card.Footer className="d-flex text-muted">
              <div className="me-auto">{"Posted: " + post.createdOn}</div>
              <div>{"Edited: " + post.updatedOn}</div>
            </Card.Footer>
          </Card>
        </Col>
      </Row>
    </Container>
  );
};

export default Post;
