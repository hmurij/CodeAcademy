import React, { useEffect, useRef, useState } from "react";
import {
  Button,
  Card,
  Col,
  Container,
  FloatingLabel,
  Form,
  Row,
} from "react-bootstrap";
import { useParams } from "react-router-dom";
import Comment from "../Components/Comment";

const Post = (props) => {
  const [post, setPost] = useState({});
  const [comments, setComments] = useState([]);
  const { id } = useParams();
  const textAreaRef = useRef(null);

  useEffect(() => {
    // console.log("fetching post id:" + id);
    fetch("http://localhost:3000/api/posts/" + id)
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        console.log(data);
        setPost(data);
        setComments(data.comments);
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
          marginTop: props.headerHeight + 15 + "px",
          marginBottom: props.footerHeight,
        }}
      >
        <Col>
          <Card style={{ boxShadow: "5px 5px 10px grey" }}>
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
              <div className="d-flex mt-2 justify-content-end">
                <Button variant="outline-primary me-1">Update</Button>
                <Button variant="outline-danger">Delete</Button>
              </div>
            </Card.Body>
            <Card.Footer className="d-flex text-muted">
              <div className="me-auto">{"Posted: " + post.createdOn}</div>
              <div>{"Edited: " + post.updatedOn}</div>
            </Card.Footer>
          </Card>

          <div className="ms-2 mt-2">
            <h5>Comments</h5>
          </div>

          <Card
            className="py-2 px-3 bg-light"
            style={{ boxShadow: "5px 5px 10px grey" }}
          >
            <Form>
              <Form.Group
                className="mb-3"
                controlId="exampleForm.ControlTextarea1"
              >
                <FloatingLabel label="Add new comment">
                  <Form.Control as="textarea" rows={3} />
                </FloatingLabel>
              </Form.Group>
              <div className="d-flex justify-content-end">
                <Button variant="outline-primary" type="submit">
                  Add New Comment
                </Button>
              </div>
            </Form>
          </Card>

          {comments.map((comment) => {
            return <Comment comment={comment} />;
          })}
        </Col>
      </Row>
    </Container>
  );
};

export default Post;
