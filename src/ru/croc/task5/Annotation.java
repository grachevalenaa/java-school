package ru.croc.task5;

public class Annotation {

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
        if (figure instanceof Rectangle) {
            Rectangle rectangle = (Rectangle)figure;
            return String.format("R (%d,%d), (%d,%d): %s",
                    rectangle.getLowerLeftPoint().getX(),
                    rectangle.getLowerLeftPoint().getY(),
                    rectangle.getUpperRightPoint().getX(),
                    rectangle.getUpperRightPoint().getY(),
                    label);
        }
        Circle circle = (Circle)figure;
        return String.format("C (%d,%d), %d: %s",
                circle.getCenterOfCircle().getX(),
                circle.getCenterOfCircle().getY(),
                circle.getRadiusOfCircle(),
                label);

    }

}
