import React, { useState } from 'react';

const ItineraryBuilder = () => {
  const [itinerary, setItinerary] = useState([]);

  const addEvent = (event) => {
    setItinerary([...itinerary, event]);
  };

  return (
    <div className="itinerary-builder">
      <h2>Itinerary Builder</h2>
      <button onClick={() => addEvent('New Event')}>Add Event</button>
      <ul>
        {itinerary.map((event, index) => (
          <li key={index}>{event}</li>
        ))}
      </ul>
    </div>
  );
};

export default ItineraryBuilder;
