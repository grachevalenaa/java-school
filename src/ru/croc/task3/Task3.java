package ru.croc.task3;

public class Task3 {
    // использую swapInArray в методе changeIndexOfMaxMin
    public static void swapInArray(long elem1, int indElem1, long elem2, int indElem2, long[] numbers) {
        numbers[indElem1] = elem2;
        numbers[indElem2] = elem1;
    }

    public static long[] convertIntoLong(String[] numbersInput) {
        long[] numbersOutput = new long[numbersInput.length];

        for (int i = 0; i < numbersInput.length; ++i) {
            numbersOutput[i] = Long.parseLong(numbersInput[i]);
        }

        return numbersOutput;
    }


    public static void changeIndexOfMaxMin(long[] numbers) {
        long min = numbers[0];
        long max = numbers[0];
        int indMin = 0;
        int indMax = 0;

        // находим min, max, indMin, indMax
        for (int i = 1; i < numbers.length; ++i) {
            if (numbers[i] < min) {
                min = numbers[i];
                indMin = i;
            }
            if (numbers[i] > max) {
                max = numbers[i];
                indMax = i;
            }
        }

        // меняем местами элементы
        if (indMin == 0 && indMax == numbers.length - 1) {
            return;
        } else if (indMax == 0) {
            swapInArray(numbers[numbers.length - 1], numbers.length - 1, max, indMax, numbers);
            swapInArray(numbers[0], 0, min, indMin, numbers);
            return;
        }

        swapInArray(numbers[0], 0, min, indMin, numbers);
        swapInArray(numbers[numbers.length - 1], numbers.length - 1, max, indMax, numbers);
    }

    public static void main(String[] args) {
        long[] numbers = convertIntoLong(args);

        changeIndexOfMaxMin(numbers);

        for (long number: numbers) {
            System.out.println(number);
        }
    }
}
