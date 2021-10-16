package deborah.regs.dbc;

import jdk.jfr.StackTrace;


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

//remover valor do caixa
    public boolean pagar(double valorPagamento, double valorTroco) {
        if (valorTroco > valorPagamento){
            System.out.println("troco não pode ser maior que o pagamento");
            return false;
        }
        double consumo = valorPagamento - valorTroco;
        setValorDeCaixa(getValorDeCaixa() + consumo);
        System.out.println(getValorDeCaixa());
        return true;
    }


    @Override
    public double calculaTroco(Pedido pedido, double valorPago) {
<<<<<<< HEAD

        pedido.calculaValorTotal();

        return 0;
=======
        pedido.calculaValorTotal();
        double troco = 0;
        if (pedido.getValorTotal() > valorPago){
            System.out.println("o valor paago deve ser maior ou igual ao valor do pedido");
        } else if (valorPago == pedido.getValorTotal()){
            System.out.println("Pagamento realizado com sucesso");
            //excluir o pedido da fila
        }else if (valorPago > pedido.getValorTotal()){
            troco = valorPago - pedido.getValorTotal();
        }
        return troco;
>>>>>>> bf80d2a866a51da4f41b1c30f1058cfe8ac9e25a
    }

    @Override
    public String toString() {
        return "Responsável pelo caixa: " + atendenteResponsável + " Valor em caixa: " + Main.df.format(valorDeCaixa);
    }
}
