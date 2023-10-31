import React from 'react';
import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

import "./Register.css";


const Register = () => {
  
   const [credentials, setCredentials] = useState({
    username: '',
    userpassword: '',
    address:'',
    city:''
  });

   const navigate = useNavigate();
  const handleInputChange = (e) => {
   setCredentials((prev) => ({ ...prev, [e.target.id]: e.target.value }));
  }

  const handleClick = async(e) => {
    e.preventDefault();
    const response = await axios.post("http://localhost:9094/user/addUser", credentials);
    console.log(response);
    navigate("/Login");

    
  }

  
    return (
      <div className="login">
     
      <div className="lContainer">
        <h2>Register</h2>
       
          <div>
            <label>Username:</label>
            <input
              type="text"
             id="username"
              value={credentials.username}
              onChange={handleInputChange}
              className="lInput"
            />
          </div>
          
          <div>
            <label>Password:</label>
            <input
              type="password"
              id="userpassword"
              value={credentials.userpassword}
              onChange={handleInputChange}
              className="lInput"
            />
          </div>

          <div>
            <label>Address:</label>
            <input
              type="text"
              id="address"
              value={credentials.email}
              onChange={handleInputChange}
              className="lInput"
            />
          </div>

          <div>
            <label>City:</label>
            <input
              type="text"
              id="city"
              value={credentials.city}
              onChange={handleInputChange}
              className="lInput"
            />
          </div>
          <button onClick={handleClick} className="lButton">Register  </button>
       
      </div>
      </div>
    );
  }


export default Register;
