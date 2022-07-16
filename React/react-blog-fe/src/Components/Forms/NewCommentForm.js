import React from "react";
import { Button, Card, FloatingLabel, Form } from "react-bootstrap";

const NewCommentForm = (props) => {
  return (
    <Card className="mb-4 py-2 px-3 bg-light boxShadow">
      <Form>
        <Form.Group className="mb-2" controlId="exampleForm.ControlTextarea1">
          <FloatingLabel label="Add new comment">
            <Form.Control as="textarea" rows={3} />
          </FloatingLabel>
        </Form.Group>
        <div className="d-flex mb-2 justify-content-end">
          <Button variant="outline-primary" className="button" type="submit">
            Add New Comment
          </Button>
        </div>
      </Form>
    </Card>
  );
};

export default NewCommentForm;
