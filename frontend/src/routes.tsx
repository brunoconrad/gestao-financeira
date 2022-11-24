import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import NavBar from './components/Menu';
import { lazy, Suspense } from 'react';
import Carregando from './components/Carregando';

const Inicio = lazy(() => import('./Inicio'));
const CtrlUsuario = lazy(() => import('./usuarios/CtrlUsuario'));
const CtrlFornecedor = lazy(() => import('./fornecedores/CtrlFornecedor'));

export default function AppRouter() {
    return (
        <Router>
            <Suspense fallback={<Carregando />}>
                <NavBar />
                <Routes>
                    <Route path='/' element={<Inicio />} />
                    <Route path='/usuarios' element={<CtrlUsuario />} />
                    <Route path='/fornecedores' element={<CtrlFornecedor />} />
                </Routes>
            </Suspense>
        </Router>
    );
}