// Deposit.js
import React, { useState } from 'react';

const Deposit = () => {
  const [amount, setAmount] = useState('');

  const handleDeposit = async () => {
    const response = await fetch('http://localhost:8080/api/deposit', {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ "amount":amount }),
      credentials: 'include',
    });

    if (response.ok) {
      const message = await response.text();
      
      alert(message);
      setAmount('');

    } else {
      console.error('');
    }
  };

  return (
    <div className="bg-white p-6 rounded shadow-md">
      <h1 className="text-xl font-bold">Deposit</h1>
      <input
        type="number"
        value={amount}
        name='amount'
        onChange={(e) => setAmount(e.target.value)}
        placeholder="Enter amount"
        className="border rounded p-2 mt-2 w-full"
      />
      <button
        onClick={handleDeposit}
        className="bg-blue-500 text-white mt-2 p-2 rounded"
      >
        Deposit
      </button>
    </div>
  );
};

export default Deposit;
