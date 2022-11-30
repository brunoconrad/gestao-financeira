import { AddCircle } from '@mui/icons-material';
import { IconButton } from '@mui/material';
import { DataGrid, GridColDef, GridToolbarContainer, GridToolbarExport, GridToolbarQuickFilter } from '@mui/x-data-grid';

interface Table {
    listagem: Array<[]>,
    titleAdd: string,
    openModal: (open: boolean) => void,
    colunas: GridColDef[]
}

export function TabelaUtil({ listagem, titleAdd, openModal, colunas }: Table) {
    return (
        <DataGrid
            autoHeight
            density='compact'
            rows={listagem}
            components={{
                Toolbar: () => {
                    return (
                        <GridToolbarContainer>
                            <GridToolbarQuickFilter />
                            <GridToolbarExport />
                            <IconButton
                                title={titleAdd}
                                style={{ marginLeft: 'auto' }}
                                onClick={() => openModal(true)}
                            >
                                <AddCircle />
                            </IconButton>
                        </GridToolbarContainer>
                    );
                }
            }}
            disableColumnMenu
            disableSelectionOnClick
            getRowId={(row) => row.idFornecedor}
            columns={colunas}
        />
    );
}