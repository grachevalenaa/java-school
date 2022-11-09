package ru.croc.task9;

public class Task9 {
    public static void main(String[] args) {
        String wrongRelativePath = "КРОК/работа/src/./../../универ/../../../мемы/котики";
        System.out.println(makeRelativePathCorrect(wrongRelativePath));
    }

    public static String makeRelativePathCorrect(String inPath) {
        char[] inArray = inPath.toCharArray();
        StringBuilder correctPath = new StringBuilder();

        boolean isItCurrentDirectory = false;
        for (int i = 0; i < inArray.length-1; ++i) {

            // если в строке встречается "/./", то началась текущая директория, isItCurrentDirectory = true
            if (i != 0 && inArray[i-1] == '/' && inArray[i] == '.' && inArray[i+1] == '/') {
                isItCurrentDirectory = true;
            }

            // кладём в correctPath все папки и разделители ("/") между ними
            if (isItCurrentDirectory &&
                    ((inArray[i] != '/' && inArray[i] != '.') ||
                            (i != 0 && inArray[i-1] != '/' && inArray[i-1] != '.' && inArray[i] == '/' && inArray[i+1] != '/' && inArray[i+1] != '.'))) {
                correctPath.append(inArray[i]);
            }

            // отдельно обрабатываю случай последнего элемента (так как цикл идет до inArray.length-1 включительно)
            if (i == inArray.length - 2 && inArray[i+1] != '/' && inArray[i+1] != '.') {
                correctPath.append(inArray[i+1]);
            }

            // обрабатываю ситуацию, когда correctPath надо сделать пустым, если в нем есть ненужные папки
            if (correctPath.length() != 0 && inArray[i] == '.') {
                correctPath.setLength(0);
            }

        }
        return "../" + correctPath;
    }
}
