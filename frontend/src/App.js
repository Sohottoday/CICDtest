import React from 'react';
import './App.css';
import UserList from './components/UserList';
import UserForm from './components/UserForm';

function App() {
  return (
    <div className="App">
      <h1>User Management System</h1>
      <UserForm />
      <UserList />
    </div>
  );
}

export default App;