import React, { useState } from 'react';
import './App.css';
import FlightSearch from './Components/FlightComponents/FlightSearch';
import Navbar from './Components/Navbar/Navbar';
import Login from './Components/UserComponents/Login/Login';
import Footer from './Components/Footer/Footer';
import Logout from './Components/UserComponents/Logout/Logout';
import Registration from './Components/UserComponents/Registration/Registration';
import ManageUsers from './Components/UserComponents/ManageUsers/ManageUsers';
import ViewFlights from './Components/UserComponents/ViewFlights/ViewFlights';

function App() {

  const[logStatus, setLogStatus] = useState(
    JSON.parse(localStorage.getItem('logStatus'))
    ? JSON.parse(localStorage.getItem('logStatus'))
    : {
      isLoggedIn: false,
      isAdmin: false,
      name: ""
    }
  )  

  switch(window.location.pathname){
      case '/':
        return (
        <div className="App">
          <Navbar auth={logStatus}/>
          <FlightSearch auth={logStatus}/>
          <Footer auth={logStatus}/>
        </div>)
      case '/login':
        return (
        <div className="App">
          <Navbar auth={logStatus}/>
          <Login auth={logStatus} authSet = {setLogStatus}/>
          <Footer auth={logStatus}/>
        </div>)
      case '/logout':
        return (
        <div className="App">
          <Navbar auth={logStatus}/>
          <Logout auth={logStatus} authSet = {setLogStatus}/>
          <Footer auth={logStatus}/>
        </div>)
      case '/registration':
        return (
        <div className="App">
          <Navbar auth={logStatus}/>
          <Registration auth={logStatus} authSet = {setLogStatus}/>
          <Footer auth={logStatus}/>
        </div>)
      case '/manageUsers':
        return (
          <div className="App">
            <Navbar auth={logStatus}/>
            <ManageUsers auth={logStatus}/>
            <Footer auth={logStatus}/>
          </div>)
      case '/viewflights':
        return (
          <div className="App">
            <Navbar auth={logStatus}/>
            <ViewFlights auth={logStatus}/>
            <Footer auth={logStatus}/>
          </div>)
      default:
        return (
          <div >
            <Navbar auth={logStatus}/>
            <div className='oops'>
              <h1>You're out of bounds. . . <br></br>check out the navbar and get back on track</h1>
              <img className="skelly" src={require('./skeleton.gif')}></img>
            </div>
            <Footer auth={logStatus}/>
          </div>
        )
        
      }
  
}

export default App;
