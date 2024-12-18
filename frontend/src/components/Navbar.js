import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css'; // Make sure to import the CSS file

const Navbar = () => {
  return (
    <nav className="navbar">
      <div className="navbar-left">
        <Link to="/" className="website-name">Travel Planner</Link>
      </div>
      <div className="navbar-right">
        <Link to="/" className="navbar-link">Home</Link>
        <Link to="/user-management" className="navbar-link">User Management</Link>
        <Link to="/itinerary-management" className="navbar-link">Itinerary</Link>
        <Link to="/destination-insights" className="navbar-link">Destination</Link>
        <Link to="/budget-management" className="navbar-link">Budget</Link>
        <Link to="/booking-integration" className="navbar-link">Booking</Link>
      </div>
    </nav>
  );
};

export default Navbar;
