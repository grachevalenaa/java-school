package ru.croc.task6;

import ru.croc.task5.*;

public class Task6 {
    public static void main(String[] args) {
        Annotation[] differentAnnotations = new Annotation[3];
        differentAnnotations[0] = new Annotation(new Circle(new Point(-5, -6), 4), "First circle");
        differentAnnotations[1] = new Annotation(new Rectangle(new Point(-2,-6), new Point(4, 7)), "Random rectangle");
        differentAnnotations[2] = new Annotation(new Circle(new Point(-9, 5), 1), "Second circle");

        AnnotatedImage annotatedImage = new AnnotatedImage("somePath", differentAnnotations);

        System.out.println("\".findByPoint\" method:\t" + annotatedImage.findByPoint(-5,-3).toString() + "\n");

        System.out.println("\".findByLabel\" method:\t" + annotatedImage.findByLabel("om rectangle").toString() + "\n");

        System.out.println("\".move\" method (before) -> " + annotatedImage.getAnnotations()[0].toString() + "\t");
        annotatedImage.getAnnotations()[0].getFigure().move(5, -15);
        System.out.print("(after dx = 5 and dy = -15) -> " + annotatedImage.getAnnotations()[0].toString() + "\n");
    }
}

class AnnotatedImage {

    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    public Annotation findByPoint(int x, int y) {

        int index = -1;

        for (int i = 0; i < annotations.length; ++i) {
            if (annotations[i].getFigure().isPointInFigure(x, y)) {
                index = i;
                break;
            }
        }

        return annotations[index];

    }

    public Annotation findByLabel(String label) {

        int index = -1;

        for (int i = 0; i < annotations.length; ++i) {
            if (annotations[i].getLabel().contains(label)) {
                index = i;
                break;
            }
        }

        return annotations[index];

    }




}
