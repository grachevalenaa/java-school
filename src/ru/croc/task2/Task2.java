package ru.croc.task2;

public class Task2 {
    public static void main(String[] args) {
        // считываем с командной строки строку с входным числом

        long value = Long.parseLong(args[0]);  // конвертирует String в long

        int indexOfMetric = 0;  // индекс единицы измерения в массиве metrics

        String[] metrics = {" B", " KB", " MB", " GB", " TB"};

        // Узнаем, сколько раз по 1024 помещается в числе и находим indexOfMetric
        long tempValue = value;
        while (tempValue >= 1024) {
            if (indexOfMetric == metrics.length - 1) {
                break;
            }
            ++indexOfMetric;
            tempValue /= 1024;
        }

        System.out.println(String.format("%.1f", value / Math.pow(1024, indexOfMetric)) + metrics[indexOfMetric]);

    }
}
