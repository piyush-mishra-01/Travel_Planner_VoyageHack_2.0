import React from 'react';
import './Footer.css';

const Footer = () => {
  return (
    <footer className="footer">
  <div className="footer-left">
    <span className="footer-text">© 2024 Travel Planner</span>
  </div>
  <div className="footer-right">
    <a href="/" className="footer-link">Home</a>
    <a href="/about" className="footer-link">About</a>
    <a href="/contact" className="footer-link">Contact</a>
    <a href="/privacy-policy" className="footer-link">Privacy Policy</a>
  </div>
</footer>

  );
};

export default Footer;
