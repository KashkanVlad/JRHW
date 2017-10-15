package com.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        args = new String[3];
        args[0] = "C:/abc.txt";
        int count = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int i=32;
        if(args.length > 0)
        {
            FileInputStream in = new FileInputStream(args[0]);


            while(in.available() > 0)
            {
                int data = in.read();
                if((data >= (int) 'A' && data <= (int) 'Z'))
                {
                    count++;
                }
                else if(data >= (int) 'a' && data <= (int) 'z')
                {
                    count2++;
                }
                else if(data >= (int) '0' && data <= (int) '9')
                {
                    count3++;
                }
                else if( data == (char) i)
                {
                    count4++;
                }
            }
            in.close();
        }
        System.out.println("Букв Верхнего Регистра: " + Integer.valueOf(count));
        System.out.println("Букв Нижнего Регистра: " + Integer.valueOf(count2));
        System.out.println("Цифры: " + Integer.valueOf(count3));
        System.out.println("Пробелы: " + Integer.valueOf(count4));
    }

}

