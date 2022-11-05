package ru.croc.task5;

import ru.croc.task6.Movable;

public class Circle extends Figure implements Movable {
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

}
