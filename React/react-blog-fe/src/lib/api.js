const BLOG_DOMAIN = "http://localhost:3000/api";

export const getAllPosts = async () => {
  const response = await fetch(`${BLOG_DOMAIN}/posts`);
  return response.ok ? await response.json() : [];
};

export const getPostById = async (id) => {
  const response = await fetch(`${BLOG_DOMAIN}/posts/${id}`);
  if (!response.ok) {
    throw new Error("Post with id: " + id + " not found");
  }
  return await response.json();
};
