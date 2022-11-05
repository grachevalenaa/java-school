package ru.croc.task5;

public class Circle extends Figure {
    private Point centerOfCircle;
    private int radiusOfCircle;

    public Circle(Point centerOfCircle, int radiusOfCircle) {

        this.centerOfCircle = centerOfCircle;
        this.radiusOfCircle = radiusOfCircle;

    }

    public Point getCenterOfCircle() {

        return centerOfCircle;

    }

    public int getRadiusOfCircle() {

        return radiusOfCircle;

    }

    @Override
    public void move(int dx, int dy) {

        centerOfCircle.setX(centerOfCircle.getX() + dx);
        centerOfCircle.setY(centerOfCircle.getY() + dy);

    }

    @Override
    public String toString() {

        return String.format("C (%d,%d), %d: ",
                centerOfCircle.getX(),
                centerOfCircle.getY(),
                radiusOfCircle);

    }

    @Override
    public boolean isPointInFigure(int x, int y) {

        // x0-R <= x <= x0+R and y0-R <= y <= y0+R (точка в окружности)
        return (centerOfCircle.getX() - radiusOfCircle <= x && x <= centerOfCircle.getX() + radiusOfCircle &&
                centerOfCircle.getY() - radiusOfCircle <= y && y <= centerOfCircle.getY() + radiusOfCircle);


    }
}
