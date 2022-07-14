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

export const register = async (registerRequest) => {
  const response = await fetch(`${BLOG_DOMAIN}/auth/signup`, {
    method: "POST",
    body: JSON.stringify(registerRequest),
    headers: {
      "Content-Type": "application/json",
    },
  });
  const data = await response.json();
  if (!response.ok) {
    throw new Error(data.message);
  }
  return data;
};

export const login = async (loginRequest) => {
  const response = await fetch(`${BLOG_DOMAIN}/auth/login`, {
    method: "POST",
    body: JSON.stringify(loginRequest),
    headers: {
      "Content-Type": "application/json",
    },
  });
  const data = await response.json();
  if (!response.ok) {
    console.log(data);
    throw new Error(data.error);
  }
  return data;
};
