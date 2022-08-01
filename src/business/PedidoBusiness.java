package business;

import basedados.Banco;
import entity.Cupom;
import entity.Pedido;
import entity.Produto;

import java.util.List;

public class PedidoBusiness {

    private Banco bancoDados;

    public PedidoBusiness(Banco banco) {
        this.bancoDados = banco;
    }


    private double calcularTotal(List<Produto> produtos, Cupom cupom) {

        double total = 0.0;
        for (Produto produto: produtos) {
            total += produto.calcularFrete();
        }

        if (cupom != null) {
            return  total * (1 - cupom.getDesconto());
        } else {
            return  total;
        }

    }

    public void salvar(Pedido novoPedido) {
        salvar(novoPedido, null);
    }

    public void salvar(Pedido novoPedido, Cupom cupom) {

        //Definir padrão código
        //Pegar data do dia corrente
        //Formatar código

        //Setar código no pedido
        //Setar cliente no pedido
        //Calcular e set total
        //Adicionar no banco
        //Mensagem
    }

    public void excluir(String codigo) {

        int pedidoExclusao = -1;
        for (int i = 0; i < bancoDados.getPedidos().length; i++) {

            Pedido pedido = bancoDados.getPedidos()[i];
            if (pedido.getCodigo().equals(codigo)) {
                pedidoExclusao = i;
                break;
            }
        }

        if (pedidoExclusao != -1) {
            bancoDados.removerPedido(pedidoExclusao);
            System.out.println("Pedido excluído com sucesso.");
        } else {
            System.out.println("Pedido inexistente.");
        }
    }

    /**
     * Lista todos os pedidos realizados.
     */
    //TODO Método de listar todos os pedidos

}
