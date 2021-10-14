package deborah.regs.dbc;

public class Caixa implements Pagamento{

    @Override
    public boolean pagar(double valor) {
        double consumo = 0;
        if(valor >= consumo)
            return true;
        else return false;
    }
}
