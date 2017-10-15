package com.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileInputStream in = new FileInputStream(file1);
        FileInputStream in2 = new FileInputStream(file2);

       // FileOutputStream out = new FileOutputStream(new File("C:/" + reader.readLine()+ ".txt"),true);

        byte[] buf1 = new byte[in.available()];
        in.read(buf1);
        in.close();

        byte[] buf2 = new byte[in2.available()];
        in2.read(buf2);
        in2.close();

        FileOutputStream out = new FileOutputStream(file1);
        out.write(buf2);
        out.close();

        FileOutputStream out2 = new FileOutputStream(file1 , true);
        out2.write(buf1);
        out2.close();

    }
}
