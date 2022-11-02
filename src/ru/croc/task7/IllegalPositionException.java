package ru.croc.task7;

public class IllegalPositionException extends Exception {
    public IllegalPositionException() {
        super("Chess position out of range");
    }
}
