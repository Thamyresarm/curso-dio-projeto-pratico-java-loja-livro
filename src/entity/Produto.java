package entity;

public abstract class Produto {

    private String codigo;

    private String nome;
    public double preco;
    public int quantidade;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double calcularFrete() {
        return 0;
    }

    @Override
    public String toString() {
        return "Codigo='" + codigo + '\'' +
                ", Nome='" + nome + '\'' +
                ", Preco=" + preco +
                ", Quantidade=" + quantidade;
    }
}
