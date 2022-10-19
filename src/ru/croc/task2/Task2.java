package ru.croc.task2;

public class Task2 {
    public static String output(long value, int counter) {
        return String.format("%.1f", value / (Math.pow(1024, counter)));
    }
    public static void main(String[] args) {
        // считываем с командной строки строку с входным числом

        long value = Long.parseLong(args[0]);  // конвертирует String в long

        int counter = 0;  // величина, с помощью которой будут выводиться единицы измерения

        // Узнаем, сколько раз по 1024 помещается в числе и находим counter
        long tempValue = value;
        while (tempValue >= 1024) {
            ++counter;
            tempValue /=1024;
        }

        // ! вывод (если ввести числа 1024 и , например, 1027, то вывод будет одинаковым)
        switch(counter) {
            case 0 -> System.out.println(output(value, counter) + " B");

            case 1 -> System.out.println(output(value, counter) + " KB");

            case 2 -> System.out.println(output(value, counter) + " MB");

            case 3 -> System.out.println(output(value, counter) + " GB");

            case 4 -> System.out.println(output(value, counter) + " TB");

            case 5 -> System.out.println(output(value, counter) + " PB");

            case 6 -> System.out.println(output(value, counter) + " EB");
        }
    }
}
