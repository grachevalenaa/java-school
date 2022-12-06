package ru.croc.task15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task15 {
    public static void main(String[] args) {
        Map<TreeNode, Integer> tree = getRootAndMaxTimeFromFile();
        System.out.println(tree.values().toArray()[0]);
    }

    private static final String DATAPATH = "src/ru/croc/task15/input.txt";

    private static Map<TreeNode, Integer> getRootAndMaxTimeFromFile() {
        // Алгоритм требует, чтобы в файле корневой отдел был первым
        File file = new File(DATAPATH);
        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter(",| *\\r\\n");

            // Создаю корневой отдел
            String  name = scanner.next();
            scanner.next(); // scanner возвращает вида "-" (у корневого отдела нет родителя), пропускаю
            int time = scanner.nextInt();
            TreeNode root = new TreeNode(name, time);

            // Добавляю остальные отделы в дерево и нахожу время обработки
            TreeNode parent;  // переменная для читаемости кода
            int max = 0; // максимальное время обработки
            while (scanner.hasNextLine()) {
                name = scanner.next();  // в name помещается строка вида "C11"
                parent = root.findNode(scanner.next());  // находим родителя по строке вида "B1"
                time = scanner.nextInt() + parent.getTime();  // время обработки (считая от root)
                parent.setChild(new TreeNode(name, time));  // создаем новый node в дереве
                // проверка на максимальное время
                if (time > max) {
                    max = time;
                }
            }
            Map<TreeNode, Integer> tree = new HashMap<>();
            tree.put(root, max);
            return tree;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
