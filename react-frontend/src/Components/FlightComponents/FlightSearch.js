import React, { useState } from 'react';
import axios from 'axios';
import "./FlightSearch.css"

let date = new Date();
let year = date.getFullYear(); 
let month = date.getMonth();
if(month < 10){
    let monthDigit = month + 1;
    month = '0' + monthDigit
}
let day = date.getDate()+7;
if(day < 10){
    let dayDigit = day;
    day = '0' + dayDigit
}
let today = year + '-' + month +'-'+ day

export default function FlightSearch({ auth }) {
    const [searchQuery, setQuery] = useState({depart: "SYD",
                                        arrival: "BKK",
                                        departDate: today,
                                        adults: "1",
                                        isLoading: false,
                                        response: [] });
    
    const alterState = e => {
        const value = e.target.value;
        setQuery({
            ...searchQuery,
            [e.target.name]: value
        })
        console.log(e.target.value)
    }

    const performSearch = (event) => {
        event.preventDefault();
        setQuery({...searchQuery, [searchQuery.isLoading]: true})
        axios.get(`http://localhost:8080/api/flights/listConvert?departIata=${searchQuery.depart}&arrivalIata=${searchQuery.arrival}&departureDate=${searchQuery.departDate}&numAdults=${searchQuery.adults}`)
            .then((response) => searchQuery.response = response.data)
            .then(() => console.log(searchQuery.response))
            .then(() => setQuery({...searchQuery}))
            .then(setQuery({...searchQuery, [searchQuery.isLoading]: false}))

    }

    const addFlight = (flightNum) => {
        if(!auth.isLoggedIn){
            alert("Can't register flights unless logged in");
            return;
        }
        if(auth.isAdmin){
            alert("Admin cannot register flights");
            return;
        }
        else{
            axios.put('http://localhost:8080/api/userFlights/addFlight', { 
                name: auth.name,
                flightId: flightNum.toString()
            }).then((response) => console.log(response.data))
            .then(() => alert("Flight added!"));
        }
    }

  return (
    <div className="searchContainer">     
        <form className="searchBar" onSubmit={performSearch} name="searchString">
            <h2>Search For A Flight:</h2>
            <label>Departing From: </label>
            <input type="text" name="depart" placeholder="3-Letter Iata" onChange={alterState} value={searchQuery.depart}/>
            <label>Heading To: </label>
            <input type="text" name="arrival" placeholder="3-Letter Iata" onChange={alterState} value={searchQuery.arrival}/>
            <label>Leaving By: </label>
            <input type="text" name="departDate" placeholder="YYYY-MM-DD" onChange={alterState} value={searchQuery.departDate}/>
            <label>Number of Passengers: </label>
            <input type="number" name="adults" placeholder="Number of adults" onChange={alterState} value={searchQuery.adults}/>
            <br></br>
            <button type="submit" value="Submit">Search</button>
        </form>
        <table className="searchTable">
            <thead className="searchHead">
                <tr>
                    <th>Result</th>
                    <th>Departing From</th>
                    <th>Arriving At</th>
                    <th>One Way Flight</th>
                    <th>Last Ticketing Date</th>
                    <th>Seats Left</th>
                    <th>Total Price</th>
                    <th id="addColumn">ADD</th>
                </tr>
            </thead>
            <tbody>
            {Array.from(searchQuery.response).map((results) => (
                    <tr key={results.id}>
                        <td>{results.id}</td>
                        <td>{results.departing}</td>
                        <td>{results.arriving}</td>
                        <td>{results.isOneWay.toString()}</td>
                        <td>{results.lastTicketingDate}</td>
                        <td>{results.seatsLeft}</td>
                        <td>{results.totalPrice}</td>
                        <td id="addFlight"><img id="addFlightimg" 
                        src={require('./FlightBookingButton.png')} onClick={() => addFlight(results.id)} alt="gold add button"/></td>
                </tr>))
                }
            </tbody>
        </table>
        <div className='numResults'>Number of Results: {searchQuery.response.length}</div>
    </div>
  )
}
