package ru.croc.task8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task8 {
    public static void main(String[] args) {
        try {
            System.out.println(numOfWords(args[0]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int numOfWords(String pathOfFile) throws IOException {
        BufferedReader readFromFile = new BufferedReader(new FileReader(pathOfFile));
        char inputChar;  // переменная, в которую в цикле кладу новый символ, (char) inputInt
        boolean isItWord = false;
        int counter = 0;

        try {
            int inputInt = readFromFile.read();
            while (inputInt != -1) {
                inputChar = (char) inputInt;

                // использую условие, что слова разделены пробелами (необязательно одним) или символом перехода строки
                if (!isItWord && inputChar != ' ' && inputChar != '\n' && inputChar != '\r') {
                    // началось новое слово, увеличиваю счетчик
                    isItWord = true;
                    ++counter;
                } else if (isItWord && (inputChar == ' ' || inputChar == '\n' || inputChar == '\r')) {
                    // слово закончилось
                    isItWord = false;
                }

                inputInt = readFromFile.read();
            }
        } finally {
                readFromFile.close();
        }


        return counter;
    }
}
