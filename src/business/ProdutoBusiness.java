package business;

import basedados.Banco;
import entity.Produto;

import java.util.Optional;

public class ProdutoBusiness {

    private Banco bancoDados;

    /**
     * Construtor.
     * @param banco Banco de dados para ter armazenar e ter acesso os produtos
     */
    public ProdutoBusiness(Banco banco) {
        this.bancoDados = banco;
    }

    /**
     * Salva um novo produto(livro ou caderno) na loja.
     * @param novoProduto Livro ou caderno que pode ser vendido
     */
    public void salvar(Produto novoProduto) {

        String codigo = "PR%04d";
        codigo = String.format(codigo, bancoDados.getProdutos().length);
        novoProduto.setCodigo(codigo);

        boolean produtoRepetido = false;
        for (Produto produto: bancoDados.getProdutos()) {
            if (produto.getCodigo() == novoProduto.getCodigo()) {
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

    //excluindo por posição, implementar pelo equals e hascode
    public void excluir(String codigo) {
       int produtoExclusao = -1;
       for (int i = 0; i< bancoDados.getProdutos().length;i++){
           Produto produto = bancoDados.getProdutos()[i];
           if(produto.getCodigo().equals(codigo)){
               produtoExclusao = i;
               break;
           }
       }
       if(produtoExclusao != -1){
           bancoDados.removerProduto(produtoExclusao);
           System.out.printf("Produto excluido com sucesso.");
       }else{
           System.out.printf("Produto Inexistente");
       }
    }

    public Optional<Produto> consultar(String codigo) {

        for (Produto produto: bancoDados.getProdutos()) {
            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                return  Optional.of(produto);
            }
        }
        return Optional.empty();
    }

    public void listarTodos() {

        if (bancoDados.getProdutos().length == 0) {
            System.out.println("Não existem produtos cadastrados");
        } else {

            for (Produto produto: bancoDados.getProdutos()) {
                System.out.println(produto.toString());
            }
        }
    }

}
