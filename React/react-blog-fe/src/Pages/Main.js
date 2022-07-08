import React, { useEffect, useState } from "react";
import { Card, Container, Row } from "react-bootstrap";
import { Link, NavLink } from "react-router-dom";

const Main = (props) => {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    // console.log("fetch list of posts");
    fetch("http://localhost:3000/api/posts")
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
        className="g-4"
        style={{
          marginTop: props.headerHeight,
          marginBottom: props.footerHeight + 15 + "px",
        }}
      >
        {posts.map((post) => {
          return (
            <Link
              key={post.id}
              to={"/post/" + post.id}
              as={NavLink}
              className="text-decoration-none text-black"
            >
              {/*<Col>*/}
              <Card
                className="h-100"
                style={{ boxShadow: "5px 5px 10px grey" }}
              >
                <Card.Header className="fst-italic">
                  {post.blogUser}
                </Card.Header>
                <Card.Body>
                  <Card.Title className="fst-italic">{post.title}</Card.Title>
                  <Card.Text style={{ textAlign: "justify" }}>
                    {post.content.slice(0, 200) + " . . ."}
                  </Card.Text>
                </Card.Body>
                <Card.Footer className="d-flex text-muted">
                  <div className="me-auto">{"Posted: " + post.createdOn}</div>
                  <div>{"Edited: " + post.updatedOn}</div>
                </Card.Footer>
              </Card>
              {/*</Col>*/}
            </Link>
          );
        })}
      </Row>
    </Container>
  );
};

export default Main;
