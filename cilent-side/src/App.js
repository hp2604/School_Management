import React from "react";
import Login from "./component/LoginForm";
import { ToastContainer } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import { BrowserRouter, Route,  Routes } from "react-router-dom";
import Signup from "./component/SignupForm";

function App() {
  return (
    <>
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<Login/>}/>
        <Route path="/signup" element={<Signup/>}/>
      </Routes>
    </BrowserRouter>
  <ToastContainer/>
    </>
  );
}

export default App;
