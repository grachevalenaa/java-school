package ru.croc.task19;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Task19 {
    public static void main(String[] args) throws IOException {
        String str = "Hello, world!";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/ru/croc/task19/output.txt"))) {
            writer.write(str);
        }
    }
}
