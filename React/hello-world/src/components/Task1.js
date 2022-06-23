import React, { useState } from "react";

const Task1 = (props) => {
  const [counter, setCounter] = useState(0);

  const count = () => {
    setCounter(counter + 1);
  };

  return (
    <div>
      <h1>{counter ? counter : props.message}</h1>
      <button onClick={count}>Click me</button>
    </div>
  );
};

export default Task1;
