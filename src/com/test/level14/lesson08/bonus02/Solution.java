package com.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String s2 = reader.readLine();
        int a = Integer.parseInt(s);
        int a2 = Integer.parseInt(s2);


        System.out.println(gcd(a, a2));
/*
        while (true)
        {
            if(a > 0 && a2>0 && a%2==0 && a2%2==0)
            {
                if(a%a2==0)
                {
                    System.out.println(a);
                }
                else if(a2%a == 0)
                {
                    System.out.println(a2);
                }


            }
            else
            {
                System.out.println("Только положительные целые числа");
                System.out.println("Введены неверные числа");
            }
                break;
        }*/
    }
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        int x = a % b;
        return gcd(b, x);
    }
}
