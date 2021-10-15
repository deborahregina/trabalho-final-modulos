package deborah.regs.dbc;

public class Caixa implements Pagamento{
    
    private Atendente atendenteResponsável;
    private double valorDeCaixa;

    // O caixa precisa de um responsável, e de um valor inicial para começar as vendas.

    public Caixa(Atendente atendenteResponsável, double valorDeCaixa) {
        this.atendenteResponsável = atendenteResponsável;
        this.valorDeCaixa = valorDeCaixa;
    }

    @Override
    public boolean pagar(double valor) {
        double consumo = 0;
        if(valor >= consumo)
            return true;
        else return false;
    }
}
