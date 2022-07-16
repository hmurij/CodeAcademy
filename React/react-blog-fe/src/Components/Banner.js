import React from "react";

const Banner = ({ message, className }) => {
  return (
    <div
      className={`col - sm - 10 col-md-8 col-lg-6 p-4 text-center border rounded-3 boxShadow ${className}`}
    >
      {message}
    </div>
  );
};

export default Banner;
