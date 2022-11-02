package ru.croc.task7;


public class ChessPosition {

    private int x;

    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private static String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h"};

    public ChessPosition(int x, int y) throws IllegalPositionException {

        try {
            if (x == -1 || y < 0 || y > 7) {
                throw new IllegalPositionException();
            }
        } catch (IllegalPositionException exception) {
            exception.printStackTrace();
        }


        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {

        return letters[x] + String.valueOf(y+1);

    }

    // фабричный метод
    static ChessPosition parse(String position) throws IllegalPositionException {

        int xOut = -1;

        String xIn = position.substring(0,1);

        String yIn = position.substring(1);
        int yOut = Integer.parseInt(yIn);

        // в этом цикле находим xOut, если буквы нет в массиве letters, то xOut останется -1, что приведет к выбросу ошибки
        for (int i = 0; i < letters.length; ++i) {
            if (letters[i].equals(xIn)) {
                xOut = i;
            }
        }
        try {
            if (xOut == -1 || yOut < 1 || yOut > 8) {
                throw new IllegalPositionException();
            }
        } catch (IllegalPositionException exception) {
            exception.printStackTrace();
        }

        return new ChessPosition(xOut, yOut);
    }


}
