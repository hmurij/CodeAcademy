import React, { useContext, useEffect, useRef } from "react";
import { Button, Card } from "react-bootstrap";
import AuthContext from "../store/auth-context";

const Comment = ({ comment }) => {
  const textAreaRef = useRef(null);
  const authCtx = useContext(AuthContext);

  useEffect(() => {
    textAreaRef.current.style.height = textAreaRef.current.scrollHeight + "px";
  });

  return (
    <Card className="mb-4 boxShadow">
      <Card.Header className=" d-flex justify-content-between">
        <div className="fst-italic">{comment.blogUser}</div>
        <div className="text-muted">{`Commented: ${comment.createdOn}`}</div>
      </Card.Header>
      <Card.Body>
        <textarea
          ref={textAreaRef}
          readOnly={true}
          defaultValue={comment.comment}
          className="form-control bg-white"
          style={{ overflow: "hidden" }}
        ></textarea>
        {authCtx.isLoggedIn &&
          (authCtx.userName === comment.blogUser ||
            authCtx.authorities === authCtx.ROLES.admin) && (
            <div className="d-flex mt-2 justify-content-end">
              <Button variant="outline-primary me-1" className="button">
                Update
              </Button>
              <Button variant="outline-danger" className="button">
                Delete
              </Button>
            </div>
          )}
      </Card.Body>
    </Card>
  );
};

export default Comment;
