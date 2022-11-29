import { Grid, LinearProgress } from '@mui/material';
import axios from 'axios';
import { useState, useEffect } from 'react';
import { BASE_URL } from '../utils/request';
import { Usuario } from '../models/usuario';
import { DataGrid, GridColDef, GridToolbar } from '@mui/x-data-grid';

const CtrlUsuario = () => {

    const [listagem, setListagem] = useState<Usuario[]>([]);
    const [carregando, setCarregando] = useState(false);

    const columns: GridColDef[] = [
        { field: 'idUsuario', headerName: 'ID', flex: 1 },
        { field: 'dsNome', headerName: 'NOME', flex: 1 },
        { field: 'cpf', headerName: 'CPF', flex: 1 },
        { field: 'email', headerName: 'EMAIL', flex: 1 },
        { field: 'telefone', headerName: 'TELEFONE', flex: 1 }
    ];

    async function buscaUsuarios() {
        setCarregando(true);
        axios.get(`${BASE_URL}/api/usuarios`).then(response => {
            setListagem(response.data);
        });
        setCarregando(false);
    }

    useEffect(() => {
        buscaUsuarios();
    }, []);

    return (
        <Grid container>
            <Grid item xs={12}>
                {carregando &&
                    <LinearProgress />
                }
            </Grid>
            <Grid item xs={12}>
                <DataGrid
                    autoHeight
                    rows={listagem}
                    components={{ Toolbar: GridToolbar }}
                    disableColumnMenu
                    disableSelectionOnClick
                    getRowId={(row) => row.idUsuario}
                    columns={columns}
                />
            </Grid>
        </Grid>
    );
};

export default CtrlUsuario;