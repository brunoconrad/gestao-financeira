import { Grid, LinearProgress } from '@mui/material';
import axios from 'axios';
import { useState, useEffect } from 'react';
import { BASE_URL } from '../utils/request';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { Usuario } from '../models/usuario';

const CtrlUsuario = () => {

    const [listagem, setListagem] = useState<Usuario[]>([]);
    const [carregando, setCarregando] = useState(false);

    useEffect(() => {
        setCarregando(true);
        axios.get(`${BASE_URL}/api/usuarios`).then(response => {
            setListagem(response.data);
        });
        setCarregando(false);
    }, []);

    return (
        <Grid container>
            <Grid item xs={12}>
                {carregando &&
                    <LinearProgress />
                }
                <TableContainer component={Paper}>
                    <Table sx={{ minWidth: 650 }} aria-label="simple table">
                        <TableHead>
                            <TableRow>
                                <TableCell>ID USUARIO</TableCell>
                                <TableCell>Nome</TableCell>
                                <TableCell>CPF</TableCell>
                                <TableCell>EMAIL</TableCell>
                                <TableCell>TELEFONE</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {listagem?.map((row, index) => (
                                <TableRow
                                    key={index}
                                    sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                >
                                    <TableCell component="th" scope="row">
                                        {row.idUsuario}
                                    </TableCell>
                                    <TableCell>{row.dsNome}</TableCell>
                                    <TableCell>{row.cpf}</TableCell>
                                    <TableCell>{row.email}</TableCell>
                                    <TableCell>{row.telefone}</TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>
            </Grid>
        </Grid>
    );
};

export default CtrlUsuario;