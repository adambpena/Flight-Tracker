import React, { useState } from 'react';
import './Registration.css';
import axios from 'axios';

export default function Registration() {

    const [regAttempt, setRegAttempt] = useState({
        username: "",
        password: "",
        registerResult: "",
        registerDisplay: [],
        registerSuccess: false
    });

    const alterLogState = e => {
        const value = e.target.value;
        setRegAttempt({
            ...regAttempt,
            [e.target.name]: value
        })
        console.log(e.target.value)
    }


    const handleReg = async (e) => {
        setRegAttempt({...regAttempt, [regAttempt.registerDisplay]: []})
        e.preventDefault();
        await axios.post('http://localhost:8080/api/users/userRegistration', 
            {username: regAttempt.username, password: regAttempt.password})
            .then((response) => regAttempt.registerDisplay = response.data)
            .then(setRegAttempt({...regAttempt}));

        for(let i in regAttempt.registerDisplay){
            if( regAttempt.registerDisplay[i] !== "Success"){
                regAttempt.registerSuccess = false;
                setRegAttempt({...regAttempt});
            }
            else {
                console.log(regAttempt.registerDisplay[i]);
                regAttempt.registerSuccess = true;
                setRegAttempt({...regAttempt});
            }
        }
    }

    const registerPass = <li className="regSuc">Your account has been registered!<br></br> Login to your new account and start booking flights!</li>
    const registerFail = Array.from(regAttempt.registerDisplay).map((msg) => 
        (<li className="errors">{msg}</li>));

    const haveAccount = <p>Already have an account? </p>;
    const newAccount = <p>Just made a new account? </p>

    return (
    <div className='regContainer' onSubmit={handleReg}>
        <h1 className='reg'>Register</h1>
        <form className='regForm'>
            {/* <h1>{props.auth.isLoggedIn.toString()}</h1> */}
            <div className='credZone'>
                <p>Enter Username:</p>
                <input type="text" name="username" placeholder="Username" onChange={alterLogState} value={regAttempt.username}/>
            </div>
            <div className='credZone'>
                <p>Enter Password:</p>
                <input type="password" name="password" placeholder="Password" onChange={alterLogState} value={regAttempt.password}/>
            </div>
            <button type="submit" value="Submit">Register</button>
        </form>

        {regAttempt.registerSuccess ? registerPass : registerFail}

        <div className="loginR">
            {regAttempt.registerSuccess ? newAccount : haveAccount}
            <a id="logLink" href="http://localhost:3000/login">Click here to login</a>
        </div>
    </div>
  )
}
