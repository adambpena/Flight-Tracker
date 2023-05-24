import React, { useState } from 'react';
import axios from 'axios';
import './ManageUsers.css'

export default function ManageUsers() {
    const [allUsers, setAllUsers] = useState({
        userbase: axios.get('http://localhost:8080/api/users/userRemoval')
        .then((response) => allUsers.userbase = response.data)
        .then(() => setAllUsers({...allUsers})),
        userDeleted: false,
        usersDeleted: 0
    });

    const removeUser = (userRem) => {
        console.log(userRem);
        axios.delete(`http://localhost:8080/api/users/userRemoval/${userRem}`)
        .then(axios.get('http://localhost:8080/api/users/userRemoval')
        .then((response) => allUsers.userbase = response.data)
        .then(setAllUsers({...allUsers})))
    }

    return (
        <div id="tablediv">
            <h2 className="manageHeader">Current Users:</h2>
            <table className="userTable">
                <thead>
                    <tr>
                        <th>Count</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th id="removeColumn">Remove</th>
                    </tr>
                </thead>
                <tbody>
                    {Array.from(allUsers.userbase).map((user, selectedIndex) => (
                        <tr key={selectedIndex + 1}>
                            <td>{selectedIndex + 1}</td>
                            <td>{user.username}</td>
                            <td>{user.password}</td>
                            <td className="delButtonContainer"><img className="deleteButton" src={require('./DeleteButton.png')}
                            onClick={() => removeUser(user.username)} alt="removal button"/></td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>  
    )
}
