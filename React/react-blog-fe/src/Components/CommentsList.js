import React from "react";
import Comment from "./Comment";

const CommentsList = (props) => {
  return props.comments.map((comment) => {
    return <Comment comment={comment} />;
  });
};

export default CommentsList;
