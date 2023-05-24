import React from 'react';
import './Footer.css'

export default function Footer({auth, name}) {
    let greetings = "";

    if(auth.name === ""){
        greetings = <p>Login to register flights . . .</p>
    }
    else if(auth.name === "admin"){
        greetings = <p className="admin">welcome_admin !</p>
    }
    else{
        greetings = <p>Hello, {auth.name}!</p>
    }

    return(
        <div className={auth.name === "admin" ? "adminFootbar" : "footbar"}>
            <p className={auth.name === "admin" ? "adminFsf" : "fsf"}>Full Stack Flights</p>
            <img className={auth.name === "admin" ? "spaceInvader" : "paperPlane"}
            src={auth.name === "admin" ? require('./spaceinvader.png') : require('./send-mail.png')} 
            alt="a space invader or a cute paper plane"/>
            <div className='empty'></div>
            <div className="greet">
                {greetings}
            </div>
        </div>
    )
}
