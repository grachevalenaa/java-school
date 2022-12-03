package ru.croc.task15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {
        TreeNode root = convertDataFromFile();
        HashSet<Integer> differentHours = new HashSet<>();
        System.out.println(root.calculateTotalTime(differentHours));
    }

    private static final String DATAPATH = "src/ru/croc/task15/input.txt";

    private static TreeNode convertDataFromFile() {
        File file = new File(DATAPATH);
        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter(",| *\\r\\n");

            // Создаю корневой отдел
            String trash = scanner.next(); // trash - это костыль, туда помещается информация из файла, которую не использую
            trash = scanner.next();
            int time = scanner.nextInt();
            TreeNode root = new TreeNode(time);

            // Добавляю остальные отделы в дерево
            TreeNode parent;  // переменная для читаемости кода
            while (scanner.hasNextLine()) {
                trash = scanner.next();  // в trash помещается строка вида "C11"
                parent = root.findNode(scanner.next());  // находим родителя по строке вида "B1"
                time = scanner.nextInt() + parent.getTime();  // время обработки (считая от root)
                parent.setChild(new TreeNode(time));  // создаем новый node в дереве
            }

            return root;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
