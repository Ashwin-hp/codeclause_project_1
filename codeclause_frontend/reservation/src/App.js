import {Routes, Route } from "react-router-dom";
import Home from "./pages/home/Home";
import List from "./pages/list/List";
import Flightdetail from "./pages/flightdetail/Flightdetail";
import Login from "./pages/login/Login";
import Register from "./pages/register/Register";
import Addflight from "./pages/addflight/Addflight";
import "./App.css"

const App = () => {
  return (
    <div>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/List" element={<List />} />
        <Route path="/Flightdetail/:id" element={<Flightdetail />} />
         <Route path="/login" element={<Login/>}/>
          <Route path="/Register" element={<Register/>}/>
          <Route path="/Addflight" element={<Addflight/>}/>
          
      </Routes>
    </div>
  );
};

export default App;
