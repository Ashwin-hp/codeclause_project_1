import React from 'react';
import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./addflight.css";
import {
    faCalendarDays
  
} from "@fortawesome/free-solid-svg-icons";
import Datepicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { FaCalendarAlt } from "react-icons/fa";


const Addflight = () => {
  
   const [flightdetails, setFlightdetails] = useState({
    Airlines:'',
    Flight_num: '',
    departure_location: '',
    arrival_location:'',
    departure_time:'',
    arrival_time:'',
     flight_date:'',
     Flight_charge:0
  });
  

   const navigate = useNavigate();

  const handleInputChange = (e) => {
   setFlightdetails((prev) => ({ ...prev, [e.target.id]: e.target.value }));
  }


  const handleClick = async(e) => {
    e.preventDefault();
    
    console.log(flightdetails);
    
    
    const response = await axios.post("http://localhost:8081/Search/addFlight",flightdetails);
    console.log(response);
   
  }

  
    return (
      <div className="login">
      <div className="lContainer">
        <h2>Add Flight</h2>
        <div>
            <label>Airlines:</label>
            <input
              type="text"
             id="Airlines"
              value={flightdetails.Airlines}
              onChange={handleInputChange}
              className="lInput"
            />
          </div>
       
          <div>
            <label>Flight Number:</label>
            <input
              type="text"
             id="Flight_num"
              value={flightdetails.Flight_num}
              onChange={handleInputChange}
              className="lInput"
            />
          </div>
    
          <div>
            <label>Departure Location:</label>
            <input
              type="text"
              id="departure_location"
              value={flightdetails.departure_location}
              onChange={handleInputChange}
              className="lInput"
            />
          </div>

          <div>
            <label>Arrival Location:</label>
            <input
              type="text"
              id="arrival_location"
              value={flightdetails.arrival_location}
              onChange={handleInputChange}
              className="lInput"
            />
          </div>

          <div>
            <label>Departure Time:</label>
            <input
              type="text"
              id="departure_time"
              value={flightdetails.departure_time}
              onChange={handleInputChange}
              className="lInput"
            />
          </div>
          <div>
            <label>Arrival Time:</label>
            <input
              type="text"
              id="arrival_time"
              value={flightdetails.arrival_time}
              onChange={handleInputChange}
              className="lInput"
            />
          </div>
          <div>
            <label>Flight Date:</label>
            <input
              type="text"
              id="flight_date"
              value={flightdetails.flight_date}
              onChange={handleInputChange}
              className="lInput"
            />
          </div>
          <div>
            <label>Flight Charge:</label>
            <input
              type="text"
             id="Flight_charge"
              value={flightdetails.Flight_charge}
              onChange={handleInputChange}
              className="lInput"
            />
          </div>
          
          <button onClick={handleClick} className="lButton">Add Flight </button>
       
      </div>
      </div>
    );
  }


export default Addflight;
