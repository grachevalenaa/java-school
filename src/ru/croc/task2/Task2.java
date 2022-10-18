package ru.croc.task2;

public class Task2 {
    public static String output(double value, int counter) {
        return String.format("%.1f", value / (Math.pow(1024, counter)));
    }
    public static void main(String[] args) {
        // считываем с командной строки строку с входным числом

        /*выбрала примитивный тип double для хранения числа, так как нам нужно его делить на степень числа 1024, а
        чтобы результат деления представлял число с плавающей точкой (что нам и нужно),
        один из операндов также должен представлять число с плавающей точкой*/

        double value = Double.parseDouble(args[0]);  // конвертирует String в double

        // я написала программу для перевода до терабайта (включительно), если число еще больше, то это неверные данные
        if (value >= Math.pow(2, 50)) {
            System.out.println("It's so big number, I can't convert it");
            return;
        }
        int counter = 0;  // величина, с помощью которой будут выводиться единицы измерения

        // Узнаем, сколько раз по 1024 помещается в числе и находим counter
        double temp_value = value;
        while (temp_value >= 1024.0) {
            ++counter;
            temp_value /=1024;
        }

        // вывод (если ввести числа 1024 и , например, 1027, то вывод будет одинаковым)
        switch(counter) {
            case 0 -> System.out.println(output(value, counter) + " B");

            case 1 -> System.out.println(output(value, counter) + " KB");

            case 2 -> System.out.println(output(value, counter) + " MB");

            case 3 -> System.out.println(output(value, counter) + " GB");

            case 4 -> System.out.println(String.format("%.1f", value / (Math.pow(1024, counter))) + " TB");
        }
    }
}
