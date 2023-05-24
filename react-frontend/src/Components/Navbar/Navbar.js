import React from 'react'
import './Navbar.css'


export default function Navbar({ auth, name}) {

  const login = 
    <a className={auth.name === "admin" ? ("admin-hvr-underline-from-left, admin-button") : "hvr-underline-from-left"}
     href="/login">Login</a>;
  const logout = 
    <a className={auth.name === "admin" ? "admin-hvr-underline-from-left" : "hvr-underline-from-left"}
    href="/logout">Logout</a>

  const viewFlights = 
    <a className={auth.name === "admin" ? "admin-hvr-underline-from-left" : "hvr-underline-from-left"}
      href="/viewflights">View Your Flights</a>;
  const registration = 
    <a className={auth.name === "admin" ? "admin-hvr-underline-from-left" : "hvr-underline-from-left"} 
    href="/registration">Register</a>;

  const manageUsers = 
    <a className={auth.name === "admin" ? "admin-hvr-underline-from-left" : "hvr-underline-from-left"}
    href="/manageUsers">Manage Users</a>;

  return (
    <div className={auth.name === "admin" ? "adminNavbar" : "navbar"}>
      <a className={auth.name === "admin" ? "admin-hvr-underline-from-left" : "hvr-underline-from-left"} href="/">Search Flights</a>
      {auth.isLoggedIn 
      ? logout
      : login}
      {auth.isAdmin
        ? manageUsers
        : (auth.isLoggedIn 
          ? viewFlights
          : registration)
      }
    </div>
  )
}
