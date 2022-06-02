import logo from './logo.svg';
import './App.css';
import MyComponent from "./components/MyComponent";
import Task1 from "./components/Task1";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        {/*<h1>Hello World!</h1>*/}
        <MyComponent name={'friend'}></MyComponent>
        <Task1 message={"Test message"}/>

      </header>
    </div>
  );
}

export default App;
