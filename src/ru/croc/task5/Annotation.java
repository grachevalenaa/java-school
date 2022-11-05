package ru.croc.task5;

public class Annotation {

    // намеренно не сделала поля final
    private Figure figure;

    private String label;

    public Annotation(Figure figure, String label) {
        this.figure = figure;
        this.label = label;
    }

    public Figure getFigure() {
        return figure;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return figure.toString() + label;
    }

}
