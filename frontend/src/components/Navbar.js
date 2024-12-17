import React from 'react';
import { Link } from 'react-router-dom';

const Navbar = () => {
  return (
    <nav className="navbar">
      <Link to="/">Home</Link>
      <Link to="/user-management">User Management</Link>
      <Link to="/itinerary-management">Itinerary</Link>
      <Link to="/destination-insights">Destination</Link>
      <Link to="/budget-management">Budget</Link>
      <Link to="/booking-integration">Booking</Link>
    </nav>
  );
};

export default Navbar;
