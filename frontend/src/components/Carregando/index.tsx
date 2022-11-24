import { Grid, Typography } from '@mui/material';
import CircularProgress from '@mui/material/CircularProgress';

export default function Carregando() {
    return (
        <Grid container spacing={2} width='100%' marginTop='50px'>
            <Grid item xs={12} style={{ margin: 'auto', display: 'flex' }}>
                <CircularProgress style={{ margin: 'auto', display: 'flex' }} />
            </Grid>
            <Grid item xs={12} style={{ margin: 'auto', display: 'flex' }}>
                <Typography variant='h4' style={{ margin: 'auto', display: 'flex' }}>Carregando..</Typography>
            </Grid>
        </Grid>
    );
}