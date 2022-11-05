package ru.croc.task5;

public class Task5 {
    public static void main(String[] args) {
        Annotation annotationCircle = new Annotation(
                new Circle(
                        new Point(100, 100),
                        10),
                "Tree");
        System.out.println(annotationCircle);

        Annotation annotationRectangle = new Annotation(
                new Rectangle(
                        new Point(100, 100),
                        new Point(150, 200)),
                "Car");
        System.out.println(annotationRectangle);

    }
}
