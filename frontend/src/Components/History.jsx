import React, { useEffect, useState } from 'react';

const History = () => {
  const [transactions, setTransactions] = useState([]);

  useEffect(() => {
    
    fetch('http://localhost:8080/api/userinfo', {
      credentials: 'include', 
    })
      .then((res) => res.json())
      .then((data) => {
        
        setTransactions(data.th);
        console.log(data);
      })
      .catch((err) => console.error(err));
  }, []);

  return (
    <div className="bg-white p-6 rounded shadow-md">
      <h1 className="text-xl font-bold">Transaction History</h1>
      <table className="min-w-full mt-4 border">
        <thead>
          <tr>
            <th className="border px-4 py-2">Serial No</th>
            <th className="border px-4 py-2">Type</th>
            <th className="border px-4 py-2">Amount</th>
          </tr>
        </thead>
        <tbody>
          {transactions.length > 0 ? (
            transactions.map((transaction, index) => (
              <tr 
                key={transaction.id} 
                className={transaction.type === 'withdraw' ? 'bg-red-500' : 'bg-green-500'}
              >
                <td className="border px-4 py-2 font-bold">{index + 1}</td>
                <td className="border px-4 py-2 font-bold">{transaction.type}</td>
                <td className="border px-4 py-2 font-bold">{transaction.amount}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="3" className="text-center border px-4 py-2">
                No transactions available.
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default History;
