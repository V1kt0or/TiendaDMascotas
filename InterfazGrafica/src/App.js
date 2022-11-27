import React from 'react'
import './App.css'
import { BrowserRouter as Router, Route, Routes } from "react-router-dom"
import Home from './screens/Home';
import { Alimentos } from './screens/Alimentos';
import { AccesoriosHogar } from './screens/AccesoriosHogar';
import { AccesoriosExterior } from './screens/AccesoriosExterior';
import { Higiene } from './screens/Higiene';
import { Juguetes } from './screens/Juguetes';
import { Register } from './screens/Register';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/alimentos" element={<Alimentos />} />
        <Route path="/hogar" element={<AccesoriosHogar />} />
        <Route path="/exteriores" element={<AccesoriosExterior />} />
        <Route path="/higiene-bienestar" element={<Higiene />} />
        <Route path="/juguetes" element={<Juguetes />} />
        <Route path="/register" element={<Register />} />
      </Routes>
    </Router>
  );
}

export default App;
