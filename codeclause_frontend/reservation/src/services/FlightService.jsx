import axios from "axios";

const FLIGHTS_BASE_REST_API_URL = "http://localhost:8081/Search/allFlights";
const FLIGHTS_SEARCH_LOC_REST_API_URL =
  "http://localhost:8081/Search/allFlightsWithlocation";
class FlightService {
  getAllFlights() {
    return axios.get(FLIGHTS_BASE_REST_API_URL);
  }

  getAllFlightsByLocation(searchData) {
    return axios.get(FLIGHTS_SEARCH_LOC_REST_API_URL, searchData);
  }
}

export default new FlightService();
