import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import JoinComponent from "./joinComponent"
import * as serviceWorker from './serviceWorker';

ReactDOM.render(
  <React.StrictMode>
    <JoinComponent />
  </React.StrictMode>, document.getElementById('root'));

serviceWorker.unregister();
