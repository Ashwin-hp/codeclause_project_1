This is a full stack airline reservation app.

Frontend: Uses HTML, CSS for styling and ReactJS.
Has the following pages: Home, Login, Register, flightdetail and Add flight.

Backend: Uses technologies like Spring, SpringBoot, Hibernate to connect with the pastgreSQL database and MongoDB.
It also incorporates the concept of "microservices".

There are 3 microservices namely,
clientinfo: stores the client's details and has api calls to and from postgreSQL server
Flight_search: Has apis to search for a particular flight based on id and fetch list of flights.
Flight_Booking: Creates a booking request with the help of client and flight details and stores it in MongoDB.

These "microservices" communicate with each other with the help of a "Eureka service registry".

To run  the app:

back-end part: 
Start the Eureka server by navigating to Eureka_server>src>main>java> {and the .java file in that directory} and clicking the "RUN" button on the top-right corner.
Then start each of the microservices by navigating to {particular microservice}>src>main>java> {and the .java file in that directory} and clicking the "RUN" button on the top-right corner.

front-end part:  Navigate to the reservation directory and type "npm start" in the terminal.
Then go to localhost:8080 and that's it!
Happy coding!!!
