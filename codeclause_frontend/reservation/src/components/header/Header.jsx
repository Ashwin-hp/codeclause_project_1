import {
  faBed,
  faCalendarDays,
  faCar,
  faPlane,
  faTaxi
} from "@fortawesome/free-solid-svg-icons";
import Datepicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { FaCalendarAlt } from "react-icons/fa";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import "./Header.css";
import { DateRange } from "react-date-range";
import { useState } from "react";
import "react-date-range/dist/styles.css"; // main css file
import "react-date-range/dist/theme/default.css"; // theme css file
import { format } from "date-fns";
import { useNavigate } from "react-router-dom";

function CustomInput({ value, onClick }) {
  return (
    <div className="input-group">
      <input
        type="text"
        className="form-control"
        value={value}
        onClick={onClick}
        readOnly
      />
      <div className="input-group-append">
        <span className="input-group-text">
          <FaCalendarAlt />
        </span>
      </div>
    </div>
  );
}

const Header = ({ type }) => {

  const [selectedDate, setDate] = useState(new Date());
  const [destination, setDestination] = useState("");
  const [source, setSource] = useState("");

  const navigate = useNavigate();

  const handleSearch = () => {
   // const searchData = {source,destination,selectedDate};

   const formattedDate = new Date(selectedDate).toLocaleDateString();
  
   
   
   navigate("/List", { state: { source, destination, formattedDate } });
  
  };

  return (
    <div className="header">
      <div
        className={
          type === "list" ? "headerContainer listMode" : "headerContainer"
        }
      >
        <div className="headerList">
          <div className="headerListItem active">
            <FontAwesomeIcon icon={faPlane} />
            <span>Flights</span>
          </div>
          <div className="headerListItem ">
            <FontAwesomeIcon icon={faBed} />
            <span>Stays</span>
          </div>

          <div className="headerListItem">
            <FontAwesomeIcon icon={faCar} />
            <span>Car rentals</span>
          </div>
          <div className="headerListItem">
            <FontAwesomeIcon icon={faBed} />
            <span>Attractions</span>
          </div>
          <div className="headerListItem">
            <FontAwesomeIcon icon={faTaxi} />
            <span>Airport taxis</span>
          </div>
        </div>
        {type !== "list" && (
          <>
            <h1 className="headerTitle">
              A lifetime of discounts? It's Genius.
            </h1>
            <p className="headerDesc">
              Get rewarded for your travels – unlock instant savings of 10% or
              more with a free booking account
            </p>
            <button className="headerBtn">Sign in / Register</button>
            <div className="headerSearch">
              <div className="headerSearchItem">
                <input
                  type="text"
                  placeholder="From"
                  className="headerSearchInput"
                  onChange={(e) => setSource(e.target.value)}
                />
              </div>
              <div className="headerSearchItem">
                <input
                  type="text"
                  placeholder="To"
                  className="headerSearchInput"
                  onChange={(e) => setDestination(e.target.value)}
                />
              </div>
              <div className="headerSearchItem">
                <label>
                  <Datepicker
                    selected={selectedDate}
                    onChange={(date) => setDate(date)}
                    customInput={<CustomInput />}
                  />
                </label>
              </div>

              <div className="headerSearchItem">
                <button className="headerBtn" onClick={handleSearch}>
                  Search
                </button>
              </div>
            </div>
          </>
        )}
      </div>
    </div>
  );
};


export default Header;