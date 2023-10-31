import React from 'react';
import "./Seatmatrix.css";

function SeatMatrix({booked}) {
  const numRows = 20;
  const numColumns = 6;

  const renderSeats = () => {
    const seats = [];

    for (let row = 1; row <= numRows; row++) {
      for (let column = 1; column <= numColumns; column++) {
        const sNumber = (row - 1) * numColumns + column;
        seats.push(
          <div className={booked.includes(sNumber)?"seat redcol":"seat greencol" }
          key={sNumber}>
            {sNumber}
          </div>
        );
      }
    }

    return seats;
  };
  
  return (
     <div>
      <h1 className='header'>Seat Matrix</h1>
      <div className="seating-chart">
        {renderSeats()}
      </div>
    </div>
  );
}

export default SeatMatrix;
