package entity;


import entity.constante.Materia;

public class Caderno extends Produto {
    private Materia materia;

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
