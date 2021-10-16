package deborah.regs.dbc;

public class Caixa implements Pagamento{
    
    private Atendente atendenteResponsável;
    private double valorDeCaixa;

    // O caixa precisa de um responsável, e de um valor inicial para começar as vendas.

    public Caixa(Atendente atendenteResponsável, double valorDeCaixa) {
        this.atendenteResponsável = atendenteResponsável;
        this.valorDeCaixa = valorDeCaixa;
    }

    public Atendente getAtendenteResponsável() {
        return atendenteResponsável;
    }

    public void setAtendenteResponsável(Atendente atendenteResponsável) {
        this.atendenteResponsável = atendenteResponsável;
    }

    public double getValorDeCaixa() {
        return valorDeCaixa;
    }

    public void setValorDeCaixa(double valorDeCaixa) {
        this.valorDeCaixa = valorDeCaixa;
    }


    public boolean pagar(double valor, double valorTroco) {
        double consumo = Main.pedidos.peek().getValorTotal();
        if(valor >= consumo) {
            setValorDeCaixa(getValorDeCaixa() + valor - valorTroco);
            return true;
        }

        else {
            return false;
        }
    }

    @Override
    public double calculaTroco(Pedido pedido, double valorPago) {

        return 0;
    }

    @Override
    public String toString() {
        return "Responsável pelo caixa: " + atendenteResponsável + " Valor em caixa: " + Main.df.format(valorDeCaixa);
    }
}
