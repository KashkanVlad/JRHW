package com.test.level22.lesson13.task03;

import java.io.IOException;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {

    public static void main(String[] args) throws IOException
    {

        System.out.println("Cool Check");
        System.out.println("True");
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("+38(050)12-34-567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("+38(150)1234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38(050)12-34-567"));
        System.out.println(checkTelNumber("+38(050)12-34567"));
        System.out.println("");
        System.out.println("False");
        System.out.println(checkTelNumber("+3+8(050)1234567"));
        System.out.println(checkTelNumber("+380501212334567"));
        System.out.println(checkTelNumber("+3805012asd34567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456 "));
        System.out.println(checkTelNumber("(0)501234567"));
        System.out.println(checkTelNumber("+38051202(345)-7"));
        System.out.println(checkTelNumber("(1-2)3456789-0"));
        System.out.println(checkTelNumber("+-313450531202-"));
        System.out.println(checkTelNumber("+380501212334567"));
        System.out.println(checkTelNumber("+-313450531202-"));
        System.out.println(checkTelNumber("+38(050)112-34567"));
        System.out.println(checkTelNumber("+38(050)12-34(5)67"));
        System.out.println(checkTelNumber("+3(8)(050)12-34567"));
        System.out.println(checkTelNumber("+38050123-45-6789"));

    }

    public static boolean checkTelNumber(String telNumber)
    {

        boolean is = false;
        if (telNumber == null)
        {
            return false;
        }
        if (!telNumber.matches("[\\d, \\+,\\(,\\),-]+[\\d]$"))
        {
            return false;
        }
        if (telNumber.matches("^\\+.*"))
        {
            String str = telNumber.replaceAll("\\D", "");
            if (str.length() != 12)
            {
                return false;
            }

        }
        else if (telNumber.matches("^(\\(|\\d).*"))
        {
            String str = telNumber.replaceAll("\\D", "");
            if ((str.length() != 10))
            {
                return false;
            }
        }

        else if (!telNumber.matches("^\\-.*"))
        {
            return false;
        }
        if (telNumber.matches("\\+?\\d*(\\(\\d{3}\\))?\\d+-?\\d+-?\\d*"))
        {
            is = true;
        }
        return is;
    }

}
