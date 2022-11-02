package ru.croc.task7;

public class IllegalMoveException extends Exception{

    private ChessPosition firstPosition;
    private ChessPosition secondPosition;
    public IllegalMoveException(ChessPosition firstPosition, ChessPosition secondPosition) {
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
    }

    public ChessPosition getFirstPosition() {
        return firstPosition;
    }

    public ChessPosition getSecondPosition() {
        return secondPosition;
    }
}
