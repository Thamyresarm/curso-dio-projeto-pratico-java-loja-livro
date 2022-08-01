package entity;


import entity.constante.Materia;

public class Caderno extends Produto {
    private String nome;
    private Materia materia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public double calcularFrete() {
        return (getPreco() * getQuantidade()) * (1 + materia.getFator());
    }
}
