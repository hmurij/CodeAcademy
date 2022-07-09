import React, { useEffect, useRef } from "react";
import { Button, Card } from "react-bootstrap";

const PostUpdateForm = (props) => {
  const textAreaRef = useRef(null);

  useEffect(() => {
    textAreaRef.current.style.height = textAreaRef.current.scrollHeight + "px";
  });

  return (
    <Card style={{ boxShadow: "5px 5px 10px grey" }}>
      <Card.Header className="fst-italic">{props.post.blogUser}</Card.Header>
      <Card.Body>
        <Card.Title className="fst-italic">{props.post.title}</Card.Title>
        <textarea
          ref={textAreaRef}
          defaultValue={props.post.content}
          readOnly={true}
          className="form-control bg-white"
          style={{ overflow: "hidden" }}
        />
        <div className="d-flex mt-2 justify-content-end">
          <Button variant="outline-primary me-1" className="button">
            Update
          </Button>
          <Button variant="outline-danger" className="button">
            Delete
          </Button>
        </div>
      </Card.Body>
      <Card.Footer className="d-flex text-muted">
        <div className="me-auto">{"Posted: " + props.post.createdOn}</div>
        <div>{"Edited: " + props.post.updatedOn}</div>
      </Card.Footer>
    </Card>
  );
};

export default PostUpdateForm;
