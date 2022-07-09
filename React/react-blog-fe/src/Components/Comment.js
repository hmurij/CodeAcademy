import React, { useEffect, useRef } from "react";
import { Button, Card } from "react-bootstrap";

const Comment = (props) => {
  const textAreaRef = useRef(null);

  useEffect(() => {
    textAreaRef.current.style.height = textAreaRef.current.scrollHeight + "px";
  });

  return (
    <Card className="my-4 boxShadow">
      <Card.Header className=" d-flex justify-content-between">
        <div className="fst-italic">{props.comment.blogUser}</div>
        <div className="text-muted">
          {"Commented: " + props.comment.createdOn}
        </div>
      </Card.Header>
      <Card.Body>
        <textarea
          ref={textAreaRef}
          readOnly={true}
          defaultValue={props.comment.comment}
          className="form-control bg-white"
          style={{ overflow: "hidden" }}
        ></textarea>
        <div className="d-flex mt-2 justify-content-end">
          <Button variant="outline-primary me-1" className="button">
            Update
          </Button>
          <Button variant="outline-danger" className="button">
            Delete
          </Button>
        </div>
      </Card.Body>
    </Card>
  );
};

export default Comment;
