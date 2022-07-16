import React, { useContext, useEffect, useRef } from "react";
import { Button, Card } from "react-bootstrap";
import AuthContext from "../../store/auth-context";

const PostUpdateForm = ({ post }) => {
  const textAreaRef = useRef(null);
  const authCtx = useContext(AuthContext);

  useEffect(() => {
    textAreaRef.current.style.height = textAreaRef.current.scrollHeight + "px";
  });

  return (
    <Card className="boxShadow">
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
        {authCtx.isLoggedIn &&
          (authCtx.userName === post.blogUser ||
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
      <Card.Footer className="d-flex text-muted">
        <div className="me-auto">{`Posted: ${post.createdOn}`}</div>
        <div>{`Edited: ${post.updatedOn}`}</div>
      </Card.Footer>
    </Card>
  );
};

export default PostUpdateForm;
