import React from "react";
import { Link, NavLink } from "react-router-dom";
import { Card } from "react-bootstrap";

const PostThumbnail = (props) => {
  return (
    <Link
      key={props.post.id}
      to={"/post/" + props.post.id}
      as={NavLink}
      className="text-decoration-none text-black"
    >
      <Card className="h-100" style={{ boxShadow: "5px 5px 10px grey" }}>
        <Card.Header className="fst-italic">{props.post.blogUser}</Card.Header>
        <Card.Body>
          <Card.Title className="fst-italic">{props.post.title}</Card.Title>
          <Card.Text style={{ textAlign: "justify" }}>
            {props.post.content.slice(0, 200) + " . . ."}
          </Card.Text>
        </Card.Body>
        <Card.Footer className="d-flex text-muted">
          <div className="me-auto">{"Posted: " + props.post.createdOn}</div>
          <div>{"Edited: " + props.post.updatedOn}</div>
        </Card.Footer>
      </Card>
    </Link>
  );
};

export default PostThumbnail;
