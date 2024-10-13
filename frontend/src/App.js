import React from "react";
import { BrowserRouter as Router, Routes, Route, Link, useLocation } from "react-router-dom";
import Login from "./Components/Login";
import Profile from './Components/Profile';
import Withdraw from './Components/Withdraw';
import Deposit from './Components/Deposit';
import History from './Components/History';

const App = () => {
  
  
  return (
    <Router>
      <div className="flex flex-col h-screen">
        
        {window.location.pathname !== '/' && (
          <nav className="bg-gray-800 p-4">
            <ul className="flex space-x-4">
              <li>
                <Link to="/profile" className="px-4 py-2 rounded focus:outline-none text-gray-300 hover:bg-gray-700">
                  Profile
                </Link>
              </li>
              <li>
                <Link to="/withdraw" className="px-4 py-2 rounded focus:outline-none text-gray-300 hover:bg-gray-700">
                  Withdraw
                </Link>
              </li>
              <li>
                <Link to="/deposit" className="px-4 py-2 rounded focus:outline-none text-gray-300 hover:bg-gray-700">
                  Deposit
                </Link>
              </li>
              <li>
                <Link to="/history" className="px-4 py-2 rounded focus:outline-none text-gray-300 hover:bg-gray-700">
                  History
                </Link>
              </li>
            </ul>
          </nav>
        )}

        <div className="flex-grow p-4">
        

          <Routes>
            <Route path="/" Component={Login} />
            <Route path="/profile" Component={Profile} />
            <Route path="/withdraw" Component={Withdraw} />
            <Route path="/deposit" Component={Deposit} />
            <Route path="/history" Component={History} />
            <Route path="*" Component={Profile} />
          </Routes>
        </div>
      </div>
    </Router>
  );
};

export default App;
