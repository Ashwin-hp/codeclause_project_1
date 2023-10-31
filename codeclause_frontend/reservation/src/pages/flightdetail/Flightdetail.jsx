import Navbar from "../../components/navbar/Navbar";
import { useParams} from 'react-router-dom';
import React, { useState, useEffect } from 'react';
import { useContext} from "react";
import { AuthContext } from "../../components/context/AuthContext";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./Flightdetail.css"
import SeatMatrix from "../../components/seatmatrix/Seatmatrix.js"


const Flightdetail = () => {
 const [flight, setFlight] = useState([])
 const [orders, setOrders] = useState([])
 const [booked, setBooked] = useState([])
  const {id}=useParams();
  // console.log(id);
  const {user} = useContext(AuthContext);
  const [passengers, setPassengers] = useState([]);


   useEffect(() => {
    
    getFlightdetails();
    getbookingsbyflightid()
    console.log(booked);
}, [])

const getFlightdetails = () => {

  const url = 'http://localhost:8081/Search/fetchById/'+ id;

  axios.get(url).then((response)=>{
      setFlight(response.data)
        }).catch(error =>{
    console.log(error);
})
};

const getbookingsbyflightid = () => {

  const url = 'http://localhost:9095/booking/byFlightId/'+ id;

  axios.get(url).then((res)=>{
      setOrders(res.data);
      console.log(res);
      const seats = res.data.reduce((accumulator, item) => {
  if (item.passengerList) {
    const seatNumbers = item.passengerList.map(passenger => passenger.seatnum);
    return accumulator.concat(seatNumbers);
  }
  return accumulator;
}, []);

setBooked(seats);

}).catch(error =>{
    console.log(error);
}

)
};
 
const navigate = useNavigate();
  const BookingDetails={
    passengerList:passengers,
    id:id,
    userid:user.userid,
   
  };
  

const [name, setName] = useState('');
const [age, setAge] = useState('');
const [seatnum, setSeatnum] = useState('');


// Other fields...
const handleSubmit = (e) => {
  e.preventDefault();
  const newPassenger = { name, age, seatnum };
  setPassengers([...passengers, newPassenger]);

   
    // Clear the input fields
 
  setName('');
  setAge('');
  setSeatnum('');

  // Clear other fields...
  };

   const handlebooking = async(e) => {
    e.preventDefault();
    //console.log(BookingDetails);
    const response = await axios.post("http://localhost:9095/booking/saveBooking", BookingDetails);
    
    navigate("/");

    
  }

return (
  <div className="login">
  <div className="lContainer">
  <h2>Flight Details</h2>
<div className="form-container">

        <div className="form-column">
          <div className="form-group">
            <label htmlFor="field1">Airlines: </label>
             <label htmlFor="field2">{flight.Airlines}</label>
          </div>
          <div className="form-group">
            <label htmlFor="field2">Flight number: </label>
            <label htmlFor="field2">{flight.Flight_num}</label>
            
          </div>
          <div className="form-group">
            <label htmlFor="field3">Journey Date: </label>
            <label htmlFor="field3">{flight.flight_date}</label>
            
          </div>
          <div className="form-group">
            <label htmlFor="field4">Charge: </label>
           <label htmlFor="field3">Rs. {flight.Flight_charge}</label>
          </div>
        </div>

        <div className="form-column">
          <div className="form-group">
            <label htmlFor="field5">From: </label>
            <label htmlFor="field5">{flight.departure_location}</label>
            </div>
          <div className="form-group">
            <label htmlFor="field6">To: </label>
            <label htmlFor="field6">{flight.arrival_location}</label>
            </div>
          <div className="form-group">
            <label htmlFor="field7">Departure Time: </label>
            <label htmlFor="field7">{flight.departure_time}</label>   
            </div>        
          <div className="form-group">
            <label htmlFor="field8">Arrival Time: </label>
            <label htmlFor="field8">{flight.arrival_time}</label>
            </div>
        </div>
      </div>



    <h6>Add Passenger</h6>
    <form onSubmit={handleSubmit}>
        
        <input className="lInput" type="text" value={name} placeholder="Name"
        onChange={(e) => setName(e.target.value)} />
      
        <input  className="lInput" type="number" value={age} 
        placeholder="Age"
        onChange={(e) => setAge(e.target.value)} />
        
        <input  className="lInput" type="number" value={seatnum}
        placeholder="Seat number"
        onChange={(e) => setSeatnum(e.target.value)} />
      <br/>
      <button  className="lButton" type="submit">Add Passenger</button>
    </form>
   
    <div>
  <h6>Passenger List</h6>
  {/* Render the form here */}
  <ul>
    {passengers.map((passenger, index) => (
      <li key={index}>
        Name: {passenger.name}, Age: {passenger.age}, Seatnumber: {passenger.seatnum}
        {/* Display other passenger details */}
      </li>
    ))}
  </ul>
</div>



 
 <label className="basic">Total Flight charges:Rs. {passengers.length*flight.Flight_charge}</label>
 <label className="basic">Taxes and airport charges (+): Rs.1500</label>
  <label className="basic">Total charges:Rs. {passengers.length===0?0:(passengers.length*flight.Flight_charge + 1500)}</label>
  <button onClick={handlebooking} className="lButtonbook">Book ticket</button>
  
  </div>
  <SeatMatrix booked={booked}/>
 </div>

);
}

export default Flightdetail;
