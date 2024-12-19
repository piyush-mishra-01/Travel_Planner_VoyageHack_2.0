import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'; 
import Navbar from './sharedComponents/navbar/Navbar';
import Sidebar from './components/sidebar/Sidebar';
import ForgotPassword from './components/auth/forgotPassword/ForgotPassword';
import Register from './components/auth/register/Register';
import Footer from './sharedComponents/footer/Footer';

// Corrected imports for the pages based on the folder structure


const App = () => {
  return (
    <Router>
      <Navbar />
      <Sidebar />
      <div className="main-content">
        <Routes>
          <Route path="/register" element={<Register/>} /> {/* Updated */}
          <Route path="/forgotpassword" element={<ForgotPassword/>} />
        </Routes>
      </div>
      <Footer />
    </Router>
  );
};

export default App;
