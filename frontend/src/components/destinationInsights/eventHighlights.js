// EventHighlights.js
import React, { useState } from 'react';
import './destination.scss';

const EventHighlights = ({ events }) => {
  const [season, setSeason] = useState('All');

  const filteredEvents =
    season === 'All'
      ? events
      : events.filter((event) => event.season === season);

  return (
    <div className="event-highlights">
      <h3>Local Events and Highlights</h3>
      <label>
        Filter by Season:
        <select onChange={(e) => setSeason(e.target.value)} value={season}>
          <option value="All">All</option>
          <option value="Spring">Spring</option>
          <option value="Summer">Summer</option>
          <option value="Fall">Fall</option>
          <option value="Winter">Winter</option>
        </select>
      </label>
      <ul>
        {filteredEvents.map((event, index) => (
          <li key={index}>
            <h4>{event.name}</h4>
            <p>{event.description}</p>
            <small>{event.date}</small>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default EventHighlights;
