import { Button, Dialog, DialogActions, DialogContent, DialogTitle, Grid, LinearProgress, TextField } from '@mui/material';
import axios from 'axios';
import { useState, useEffect } from 'react';
import { BASE_URL } from '../utils/request';
import { TabelaUtil } from '../components/Tabela';

const CtrlFornecedor = () => {

    const [listagem, setListagem] = useState([]);
    const [carregando, setCarregando] = useState(false);
    const [modalCadastrar, setModalCadastrar] = useState(false);

    const [dsRazaoSocial, setDsRazaoSocial] = useState(undefined);
    const [dsNomeFantasia, setDsNomeFantasia] = useState(undefined);
    const [dsNome, setDsNome] = useState(undefined);
    const [cpfCnpj, setCpfCnpj] = useState(undefined);
    const [tipoPessoa, setTipoPessoa] = useState(undefined);
    const [email, setEmail] = useState(undefined);
    const [site, setSite] = useState(undefined);
    const [telefoneComercial, setTelefoneComercial] = useState(undefined);
    const [telefoneAdministrativo, setTelefoneAdministrativo] = useState(undefined);

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

        setDsRazaoSocial(undefined);
        setDsNomeFantasia(undefined);
        setDsNome(undefined);
        setCpfCnpj(undefined);
        setTipoPessoa(undefined);
        setEmail(undefined);
        setSite(undefined);
        setTelefoneComercial(undefined);
        setTelefoneAdministrativo(undefined);
        buscaFornecedores();
        setModalCadastrar(false);
    }

    async function salvarFornecedor() {
        axios.post(`${BASE_URL}/api/fornecedores`, {
            email,
            dsNome,
            dsNomeFantasia,
            dsRazaoSocial,
            cpfCnpj,
            site,
            telefoneAdministrativo,
            telefoneComercial,
            tipoPessoa: 'FISICA'
        }).then();
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
                        <Grid container spacing={2} style={{ marginTop: '1px'}}>
                            <Grid item xs={12} sm={12} md={6}>
                                <TextField
                                    variant='outlined'
                                    label='Razão Social'
                                    fullWidth
                                    value={dsRazaoSocial}
                                    onChange={(e) => setDsRazaoSocial(e.target.value)}
                                />
                            </Grid>
                            <Grid item xs={12} sm={12} md={6}>
                                <TextField
                                    variant='outlined'
                                    label='Nome Fantasia'
                                    fullWidth
                                    value={dsNomeFantasia}
                                    onChange={(e) => setDsNomeFantasia(e.target.value)}
                                />
                            </Grid>
                            <Grid item xs={12} md={6}>
                                <TextField
                                    variant='outlined'
                                    label='Nome'
                                    fullWidth
                                    value={dsNome}
                                    onChange={(e) => setDsNome(e.target.value)}
                                />
                            </Grid>
                            <Grid item xs={12} md={6}>
                                <TextField
                                    variant='outlined'
                                    label='CPF/CNPJ'
                                    fullWidth
                                    value={cpfCnpj}
                                    onChange={(e) => setCpfCnpj(e.target.value)}
                                />
                            </Grid>
                            <Grid item xs={12} md={6}>
                                <TextField
                                    variant='outlined'
                                    label='Email'
                                    fullWidth
                                    value={email}
                                    onChange={(e) => setEmail(e.target.value)}
                                />
                            </Grid>
                            <Grid item xs={12} md={6}>
                                <TextField
                                    variant='outlined'
                                    label='Site'
                                    fullWidth
                                    value={site}
                                    onChange={(e) => setSite(e.target.value)}
                                />
                            </Grid>
                            <Grid item xs={12} md={6}>
                                <TextField
                                    variant='outlined'
                                    label='Telefone Comercial'
                                    fullWidth
                                    value={telefoneComercial}
                                    onChange={(e) => setTelefoneComercial(e.target.value)}
                                />
                            </Grid>
                            <Grid item xs={12} md={6}>
                                <TextField
                                    variant='outlined'
                                    label='Telefone Administrativo'
                                    fullWidth
                                    value={telefoneAdministrativo}
                                    onChange={(e) => setTelefoneAdministrativo(e.target.value)}
                                />
                            </Grid>
                        </Grid>
                    </DialogContent>
                    <DialogActions>
                        <Grid container spacing={2}>
                            <Grid item xs={6}>
                                <Button
                                    variant='contained'
                                    color='secondary'
                                    style={{ marginLeft: 'auto', display: 'flex' }}
                                    onClick={() => fecharModalCadastro()}
                                >
                                    Cancelar
                                </Button>
                            </Grid>
                            <Grid item xs={6}>
                                <Button
                                    variant='contained'
                                    color='primary'
                                    onClick={() => salvarFornecedor()}
                                >
                                    Slavar
                                </Button>
                            </Grid>
                        </Grid>
                    </DialogActions>
                </Dialog>
            }
        </Grid>
    );
};

export default CtrlFornecedor;