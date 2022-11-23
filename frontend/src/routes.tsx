import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import NavBar from './components/Menu';
import CtrlFornecedor from './fornecedores/CtrlFornecedor';
import Inicio from './Inicio';
import CtrlUsuario from './usuarios/CtrlUsuario';

export default function AppRouter() {
    return (
        <Router>
            <NavBar />
            <Routes>
                <Route path='/' element={<Inicio />} />
                <Route path='/usuarios' element={<CtrlUsuario />} />
                <Route path='/fornecedores' element={<CtrlFornecedor />} />
            </Routes>
        </Router>
    );
}