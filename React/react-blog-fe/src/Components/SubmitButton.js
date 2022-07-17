import React from "react";
import { Button, Spinner } from "react-bootstrap";

const SubmitButton = ({ isSubmitting, isSubmitted, name }) => {
  return (
    <div className="d-flex justify-content-end">
      <Button
        variant="outline-primary"
        className={`${isSubmitting ? "disabled button" : "button"}`}
        type="submit"
        disabled={isSubmitted}
      >
        <Spinner
          as="span"
          animation="border"
          size="sm"
          role="status"
          aria-hidden="true"
          className={`${!isSubmitting && "visually-hidden"}`}
        />
        <span className="ms-1">{!isSubmitting ? name : "Submitting"}</span>
      </Button>
    </div>
  );
};

export default SubmitButton;
