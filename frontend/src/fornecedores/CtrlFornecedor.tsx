import { Grid, LinearProgress } from '@mui/material';
import axios from 'axios';
import { useState, useEffect } from 'react';
import { BASE_URL } from '../utils/request';
import { DataGrid, GridColDef, GridToolbar } from '@mui/x-data-grid';

const CtrlFornecedor = () => {

    const [listagem, setListagem] = useState([]);
    const [carregando, setCarregando] = useState(false);

    const columns: GridColDef[] = [
        { field: 'idFornecedor', headerName: 'ID', flex: 1 },
        { field: 'dsRazaoSocial', headerName: 'RAZÃO SOCIAL', flex: 1 },
        { field: 'dsNome', headerName: 'NOME', flex: 1 },
        { field: 'cpfCnpj', headerName: 'CPF/CNPJ', flex: 1 },
        { field: 'tipoPessoa', headerName: 'TIPO', flex: 1 },
        { field: 'email', headerName: 'EMAIL', flex: 1 }
    ];

    useEffect(() => {
        setCarregando(true);
        axios.get(`${BASE_URL}/api/fornecedores`).then(response => {
            setListagem(response.data);
        });
        setCarregando(false);
    }, []);

    return (
        <Grid container spacing={2}>
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
                    getRowId={(row) => row.idFornecedor}
                    columns={columns}
                />
            </Grid>
        </Grid>
    );
};

export default CtrlFornecedor;