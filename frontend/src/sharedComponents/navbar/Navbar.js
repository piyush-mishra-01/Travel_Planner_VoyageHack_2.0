import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css'; // Import the CSS file
import Modal from '../../utils/modals/Modal';
import Login from '../../components/auth/login/Login';
import Register from '../../components/auth/register/Register';
import ForgotPassword from '../../components/auth/forgotPassword/ForgotPassword';

const Navbar = () => {
  const [loginModal, setLoginModal] = useState(false);
  const [registerModal, setRegisterModal] = useState(false);
  const [forgotPasswordModal, setForgotPasswordModal] = useState(false);

  const handleLoginClick = () => {
    setLoginModal(true);
  };

  const handleRegisterClickFromLogin = () => {
    setLoginModal(false);
    setRegisterModal(true);
  };

  const handleForgotPasswordClickFromLogin = () => {
    setLoginModal(false);
    setForgotPasswordModal(true);
  };

  const handleLoginClickFromRegister = () => {
    setRegisterModal(false);
    setLoginModal(true);
  };

  const handleLoginClickFromForgotPassword = () => {
    setForgotPasswordModal(false);
    setLoginModal(true);
  };

  return (
    <>
      <nav className="navbar">
        <div className="navbar-left">
          <Link to="/" className="website-name">Travel Planner</Link>
        </div>
        <div className="navbar-right">
          <Link to="/" className="navbar-link">Home</Link>
          <Link to="/itinerary-management" className="navbar-link">Itinerary</Link>
          <Link to="/destination-insights" className="navbar-link">Destination</Link>
          <Link to="/budget-management" className="navbar-link">Budget</Link>
          <Link to="/booking-integration" className="navbar-link">Booking</Link>
          <Link className="navbar-link" onClick={handleLoginClick}>Login</Link>
        </div>
      </nav>

      {/* Login Modal */}
      <Modal isOpen={loginModal} onClose={() => setLoginModal(false)} width={"30%"}>
        <Login 
          onClose={() => setLoginModal(false)} 
          onRegisterClick={handleRegisterClickFromLogin} 
          onForgotPasswordClick={handleForgotPasswordClickFromLogin} 
        />
      </Modal>

      {/* Register Modal */}
      <Modal isOpen={registerModal} onClose={() => setRegisterModal(false)} width={"30%"}>
        <Register 
          onClose={() => setRegisterModal(false)} 
          onLoginClick={handleLoginClickFromRegister} 
        />
      </Modal>

      {/* ForgotPassword Modal */}
      <Modal isOpen={forgotPasswordModal} onClose={() => setForgotPasswordModal(false)} width={"30%"}>
        <ForgotPassword onClose={() => setForgotPasswordModal(false)}
        onLoginClick={handleLoginClickFromForgotPassword} 
        />
      </Modal>
    </>
  );
};

export default Navbar;
