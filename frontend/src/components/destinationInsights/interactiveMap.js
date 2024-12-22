// InteractiveMap.js
import React, { useEffect, useRef } from 'react';
import L from 'leaflet';
import 'leaflet/dist/leaflet.css';
import './destination.scss';

const InteractiveMap = ({ center, locations }) => {
  const mapRef = useRef(null);

  useEffect(() => {
    const map = L.map(mapRef.current).setView(center, 12);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '&copy; OpenStreetMap contributors',
    }).addTo(map);

    locations.forEach(({ lat, lng, name, duration }) => {
      L.marker([lat, lng])
        .addTo(map)
        .bindPopup(`<b>${name}</b><br>Travel Duration: ${duration}`);
    });

    return () => {
      map.remove();
    };
  }, [center, locations]);

  return <div ref={mapRef} style={{ height: '500px', width: '100%' }} />;
};

export default InteractiveMap;
