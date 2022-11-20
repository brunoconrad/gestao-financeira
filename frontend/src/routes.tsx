import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Inicio from './Inicio';
import CtrlUsuario from './usuarios/CtrlUsuario';

export default function AppRouter() {
    return (
        <Router>
            <Routes>
                <Route path='/' element={<Inicio />} />
                <Route path='/usuarios' element={<CtrlUsuario />} />
            </Routes>
        </Router>
    );
}