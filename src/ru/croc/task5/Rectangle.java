package ru.croc.task5;

public class Rectangle extends Figure {

    private Point lowerLeftPoint;

    private Point upperRightPoint;

    public Rectangle (Point lowerLeftPoint, Point upperRightPoint) {

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
    
    @Override
    public String toString() {

        return String.format("R (%d,%d), (%d,%d): ",
                lowerLeftPoint.getX(),
                lowerLeftPoint.getY(),
                upperRightPoint.getX(),
                upperRightPoint.getY());

    }

    @Override
    public boolean isPointInFigure(int x, int y) {
        
        // x1 <= x <= x2 and y1 <= y <= y2 (точка в прямоугольнике)
        return (lowerLeftPoint.getX() <= x && x <= upperRightPoint.getX() &&
                lowerLeftPoint.getY() <= y && y <= upperRightPoint.getY());

    }
}
