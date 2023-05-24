import React, { useState, } from 'react';
import './Login.css';
import axios from 'axios';

export default function Login({ authSet}) {

    const [logAttempt, setLogAttempt] = useState({
        username: "",
        password: "",
        loginResult: ""
    });

    const alterLogState = e => {
        const value = e.target.value;
        setLogAttempt({
            ...logAttempt,
            [e.target.name]: value
        })
        console.log(e.target.value)
    }


    const handleLogin = async (e) => {
        e.preventDefault();
        await axios.post('http://localhost:8080/api/users/userLogin', 
            {username: logAttempt.username, password: logAttempt.password})
            .then((response) => logAttempt.loginResult = response.data);
        setLogAttempt({...logAttempt, [logAttempt.loginResult]: logAttempt.loginResult});
        if(logAttempt.loginResult === "Login Success"){
            authSet({isLoggedIn: true, isAdmin: false, name: logAttempt.username});
            localStorage.setItem('logStatus', JSON.stringify({isLoggedIn: true, isAdmin: false, name: logAttempt.username}));
        }
        if(logAttempt.loginResult === "Admin login success"){
            authSet({isLoggedIn: true, isAdmin: true, name: logAttempt.username});
            localStorage.setItem('logStatus', JSON.stringify({isLoggedIn: true, isAdmin: true, name: logAttempt.username}));
        }
    }

    return (
    <div className='loginContainer' onSubmit={handleLogin}>
        <h1 className='login'>Login</h1>
        <form className='loginForm'>
            {/* <h1>{props.auth.isLoggedIn.toString()}</h1> */}
            <div className='credZone'>
                <p>Enter Username:</p>
                <input type="text" name="username" placeholder="Username" onChange={alterLogState} value={logAttempt.username}/>
            </div>
            <div className='credZone'>
                <p>Enter Password:</p>
                <input type="password" name="password" placeholder="Password" onChange={alterLogState} value={logAttempt.password}/>
            </div>
            <button type="submit" value="Submit">Login</button>
        </form>
        <p className="result">{logAttempt.loginResult}</p>
        <div className="register">
            <p>Don't have an account? </p>
            <a id="regLink" href="http://localhost:3000/registration">Click here to register</a>
        </div>
    </div>
  )
}
