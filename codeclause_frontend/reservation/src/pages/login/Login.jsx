import axios from "axios";
import { useContext, useState } from "react";
import { useNavigate } from "react-router-dom";
import { AuthContext } from "../../components/context/AuthContext";

import "./Login.css";

const Login = () => {
  const [credentials, setCredentials] = useState({
    username: '',
    userpassword: '',
  });

  const {loading, error, dispatch } = useContext(AuthContext);

  const navigate = useNavigate();

  const handleChange = (e) => {
    setCredentials((prev) => ({ ...prev, [e.target.id]: e.target.value }));
  };

  const handleClick = async (e) => {
    e.preventDefault();
    dispatch({ type: "LOGIN_START" });
    
    try {
      console.log(credentials.username);
      console.log(credentials.userpassword);
      const response = await axios.post("http://localhost:9094/user/fetchUser", credentials);
      console.log(response);
     
      dispatch({ type: "LOGIN_SUCCESS", payload: response.data });
      
      navigate("/");
    } catch (err) {
  if (err.response) {
    dispatch({ type: "LOGIN_FAILURE", payload: err.response.data });
  } else {
    // Handle the error when there is no response object in the error
    console.error("Network error or other issue:", err);
  }
}
  };

  return (
    <div className="login">
  
      <div className="lContainer">
        <input
          type="text"
          placeholder="username"
          id="username"
          value={credentials.username}
          onChange={handleChange}
          className="lInput"
        />
        <input
          type="password"
          placeholder="password"
          id="userpassword"
          value={credentials.userpassword}
          onChange={handleChange}
          className="lInput"
        />
        <button disabled={loading} onClick={handleClick} className="lButton">
          Login
        </button>
        {error && <span>{error.message}</span>}
      </div>
    </div>
  );
};

export default Login;
