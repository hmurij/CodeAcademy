import React from "react";
import { Button, Card, FloatingLabel, Form } from "react-bootstrap";

const NewCommentForm = (props) => {
  return (
    <Card
      className="py-2 px-3 bg-light"
      style={{ boxShadow: "5px 5px 10px grey" }}
    >
      <Form>
        <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
          <FloatingLabel label="Add new comment">
            <Form.Control as="textarea" rows={3} />
          </FloatingLabel>
        </Form.Group>
        <div className="d-flex justify-content-end">
          <Button variant="outline-primary" className="button" type="submit">
            Add New Comment
          </Button>
        </div>
      </Form>
    </Card>
  );
};

export default NewCommentForm;
