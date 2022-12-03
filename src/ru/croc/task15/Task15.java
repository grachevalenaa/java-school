package ru.croc.task15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {
        TreeNode root = convertDataFromFile();
        HashSet<Integer> differentHours = new HashSet<>();
        root.calculateTotalTime(differentHours);
        System.out.println(Collections.max(differentHours));
    }


    private static final String DATAPATH = "src/ru/croc/task15/input.txt";

    private static TreeNode convertDataFromFile() {
        File file = new File(DATAPATH);
        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter(",| *\\r\\n");
            String trash = scanner.next(); // trash - это костыль, туда помещается информация из файла, которую не использую
            trash = scanner.next();
            int time = scanner.nextInt();
            TreeNode root = new TreeNode(time);
            TreeNode parent;
            while (scanner.hasNextLine()) {
                trash = scanner.next();  // в trash помещается строка вида "C11"
                parent = root.findNode(scanner.next());  // находим родителя по строке вида "B1"
                time = scanner.nextInt();  // время обработки

                parent.setChild(new TreeNode(time + parent.getTime()));  // создаем новый node в дереве
            }
            return root;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
