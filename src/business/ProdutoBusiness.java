package business;

import basedados.Banco;
import entity.Produto;

import java.util.Optional;

public class ProdutoBusiness {

    private Banco bancoDados;

    public ProdutoBusiness(Banco banco) {
        this.bancoDados = banco;
    }

    public void salvar(Produto novoProduto) {

        String codigo = "PR%04d";
        codigo = String.format(codigo, bancoDados.getProdutos().length);
        novoProduto.setCodigo(codigo);

        boolean produtoRepetido = false;
        for (Produto produto : bancoDados.getProdutos()) {
            if (produto.getNome() == novoProduto.getNome()) {
                produtoRepetido = true;
                System.out.println("Produto já cadastrado.");
                break;
            }
        }

        if (!produtoRepetido) {
            this.bancoDados.adicionarProduto(novoProduto);
            System.out.println("Produto cadastrado com sucesso.");
        }
    }

    public Optional<Produto> consultar(String codigo) {

        for (Produto produto : bancoDados.getProdutos()) {
            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                return Optional.of(produto);
            }
        }
        return Optional.empty();
    }

    public void excluir(String codigo) {
        Optional<Produto> resultado = consultar(codigo);
        if (resultado.isPresent()) {
            Produto produto = resultado.get();
            //int posicao = bancoDados.posicao
            //bancoDados.removerProduto(posicao);
            System.out.println("Produto excluido com sucesso");
        } else {
            System.out.println("Produto não encontrado");
        }
    }

    public void listarTodos() {

        if (bancoDados.getProdutos().length == 0) {
            System.out.println("Não existem produtos cadastrados");
        } else {

            for (Produto produto : bancoDados.getProdutos()) {
                System.out.println(produto.toString());
            }
        }
    }

    public void buscarPorNome(String nome) {
        for (Produto produto : bancoDados.getProdutos()) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                System.out.println(produto.toString());
            }else {
                System.out.println("Produto não encontrado");
            }
        }
    }
}
