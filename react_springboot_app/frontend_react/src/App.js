import React, { Component } from 'react';
import './App.css';
import StudentApp from './component/StudentApp';

class App extends Component {
  render() {
    return (
      <div className="container">
        <StudentApp />
      </div>
    );
  }
}

export default App;
