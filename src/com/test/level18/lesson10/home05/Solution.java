package com.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution
{

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());
        reader.close();

        FileInputStream in = new FileInputStream(file1);
        FileOutputStream out = new FileOutputStream(file2);

        while (in.available() >0)
        {
            byte[] data = new byte[in.available()];
            in.read(data);
            out.write(getInput(data));
        }

        in.close();



    }
    /*public static byte[] encrypted(byte[] array, String keyWord)
    {
        byte[] keyArray = keyWord.getBytes();
        byte[] result = new byte[array.length];
        for(int i = 0; i < array.length; i++)
        {
            result[i] = (byte) (array[i] ^ keyArray[i % keyArray.length]);
        }
        return result;
    }

    public static byte[] deccrypted(byte[] text, String keyWord)
    {
        byte[] result = new byte[text.length];
        byte[] keyArray = keyWord.getBytes();
        for(int i= 0; i < text.length; i++)
        {
            result[i] = (byte) (text[i] ^ keyArray[i % keyArray.length]);

        }
        return result;
    }*/

    private static byte[] getInput(byte[] data)
    {
        StringBuilder builder = new StringBuilder();
        String[] s = new String(data).split(" ");
        byte[] res;
        long[] tmp = new long[s.length];

        for(int i = 0; i < s.length; i++)
        {
            tmp[i] = Math.round(Float.valueOf(s[i]));

        }

        for( long i : tmp)
        {
            builder.append(i);
            builder.append(" ");

        }
        res = builder.toString().getBytes();



        return res;
    }
}



