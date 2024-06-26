package fr.diginamic.factory;

public abstract class Element {
    private String name;
    private double value;
    private Unite unite;

    public Element(String name, double value, Unite unite) {
        this.name = name;
        this.value = value;
        this.unite = unite;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public Unite getUnite() {
        return unite;
    }
}
