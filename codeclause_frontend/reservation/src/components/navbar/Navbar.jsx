import "./Navbar.css";
import { useContext} from "react";
import { AuthContext } from "../../components/context/AuthContext";
import { useNavigate } from "react-router-dom";

const Navbar = () => {
   const {user} = useContext(AuthContext);
    const navigate = useNavigate();
 const handleRegister= () => {
   navigate("/Register");
    };
    const handleLogin= () => {
   navigate("/Login");
    };
const handleLogout= () => {
  localStorage.removeItem('user');

   navigate("/Login");
    };

  return (
    <div className="navbar">
      <div className="navContainer">
        <span className="logo">Online Booking</span>
        {user? 
        <div className="user-container">
        {`Welcome ` + user.username} 
        <button className="navButton" onClick={handleLogout}>Logout</button>
        </div>
        :<div className="navItems">
          <button className="navButton" onClick={handleRegister}>Register</button>
          <button className="navButton" onClick={handleLogin}>Login</button>
        </div>}
      </div>
    </div>
  );
};

export default Navbar;
