package ru.croc.task4;


public class Task4 {
    public static void main(String[] args) {
    String source = "/*\n" +
            " * My first ever program in Java!\n" +
            " */\n" +
            "class Hello { // class body starts here \n" +
            "  \n" +
            "  /* main method */\n" +
            "  public static void main(String[] args/* we put command line arguments here*/) {\n" +
            "    // this line prints my first greeting to the screen\n" +
            "    System.out.println(\"Hi!\"); // :)\n" +
            "  }\n" +
            "} // the end\n" +
            "// to be continued...\n"; // test data

    String noComments = removeJavaComments(source);

    System.out.println(noComments);
    }

    public static String removeJavaComments(String in) {
        // создаем массив (вместо использования в каждой итерации charAt для строки)
        char[] inArray = in.toCharArray();

        // если использовать строку, то при конкатенации будет каждый раз создаваться новая копия, юзаем StringBuffer
        StringBuffer out = new StringBuffer();

        int flag = 0;

        for (int i =  0; i < inArray.length - 1; ++i) {

            // в этом условии я обрабатываю неординарную ситуации

            if (flag == 2 && i > 0 && inArray[i-1] == '/' && inArray[i] == '*' && inArray[i+1] == '/') {
                // это случай, когда "/*/" ; многострочный комментарий продолжается (flag должен оставаться 2)
                // чтобы не попасть в блок с условием на проверку конца многострочного комментария
                // (так как там flag изменится на 0, а должен оставаться 2), пишу continue
                continue;
            }


            // проверка на начало и продолжение комментариев

            if ((flag == 0 && inArray[i] == '/' && inArray[i+1] == '/') || (flag == 1 && inArray[i] != '\n')) {
                // однострочный комментарий или вот-вот начат, или продолжается => флаг тот же (1)
                flag = 1;
                continue;
            } else if ((flag == 0 && inArray[i] == '/' && inArray[i+1] == '*') || (flag == 2 && (inArray[i] != '*' || inArray[i+1] != '/'))) {
                // многострочный комментарий или вот-вот начат, или продолжается => флаг тот же (2)
                flag = 2;
                continue;
            }


            // проверка на конец комментариев

            if (inArray[i] == '*' || inArray[i] == '/') {
                //конец многострочного комментария, меняем флаг, но не сохраняем '*', '/' в out
                flag = 0;
                continue;

            } else if (inArray[i] == '\n') {
                // конец однострочного комментария; '\n' нужно положить в out
                flag = 0;

            }

            out.append(inArray[i]);
        }

        return new String(out);
    }
}
