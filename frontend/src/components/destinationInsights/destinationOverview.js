
// DestinationOverview.js
import React, { useState } from 'react';
import './destination.scss';

const DestinationOverview = ({ data }) => {
  const [view, setView] = useState('Attractions');

  const renderContent = () => {
    switch (view) {
      case 'Attractions':
        return (
          <ul>
            {data.attractions.map((attraction, index) => (
              <li key={index}>{attraction}</li>
            ))}
          </ul>
        );
      case 'Customs':
        return <p>{data.localCustoms}</p>;
      case 'Dining':
        return (
          <ul>
            {data.diningOptions.map((place, index) => (
              <li key={index}>{place}</li>
            ))}
          </ul>
        );
      case 'Transport':
        return <p>{data.transportOptions}</p>;
      default:
        return null;
    }
  };

  return (
    <div className="destination-overview">
      <h2>{data.name}</h2>
      <div>
        {['Attractions', 'Customs', 'Dining', 'Transport'].map((category) => (
          <button
            key={category}
            onClick={() => setView(category)}
            style={{ margin: '5px', padding: '10px' }}
          >
            {category}
          </button>
        ))}
      </div>
      <div className="content">{renderContent()}</div>
    </div>
  );
};

export default DestinationOverview;
