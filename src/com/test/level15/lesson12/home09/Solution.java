package com.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String aqm = url.substring(url.indexOf("?")+1);
        String [] sher = aqm.split("(\\&+)|(\\?+)");

        ArrayList<String> objLi = new ArrayList<>();
        Pattern objMu = Pattern.compile("^obj=.*");
        for(String a: sher)
        {
            if(!a.equals(""))
            {
                Matcher m = objMu.matcher(a);
                if(m.find())
                {
                    objLi.add(a.substring(a.indexOf("=") + 1));
                }
                if(a.contains("="))
                {
                    System.out.print(a.substring(0,(a.indexOf("=")))+ " ");
                }
                else
                {
                    System.out.println(a + " ");
                }
                }
                }
        Pattern dP = Pattern.compile("[0-9.]");
        Pattern sP = Pattern.compile("[A-Za-z]");

        System.out.println();
        for(String a: objLi)
        {
            Matcher m = sP.matcher(a);
            Matcher m1 = dP.matcher(a);
            if(m.find())
            {alert(a);
            }
            else if ((m1.find())){alert(Double.parseDouble(a));}

        }
            }
    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

