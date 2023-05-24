import React  from 'react';
import './Logout.css';

export default function Logout({ auth, authSet }) {

    const preOut = <div>
        <h1>Are you sure you want to logout?</h1>
        <img className="think" src={require('./think.png')} alt="a thinky face emoji"/>
    </div>;

    const out = <div>
    <h1>See you later!</h1>
    <img className="bye" src={require('./bye.jpef.jpg')} alt="a sad to see you go emoji"/>
</div>;

    const logButton = <button type="submit" value="Submit">Logout</button>
    const reLog = <button><a id="redirection" href="http://localhost:3000/login">Login?</a></button>

    const handleLogout = (e) => {
        e.preventDefault();
        authSet({isLoggedIn: false, isAdmin: false, name: ""});
        localStorage.setItem('logStatus', JSON.stringify({isLoggedIn: false, isAdmin: false, name: ""}));
    }

    return (
    <div className='logoutContainer' onSubmit={handleLogout}>
        <form>
            {auth.isLoggedIn
            ? preOut
            : out}
            {auth.isLoggedIn
            ? logButton
            : reLog}
        </form>
    </div>
  )
}
