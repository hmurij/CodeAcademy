import React, { useState } from 'react';

const ProductForm = (props) => {
  const [product, setProduct] = useState({
    name: '',
    price: 0,
    quantity: 0,
    description: '',
  });

  const onChange = (event) => {
    setProduct({
      ...product,
      [event.target.name]: event.target.value,
    });
  };

  const onSubmit = (event) => {
    event.preventDefault();
    console.log(product);
  };

  return (
    <form onSubmit={onSubmit}>
      <label>Name</label>
      <input type="text" name="name" value={product.name} onChange={onChange} />
      <label>Price</label>
      <input
        type="number"
        name="price"
        value={product.price}
        onChange={onChange}
      />
      <label>Quantity</label>
      <input
        type="number"
        name="quantity"
        value={product.quantity}
        onChange={onChange}
      />
      <label>Description</label>
      <input
        type="text"
        name="description"
        value={product.description}
        onChange={onChange}
      />
      <button>Buy</button>
    </form>
  );
};

export default ProductForm;
