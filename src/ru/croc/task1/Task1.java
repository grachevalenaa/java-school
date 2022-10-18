package ru.croc.task1;

import java.util.Scanner;

public class Task1 {
    static class Point {
        // благодаря private полям присутствует инкапсуляция в коде
        private final double x;
        private final double y;

        public Point (double x, double y) {
            this.x = x;
            this.y = y;
        }
        
        // Пользуюсь методами getX и getY в методе calculateSquare класса Triangle
        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }

    // Определила класс Треугольник, чтобы там был метод для подсчета площади
    static class Triangle {
        private final Point point1;
        private final Point point2;
        private final Point point3;

        public Triangle(Point point1, Point point2, Point point3) {
            this.point1 = point1;
            this.point2 = point2;
            this.point3 = point3;
        }
        public double calculateSquare() {

            // для читаемости кода добавила переменные
            double x1 = point1.getX();
            double x2 = point2.getX();
            double x3 = point3.getX();
            double y1 = point1.getY();
            double y2 = point2.getY();
            double y3 = point3.getY();

            // уже готовая формула
            return 0.5 * Math.abs((x2-x1)*(y3-y1)-(x3-x1)*(y2-y1));
        }
    }

    public static void main(String[] args) {
        Scanner scannerX = new Scanner(System.in);
        Scanner scannerY = new Scanner(System.in);

        System.out.println("Enter the coordinates of the first point:");
        Point point1 = new Point(scannerX.nextDouble(), scannerY.nextDouble());

        System.out.println("Enter the coordinates of the second point:");
        Point point2 = new Point(scannerX.nextDouble(), scannerY.nextDouble());

        System.out.println("Enter the coordinates of the third point:");
        Point point3  = new Point(scannerX.nextDouble(), scannerY.nextDouble());

        Triangle triangle = new Triangle(point1, point2, point3);
        double answer = triangle.calculateSquare();
        System.out.println("Square of this triangle is " + answer);

    }
}
