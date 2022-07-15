import React from "react";
import { Button, Spinner } from "react-bootstrap";

const SubmitButton = (props) => {
  return (
    <div className="d-flex justify-content-end">
      <Button
        variant="outline-primary"
        className={`${props.isSubmitting ? "disabled button" : "button"}`}
        type="submit"
      >
        <Spinner
          as="span"
          animation="border"
          size="sm"
          role="status"
          aria-hidden="true"
          className={`${!props.isSubmitting && "visually-hidden"}`}
        />
        <span className="ms-1">
          {!props.isSubmitting ? props.name : "Submitting"}
        </span>
      </Button>
    </div>
  );
};

export default SubmitButton;
