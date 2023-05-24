import React, { useState } from 'react';
import axios from 'axios';
import './ViewFlights.css';

export default function ViewFlights({auth}) {
    const [allFlights, setAllFlights] = useState({
        userFlights: axios.get(`http://localhost:8080/api/userFlights/${auth.name}`)
        .then((response) => allFlights.userFlights = response.data)
        .then(() => setAllFlights({...allFlights}))
    });

    const removeFlight = (userid) => {
        axios.delete(`http://localhost:8080/api/userFlights/${userid}`)
        .then((response) => console.log(response))
        .then(axios.get(`http://localhost:8080/api/userFlights/${auth.name}`)
        .then((response) => allFlights.userFlights = response.data)
        .then(setAllFlights({...allFlights})))
    }

    return (
        <div id="flighttablediv">
            <table className="flightTable">
                <thead>
                    <tr>
                        <th>Count</th>
                        <th>Departing From</th>
                        <th>Arriving At</th>
                        <th>One Way Flight</th>
                        <th>Last Ticketing Date</th>
                        <th>Seats Left</th>
                        <th>Total Price</th>
                        <th id="removeColumn">Remove</th>
                    </tr>
                </thead>
                <tbody>
                    {Array.from(allFlights.userFlights).map((flight, selectedIndex) => (
                        <tr key={flight.id}>
                            <td>fn{flight.id}</td>
                            <td>{flight.departing}</td>
                            <td>{flight.arriving}</td>
                            <td>{flight.isOneWay.toString()}</td>
                            <td>{flight.lastTicketingDate}</td>
                            <td>{flight.seatsLeft}</td>
                            <td>{flight.totalPrice}</td>
                            <td className="delButtonContainer"><img className="deleteButton" src={require('./DeleteButton.png')}
                            onClick={() => removeFlight(flight.id)} alt="red deletion button"/></td>
                        </tr>
                    ))}
                </tbody>
            </table>

        </div>  
    )
}
