package ru.croc.task3;

import java.util.Arrays;


public class Task3 {
    public static void main(String[] args) {
    long[] numbers = convertIntoLong(args);

    changeIndexOfMaxMin(numbers);

    System.out.println(Arrays.toString(numbers));
    }

    static void changeIndexOfMaxMin(long[] numbers) {
        long min = numbers[0];
        long max = numbers[0];
        int indMin = 0;
        int indMax = 0;
        int lastIndex = numbers.length - 1;

        // находим min, max, indMin, indMax
        for (int i = 1; i <= lastIndex; ++i) {
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
        long temp;
        if (indMin == 0 && indMax == lastIndex) {
            return;
        } else if (indMax == 0 && indMin == lastIndex) {
            numbers[0] = min;
            numbers[lastIndex] = max;
            return;
        } else if (indMax == 0) {
            temp = numbers[numbers.length - 1];
            numbers[numbers.length - 1] = max;
            numbers[indMax] = temp;

            temp = numbers[0];
            numbers[0] = min;
            numbers[indMin] = temp;
            return;
        }

        temp = numbers[0];
        numbers[0] = min;
        numbers[indMin] = temp;

        temp = numbers[numbers.length - 1];
        numbers[numbers.length - 1] = max;
        numbers[indMax] = temp;
    }

    static long[] convertIntoLong(String[] numbersInput) {
        long[] numbersOutput = new long[numbersInput.length];

        for (int i = 0; i < numbersInput.length; ++i) {
            numbersOutput[i] = Long.parseLong(numbersInput[i]);
        }

        return numbersOutput;
    }
}
