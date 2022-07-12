import React, { useEffect, useState } from "react";
import { Container, Row } from "react-bootstrap";
import PostThumbnailsList from "../Components/PostThumbnailsList";
import Loading from "../Components/Loading";

const MainPage = (props) => {
  const [posts, setPosts] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  async function fetchPosts() {
    const response = await fetch("http://localhost:3000/api/posts");
    const data = await response.json();
    setPosts(data);
    setIsLoading(false);
  }

  useEffect(() => {
    setTimeout(() => {
      fetchPosts();
    }, Math.random() * 1000);
  }, []);

  return (
    <Container>
      <Row
        xs={1}
        md={2}
        lg={3}
        className="g-4 pb-4 justify-content-center"
        style={{
          marginTop: props.headerHeight,
          marginBottom: props.footerHeight,
        }}
      >
        {isLoading && <Loading />}
        {!isLoading && <PostThumbnailsList posts={posts} />}
      </Row>
    </Container>
  );
};

export default MainPage;
