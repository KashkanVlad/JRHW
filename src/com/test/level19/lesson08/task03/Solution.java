package com.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException
    {
        PrintStream defaultPrintStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        testString.printSomething();
        System.setOut(defaultPrintStream);
        //ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //String textRead = bufferedReader.readLine();
        String result;
        String result2;
        result = byteArrayOutputStream.toString().replaceAll("[^0-9]", "");
        result2 = byteArrayOutputStream.toString().replaceAll("[^A-Z,a-z]", "");
        if(byteArrayOutputStream.equals(result))
        {
            System.out.println(result);
        }
        else if(byteArrayOutputStream.equals(result2))
        {
            System.out.println(result2);
        }

        System.out.println(result + " " + result2);
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a BIG MATHEFUKECR Are 23 text 4 f5-6or7 tes8ting");
        }
    }
}
