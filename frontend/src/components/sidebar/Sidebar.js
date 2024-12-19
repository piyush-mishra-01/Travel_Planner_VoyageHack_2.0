import React from 'react';
import './Sidebar.css'; // Import the Sidebar CSS file
import { Link } from 'react-router-dom';

const Sidebar = () => {
  return (
    <div className="sidebar">
      <div className="sidebar-header">
        <Link to="/" className="website-name">Travel Planner</Link>
      </div>
      <div className="sidebar-links">
        <Link to="/" className="sidebar-link">Home</Link>
        <Link to="/itinerary-management" className="sidebar-link">Itinerary</Link>
        <Link to="/destination-insights" className="sidebar-link">Destination</Link>
        <Link to="/budget-management" className="sidebar-link">Budget</Link>
        <Link to="/booking-integration" className="sidebar-link">Booking</Link>
        <Link to="/profile" className="sidebar-link">Profile</Link> {/* Added Profile link */}
      </div>
    </div>
  );
};

export default Sidebar;
