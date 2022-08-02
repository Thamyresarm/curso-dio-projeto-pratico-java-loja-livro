import basedados.Banco;
import business.ClienteBusiness;
import business.PedidoBusiness;
import business.ProdutoBusiness;
import entity.*;
import util.LeitoraDados;

import java.util.Optional;

public class Main {

    private static Cliente clienteLogado = null;

    private static Banco banco = new Banco();

    private static ClienteBusiness clienteBusiness = new ClienteBusiness(banco);
    private static PedidoBusiness pedidoBusiness = new PedidoBusiness(banco);
    private static ProdutoBusiness produtoBusiness = new ProdutoBusiness(banco);

    public static void main(String[] args) {

        System.out.println("Bem vindo ao e-Compras");

        String opcao = "";

        while(true) {

            if (clienteLogado == null) {

                System.out.println("Digite o cpf:");

                String cpf = "";
                cpf = LeitoraDados.lerDado();

                identificarUsuario(cpf);
            }

            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Buscar Livro");
            System.out.println("3 - Excluir Livro");
            System.out.println("4 - Cadastrar Caderno");
            System.out.println("5 - Buscar Caderno");
            System.out.println("6 - Excluir Caderno");
            System.out.println("7 - Fazer pedido");
            //TODO Desafio: Consultar Pedido(código)
            System.out.println("9 - Excluir pedido");
            System.out.println("10 - Listar produtos");
            System.out.println("11 - Listar pedidos");
            System.out.println("12 - Deslogar");
            System.out.println("0 - Sair");

            opcao = LeitoraDados.lerDado();

            switch (opcao) {
                case "1":
                    Livro livro = LeitoraDados.lerLivro();
                    produtoBusiness.salvar(livro);
                    break;
                case "2":
                    System.out.println("Digite o Nome do livro");
                    String nome = LeitoraDados.lerDado();
                    produtoBusiness.buscarPorNome(nome);
                    break;
                case "3":
                    System.out.println("Digite o código do livro");
                    String codigoLivro = LeitoraDados.lerDado();
                    produtoBusiness.excluir(codigoLivro);
                    break;
                case "4":
                    Caderno caderno = LeitoraDados.lerCaderno();
                    produtoBusiness.salvar(caderno);
                    break;
                case "5":
                    System.out.println("Digite o Nome do caderno");
                    nome = LeitoraDados.lerDado();
                    produtoBusiness.buscarPorNome(nome);
                    break;
                case "6":
                    System.out.println("Digite o código do Caderno");
                    String codigoCaderno = LeitoraDados.lerDado();
                    produtoBusiness.excluir(codigoCaderno);
                    break;
                case "7":
                    Pedido pedido = LeitoraDados.lerPedido(banco);
                    Optional<Cupom> cupom = LeitoraDados.lerCupom(banco);

                    if (cupom.isPresent()) {
                        pedidoBusiness.salvar(pedido, cupom.get());
                    } else {
                        pedidoBusiness.salvar(pedido);
                    }
                    break;
                case "9":
                    System.out.println("Digite o código do pedido");
                    String codigoPedido = LeitoraDados.lerDado();
                    pedidoBusiness.excluir(codigoPedido);
                    break;
                case "10":
                    produtoBusiness.listarTodos();
                    break;
                case "11":
                    //TODO Listar todos os Pedidos
                    break;
                case "12":
                    System.out.println(String.format("Volte sempre %s!", clienteLogado.getNome()));
                    clienteLogado = null;
                    break;
                case "0":
                    System.out.println("Aplicação encerrada.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

    }

    private static void identificarUsuario(String cpf) {

        Optional<Cliente> resultado = clienteBusiness.consultar(cpf);

        if (resultado.isPresent()) {
            Cliente cliente = resultado.get();
            System.out.println(String.format("Olá %s! Você está logado.", cliente.getNome()));
            clienteLogado = cliente;
        } else {
            System.out.println("Usuário não cadastrado.Deseja se cadastrar SIM ou NÃO ?");
            String resposta = LeitoraDados.lerDado();
            if(resposta.equalsIgnoreCase("sim")){
                Cliente cliente = LeitoraDados.lerCliente(cpf);
                clienteBusiness.salvar(cliente);
                identificarUsuario(cpf);
            }else {
                System.exit(0);
            }
        }
    }
}