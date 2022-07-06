import React, { useEffect, useState } from "react";
import { Card, Col, Container, Row } from "react-bootstrap";

const Main = (props) => {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    // console.log("fetch list of posts");
    fetch("http://localhost:8080/api/posts")
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        // console.log(data);
        setPosts(data);
      });
  }, []);

  return (
    <Container>
      <Row
        xs={1}
        md={2}
        lg={3}
        className="g-2 pb-2"
        style={{
          marginTop: props.headerHeight,
          marginBottom: props.footerHeight,
        }}
      >
        {posts.map((post) => {
          return (
            <Col key={post.id}>
              <Card>
                <Card.Header className="fst-italic">
                  {post.blogUser}
                </Card.Header>
                <Card.Body>
                  <Card.Title className="fst-italic">{post.title}</Card.Title>
                  <Card.Text>{post.content.slice(0, 200) + " . . ."}</Card.Text>
                </Card.Body>
                <Card.Footer className="d-flex text-muted">
                  <div className="me-auto">{"Posted: " + post.createdOn}</div>
                  <div>{"Edited: " + post.updatedOn}</div>
                </Card.Footer>
              </Card>
            </Col>
          );
        })}
      </Row>
    </Container>
  );
};

export default Main;
