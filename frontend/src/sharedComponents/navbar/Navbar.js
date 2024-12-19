import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css'; // Make sure to import the CSS file
import { useState } from 'react';
import Modal from '../../utils/modals/Modal';
import Login from '../../components/auth/login/Login';

const Navbar = () => {
  const [loginModal,setLoginModal]=useState(false);

  const handleLoginClick=()=>{
      setLoginModal(true);
  };
  return (
    <><nav className="navbar">
      <div className="navbar-left">
        <Link to="/" className="website-name">Travel Planner</Link>
      </div>
      <div className="navbar-right">
        <Link to="/" className="navbar-link">Home</Link>
        <Link  className="navbar-link" onClick={handleLoginClick}>User Management</Link>
        <Link to="/itinerary-management" className="navbar-link">Itinerary</Link>
        <Link to="/destination-insights" className="navbar-link">Destination</Link>
        <Link to="/budget-management" className="navbar-link">Budget</Link>
        <Link to="/booking-integration" className="navbar-link">Booking</Link>
      </div>
    </nav>

    <Modal isOpen={loginModal} onClose={() => setLoginModal(false)} width={"30%"}>
        <Login onClose={() => setLoginModal(false)} />
      </Modal>
    </>
  );
};

export default Navbar;
