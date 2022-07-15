import React from "react";

const BannerSuccess = ({ message }) => {
  return (
    <div className="col-sm-10 col-md-8 col-lg-6 mt-4 p-4 text-center text-success border border-success rounded-3 boxShadow">
      {message}
    </div>
  );
};

export default BannerSuccess;
