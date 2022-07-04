import React, { useState } from "react";
import Header from "./Components/Header/Header";
import Footer from "./Components/Footer/Footer";
import Pages from "./Components/Pages/Pages";
import { BrowserRouter } from "react-router-dom";

function App() {
  const [headerHeight, setHeaderHeight] = useState(0);
  const heightChangeHandler = (height) => {
    setHeaderHeight(height);
  };

  return (
    <BrowserRouter>
      <Header onHeightChange={heightChangeHandler} />
      <Pages headerHeight={headerHeight} />
      <Footer />
    </BrowserRouter>
  );
}

export default App;
