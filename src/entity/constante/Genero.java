package model;

public enum Genero {

    DRAMA(15),

    SUSPENSE(10),

    ROMANCE(5);

    private double fator;

    Genero(double fator) {
        this.fator = fator / 100;
    }

    public double getFator() {
        return fator;
    }
}
