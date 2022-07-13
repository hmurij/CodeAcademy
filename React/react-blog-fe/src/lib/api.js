const BLOG_DOMAIN = "http://localhost:3000/api";

export const getAllPosts = async (setPosts, setIsLoading) => {
  const response = await fetch(`${BLOG_DOMAIN}/posts`);
  if (response.ok) {
    const data = await response.json();
    setPosts(data);
  }
  setIsLoading(false);
};
