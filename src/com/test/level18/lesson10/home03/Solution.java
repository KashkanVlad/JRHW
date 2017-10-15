package com.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;


/*
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        FileOutputStream out2 = new FileOutputStream(new File("C:/" + reader.readLine()) + ".txt",true);
        FileInputStream in = new FileInputStream(new File("C:/" + reader.readLine() + ".txt"));
        FileInputStream in2 = new FileInputStream(new File("C:/" + reader.readLine() + ".txt"));


            while (in.available() > 0)
            {
                byte[] info = new byte[in.available()];
                int count = in.read(info);
                out2.write(info,0, count);
            }


            while (in2.available() > 0)
            {
                byte[] info = new byte[in2.available()];
                int count = in2.read(info);
                out2.write(info,0,count);
            }

String file1 = "C:/" + reader.readLine() + ".txt";
        String file2 = "C:/" + reader.readLine() + ".txt";
        String file3 ="C:/" + reader.readLine() + ".txt";

        reader.close();

        FileOutputStream out2 = new FileOutputStream(file1);
        FileInputStream in = new FileInputStream(file2);
        FileInputStream in2 = new FileInputStream(file3);


        byte[] byffer2 = new byte[in.available()];
        in.read(byffer2);
        in.close();

        byte[] byffer3 = new byte[in2.available()];
        in2.read(byffer3);

        out2.write(byffer2);
        out2.write(byffer3);

        out2.close();
        in.close();
        in2.close();


        FileOutputStream out2 = new FileOutputStream(new File("C:/" + reader.readLine()) + ".txt",true);
        FileInputStream in = new FileInputStream(new File("C:/" + reader.readLine() + ".txt"));
        FileInputStream in2 = new FileInputStream(new File("C:/" + reader.readLine() + ".txt"));

        while (in.available() > 0)
        {
            int count = in.read();
            out2.write(count);
        }


        while (in2.available() > 0)
        {
            int count = in2.read();
            out2.write(count);
        }

        in.close();
        in2.close();
        out2.close();

    }


}
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream out1 = new FileOutputStream(new File(reader.readLine()), true);
        FileInputStream in2 = new FileInputStream(new File(reader.readLine()));
        FileInputStream in3 = new FileInputStream(new File(reader.readLine()));

        while(in2.available() > 0){
            byte[] res = new byte[in2.available()];
            int count = in2.read(res);

            out1.write(res, 0, count);
        }

        while(in3.available() > 0){
            byte[] res = new byte[in3.available()];
            int count = in3.read(res);

            out1.write(res, 0, count);
        }


        reader.close();
        out1.close();
        in2.close();
        in3.close();
    }
}