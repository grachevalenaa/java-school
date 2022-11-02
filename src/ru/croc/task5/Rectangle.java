package ru.croc.task5;

import ru.croc.task6.Movable;

public class Rectangle extends Figure implements Movable {

    private Point lowerLeftPoint;
    private Point upperRightPoint;

    public Rectangle (Point lowerLeftPoint, Point upperRightPoint){
        this.lowerLeftPoint = lowerLeftPoint;
        this.upperRightPoint = upperRightPoint;
    }

    public Point getLowerLeftPoint() {
        return lowerLeftPoint;
    }

    public Point getUpperRightPoint() {
        return upperRightPoint;
    }

    @Override
    public void move(int dx, int dy) {
        lowerLeftPoint.setX(lowerLeftPoint.getX() + dx);
        lowerLeftPoint.setY(lowerLeftPoint.getY() + dy);
        upperRightPoint.setX(upperRightPoint.getX() + dx);
        upperRightPoint.setY(upperRightPoint.getY() + dy);
    }
}
