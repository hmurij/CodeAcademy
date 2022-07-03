import React, { useState } from "react";
import Header from "./Components/Header/Header";
import Main from "./Components/Pages/Main";
import Footer from "./Components/Footer/Footer";

function App() {
  const [headerHeight, setHeaderHeight] = useState(0);
  const heightChangeHandler = (height) => {
    setHeaderHeight(height);
  };

  return (
    <>
      <Header onHeightChange={heightChangeHandler} />
      <Main headerHeight={headerHeight} />
      <Footer />
    </>
  );
}

export default App;
