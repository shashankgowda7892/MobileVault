import React, { useEffect } from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
const Login = () => {
  
  const [number, setNumber] = useState("");
  const [otp, setOtp] = useState("");
  const [otpSent, setOtpSent] = useState(false); 
  const navigate = useNavigate();


    // Direct Login
  // useEffect(() => {
  //   fetch("http://localhost:8080/api/login", {
  //     method: "GET",
  //     credentials: "include",
  //   })
  // }, []);


  const handleSubmit = async (e) => {
    e.preventDefault();
    const response = await fetch("http://localhost:8080/api/sendOtp", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
       },
      body: JSON.stringify({ phoneNumber: number }),
      credentials: "include",
    });

    if (response.ok) {
      alert("OTP sent successfully");
      setOtpSent(true); 
    } else {
      alert("Failed to send OTP");
    }
  };

  const handleVerifyOtp = async (e) => {
    e.preventDefault();
    const response = await fetch("http://localhost:8080/api/verifyOtp", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ phoneNumber: number, otp: otp }),
      credentials: "include",
    });

    if (response.ok) {
      alert("OTP verified successfully!");
      navigate("/profile");

    } else {
      alert("Invalid OTP. Please try again.");
    }
  };

  return (
    <div className="flex items-center justify-center h-screen bg-gray-100">
      <form
        onSubmit={otpSent ? handleVerifyOtp : handleSubmit}
        className="bg-white p-14 rounded shadow-md"
      >
        {otpSent ? (
          <>
            <div className="mb-4">
              <label className="block text-gray-700 text-sm font-bold mb-5" htmlFor="otp">
                Enter OTP
              </label>
              <input
                type="text"
                id="otp"
                name="otp"
                maxLength={4}
                pattern="\d{4}"
                value={otp}
                onChange={(e) => setOtp(e.target.value)}
                className="appearance-none border border-gray-300 rounded w-full py-2 px-3 text-gray-700 focus:outline-none focus:border-blue-500"
                placeholder="Enter OTP"
                required
              />
            </div>
            <button
              type="submit"
              className="w-full bg-blue-500 text-white font-bold py-2 px-4 rounded hover:bg-blue-700 focus:outline-none focus:shadow-outline"
            >
              Verify OTP
            </button>
          </>
        ) : (
          <>
            <div className="mb-4">
              <label className="block text-gray-700 text-sm font-bold mb-5" htmlFor="phone">
                Phone Number
              </label>
              <div className="flex">
                <span className="flex items-center bg-gray-200 px-3 rounded-l text-gray-700">
                  +91
                </span>
                <input
                  type="text"
                  id="phone"
                  name="phone"
                  maxLength="10"
                  pattern="\d{10}"
                  value={number}
                  onChange={(e) => setNumber(e.target.value)}
                  className="appearance-none border border-gray-300 rounded-r w-full py-2 px-3 text-gray-700 focus:outline-none focus:border-blue-500"
                  placeholder="Enter your phone number"
                  required
                />
              </div>
            </div>
            <button
              type="submit"
              className="w-full bg-blue-500 text-white font-bold py-2 px-4 rounded hover:bg-blue-700 focus:outline-none focus:shadow-outline"
            >
              Submit
            </button>
          </>
        )}
      </form>
    </div>
  );
};

export default Login;
