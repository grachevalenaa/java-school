package ru.croc.task7;

public class Task7 {

    public static void main(String[] args) throws IllegalPositionException, IllegalMoveException {

        ChessPosition[] positions = new ChessPosition[args.length];

        for (int i = 0; i < args.length; ++i) {
            positions[i] = ChessPosition.parse(args[i]);
        }

        Task7.moveLikeKnight(positions);

    }

    public static void moveLikeKnight(ChessPosition[] positions) throws IllegalPositionException, IllegalMoveException {

        // создаю переменные для читаемости
        ChessPosition first = new ChessPosition(0,0);
        ChessPosition second = new ChessPosition(0,0);

        for (int i = 0; i < positions.length - 1; ++i) {

            first = positions[i];
            second = positions[i+1];

            try {
                if (Math.abs(second.getX()-first.getX()) != 1 || Math.abs(second.getY()-first.getY()) != 2 &&
                        Math.abs(second.getX()-first.getX()) != 2 || Math.abs(second.getY()-first.getY()) != 1) {
                    throw new IllegalMoveException(first, second);
                } else if (i == positions.length - 2) {
                    System.out.println("OK");
                }
            } catch (IllegalMoveException exception) {
                System.out.println("конь так не ходит: " + exception.getFirstPosition().toString() + " -> " +
                        exception.getSecondPosition().toString());
            }
        }
    }
}
