import React from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ListInstructorComponent from './components/ListInstructorComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateInstructorComponent from './components/CreateInstructorComponent';
import ViewInstructorComponent from './components/ViewInstructorComponent';

function App() {
  return (
    <div>
        <Router>
              <HeaderComponent />
                <div className="container">
                    <Switch> 
                          <Route path = "/" exact component = {ListInstructorComponent}></Route>
                          <Route path = "/instructors" component = {ListInstructorComponent}></Route>
                          <Route path = "/add-instructors/:id" component = {CreateInstructorComponent}></Route>
                          <Route path = "/view-instructors/:id" component = {ViewInstructorComponent}></Route>
                    </Switch>
                </div>
              <FooterComponent />
        </Router>
    </div>
    
  );
}

export default App;
