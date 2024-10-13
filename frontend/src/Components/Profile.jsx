// Profile.js
import React from 'react';
import { useState ,useEffect} from 'react';
const Profile = () => {

  const [user, setUser] = useState({})
  useEffect(() => {
    fetch('http://localhost:8080/api/userinfo',{
      method: 'GET',
      credentials: "include",
    })
      .then((res) => res.json())
      .then((data) => {setUser(data)
        console.log(data);
      })
      .catch((err) => console.log(err))
      
      
  }, [])

  return (
    <div className="bg-white p-6 rounded shadow-md">
      <h1 className="text-xl font-bold">Profile</h1>
      <p>Name: {user.name}</p>
      <p>Contact Number: {user.phoneNumber}</p>
      <p>Balance: Rs.{user.amount}</p>
    </div>
  );
};

export default Profile;
