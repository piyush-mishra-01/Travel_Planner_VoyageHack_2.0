import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'; // Import Routes instead of Switch
import Navbar from './components/Navbar';
import Sidebar from './components/Sidebar';
import Footer from './components/Footer';

// Corrected imports for the pages based on the folder structure
import UserManagement from './pages/UserManagement/Login'; // Assuming Login.js is the main entry
import ItineraryManagement from './pages/ItineraryManagement/ItineraryBuilder';
import DestinationInsights from './pages/DestinationInsights/DestinationOverview';
import BudgetManagement from './pages/BudgetManagement/BudgetPlanner';
import BookingIntegration from './pages/BookingIntegration/BookingList';
import RecommendationEngine from './pages/RecommendationEngine/Suggestions';
import Collaboration from './pages/Collaboration/Chat';
import Notifications from './pages/Notifications/AlertList';

const App = () => {
  return (
    <Router>
      <Navbar />
      <Sidebar />
      <div className="main-content">
        <Routes> 
          <Route path="/user-management" element={<UserManagement />} />
          <Route path="/itinerary-management" element={<ItineraryManagement />} />
          <Route path="/destination-insights" element={<DestinationInsights />} />
          <Route path="/budget-management" element={<BudgetManagement />} />
          <Route path="/booking-integration" element={<BookingIntegration />} />
          <Route path="/recommendation-engine" element={<RecommendationEngine />} />
          <Route path="/collaboration" element={<Collaboration />} />
          <Route path="/notifications" element={<Notifications />} />
        </Routes>
      </div>
      <Footer />
    </Router>
  );
};

export default App;
