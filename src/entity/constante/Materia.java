package entity.constante;

public enum Materia {

    M2(2),

    M5(5),

    M10(10);

    private double fator;

    Materia(double fator) {
        this.fator = fator;
    }

    public double getFator() {
        return fator;
    }
}
