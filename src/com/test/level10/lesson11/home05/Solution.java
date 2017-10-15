package com.test.level10.lesson11.home05;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/
/*
public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        int[] counter = new int[33];

        for (int i = 0; i < list.size(); i++)
        {
            char[] nextWord = list.get(i).toCharArray();
            for (int j = 0; j < nextWord.length; j++)
            {
                int indexOfLetter = alphabet.indexOf((nextWord[j]));
                counter[indexOfLetter]++;

            }
        }

        for (int i = 0; i < counter.length; i++)
        {
            System.out.println(alphabet.get(i) + " " + counter[i]);
        }


        //напишите тут ваш код
    }

}*/

/*public class Solution
{
    public static void main(String[] args)
    {
        int x = 2;
        int y = 12;

//x = x * 3;
            //Если подставить числа получается так:
y = x + y; //y=2+12=14
x = y - x; //x=14-2=12 x = 12
y = y - x; //y=14-12=2 y = 2

        System.out.println(x);
        System.out.println(y);
    }
}*/
public class Solution
{
    public static int min(int a, int b, int c, int d)
    {
        if( a < b  && a < c && a < d)
            return a;
        else if (b < a && b < c && b < d)
            return b;
        else if (c < a && c < b && c < d)
            return c;
        else
            return d;
    }
    public static int min(int a, int b)
    {
        if (a < b)
            return a;
        else
            return b;
    }

    public static void main(String[] args) throws Exception
    {
        if (min(5, 8, 9, 11) != 5)
        {
            System.out.println("1) Неправильно для a"); //вывод=5
        }
        if (min(-2, -5, 5,5) != -5)
        {
            System.out.println("2) Неправильно для отрицательных чисел"); //вывод=-5
        }
        if (min(10, 5, 7,7) != 5)
        {
            System.out.println("3) Неправильно для b"); //вывод=5
        }
        if (min(5, 5, 5,5) != 5)
        {
            System.out.println("4) Неправильно для всех равных чисел"); //вывод=5
        }
    }
}