import React from "react";
import {useState, useEffect} from 'react';
import { Link , useLocation} from 'react-router-dom';
import axios from 'axios';
import Navbar from "../../components/navbar/Navbar";




const List = () => {
  const [flights, setFlights] = useState([])
  const location = useLocation();
  const [source,setSource] = useState(location.state.source);
  const[destination,setDestination]= useState(location.state.destination);
  const[formattedDate,setFormattedDate]= useState(location.state.formattedDate);


  useEffect(() => {
    console.log(source,destination,formattedDate);
    getAllFlights();
   
}, [])

const getAllFlights = () => {

  const url = 'http://localhost:8081/Search/allFlightsWithlocation';
const params = {
  departure_location: source,
  arrival_location: destination,
  flight_date:formattedDate,
};

  axios.get(url, { params }).then((response)=>{
      setFlights(response.data)
      console.log(response);
  }).catch(error =>{
    console.log(error);
})
}

  return (
    <div className = "container">
    <Navbar/>
    <h2 className = "text-center" > List of Flights </h2>
    
    <table className="table table-bordered table-striped">
        <thead>
            <th> Flight Id </th>
            <th> Flight Number </th>
            <th> From</th>
            <th> To</th>
            <th> Departure Time </th>
            <th> Arrival Time </th>
            <th> Flight Date</th>
        </thead>
        <tbody>
            {
                flights.map(
                    flight =>
                    <tr key = {flight.id}> 
                        <td> {flight.id} </td>
                        <td> {flight.Flight_num} </td>
                        <td> {flight.departure_location} </td>
                        <td>{flight.arrival_location} </td>
                        <td>{flight.departure_time} </td>
                        <td>{flight.arrival_time} </td>
                        <td>{flight.flight_date} </td>
                        <td>
                            <Link className="btn btn-info" to={`/Flightdetail/${flight.id}`}>Book</Link>
                          
                        </td>
                    </tr>
                )
            }
        </tbody>
    </table>
</div>
    
    
  )
};
export default List;
