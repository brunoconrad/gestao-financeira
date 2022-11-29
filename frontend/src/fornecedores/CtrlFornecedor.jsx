import { Button, Dialog, DialogActions, DialogContent, DialogTitle, FormControl, Grid, LinearProgress, TextField } from '@mui/material';
import axios from 'axios';
import { useState, useEffect } from 'react';
import { BASE_URL } from '../utils/request';
import { TabelaUtil } from '../components/Tabela';

const CtrlFornecedor = () => {

    const [listagem, setListagem] = useState([]);
    const [carregando, setCarregando] = useState(false);
    const [modalCadastrar, setModalCadastrar] = useState(false);

    const columns = [
        { field: 'idFornecedor', headerName: 'ID', flex: 1 },
        { field: 'dsRazaoSocial', headerName: 'RAZÃO SOCIAL', flex: 1 },
        { field: 'dsNome', headerName: 'NOME', flex: 1 },
        { field: 'cpfCnpj', headerName: 'CPF/CNPJ', flex: 1 },
        { field: 'tipoPessoa', headerName: 'TIPO', flex: 1 },
        { field: 'email', headerName: 'EMAIL', flex: 1 }
    ];

    async function buscaFornecedores() {
        setCarregando(true);
        axios.get(`${BASE_URL}/api/fornecedores`).then(response => {
            setListagem(response.data);
        });
        setCarregando(false);
    }

    useEffect(() => {
        buscaFornecedores();
    }, []);

    function fecharModalCadastro() {
        buscaFornecedores();
        setModalCadastrar(false);
    }

    return (
        <Grid container spacing={2}>
            <Grid item xs={12}>
                {carregando &&
                    <LinearProgress />
                }
            </Grid>
            <Grid item xs={12}>
                <TabelaUtil
                    listagem={listagem}
                    titleAdd='Adicionar Fornecedor'
                    openModal={setModalCadastrar}
                    colunas={columns}
                />
            </Grid>
            {modalCadastrar &&
                <Dialog
                    maxWidth='xl'
                    fullWidth
                    open={modalCadastrar}
                    onClose={() => fecharModalCadastro()}>
                    <DialogTitle>
                        Adicionar Fornecedor
                    </DialogTitle>
                    <DialogContent>
                        <FormControl variant='standard' fullWidth>
                            <TextField
                                variant='outlined'
                                label='Nome'
                            // value={ }
                            // onChange={ }
                            />
                        </FormControl>
                    </DialogContent>
                    <DialogActions>
                        <Button
                            variant='contained'
                            color='secondary'
                            onClick={() => fecharModalCadastro()}
                        >
                            Cancelar
                        </Button>
                        <Button variant='contained' color='primary'>Slavar</Button>
                    </DialogActions>
                </Dialog>
            }
        </Grid>
    );
};

export default CtrlFornecedor;