package com.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution {

    //private static byte key = 10;
    public static void main(String[] args) throws IOException
    {

/*
        if(args[0].equals("-e"))
        {
            FileInputStream inputNameFileEncrypted = new FileInputStream(args[1]);
            FileOutputStream outputNameFileEncrypted = new FileOutputStream(args[2]);

            byte[] filenotEncrypted = new byte[inputNameFileEncrypted.available()];
            inputNameFileEncrypted.read(filenotEncrypted);
            String keyWord = "key1";
            outputNameFileEncrypted.write(encrypted(filenotEncrypted, keyWord));

            inputNameFileEncrypted.close();
            outputNameFileEncrypted.close();
        }
        else if(args[0].equals("-d"))
        {
            FileInputStream inputStream = new FileInputStream(args[1]);
            FileOutputStream outputStream = new FileOutputStream(args[2]);

            byte[] fileEncrypted = new byte[inputStream.available()];
            inputStream.read(fileEncrypted);
            String keyWord = "key1";
            outputStream.write(deccrypted(fileEncrypted,keyWord));

            inputStream.close();
            outputStream.close();
        }*/
        System.out.println("Enter:" + " -e " + "or " + "-d");
        System.out.printf("-e: Encrypted " + "\n" +
                "-d: Decrypted" + "\n" + "Enter: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

             if(s.equals("-e"))
        {
            System.out.println("Enter First File Name(Reader): ");
            File file1 = new File("E:/" + reader.readLine() + ".txt");
            System.out.println("Enter Second File Name(Writer): ");
            File file2 = new File("E:/" + reader.readLine() + ".txt");
            FileInputStream inputNameFileEncrypted = new FileInputStream(file1);
            FileOutputStream outputNameFileEncrypted = new FileOutputStream(file2);

            byte[] fileNotEncrypted = new byte[inputNameFileEncrypted.available()];
            inputNameFileEncrypted.read(fileNotEncrypted);
            String keyWord = "key1";
            outputNameFileEncrypted.write(encrypted(fileNotEncrypted, keyWord));

            inputNameFileEncrypted.close();
            outputNameFileEncrypted.close();
            System.out.println("Encrypted successful");
        }
            if(s.equals("-d"))
        {
            System.out.println("Enter First File Name(Reader: ");
            File file1 = new File("E:/" + reader.readLine() + ".txt");
            System.out.println("Enter Second File Name(Writer :) ");
            File file2 = new File("E:/" + reader.readLine() + ".txt");
            FileInputStream inputNameFileEncrypted = new FileInputStream(file1);
            FileOutputStream outputNameFileEncrypted = new FileOutputStream(file2);

            byte[] fileEncrypted = new byte[inputNameFileEncrypted.available()];
            inputNameFileEncrypted.read(fileEncrypted);
            String keyWord = "key1";
            outputNameFileEncrypted.write(decrypted(fileEncrypted, keyWord));

            inputNameFileEncrypted.close();
            outputNameFileEncrypted.close();
            System.out.println("Decrypted successful");
        }
    }
    public static byte[] encrypted(byte[] array, String keyWord)
    {
        byte[] keyArray = keyWord.getBytes();
        byte[] result = new byte[array.length];
        for(int i = 0; i < array.length; i++)
        {
            result[i] = (byte) (array[i] ^ keyArray[i % keyArray.length]);
        }
        return result;
    }

    public static byte[] decrypted(byte[] text, String keyWord)
    {
        byte[] result = new byte[text.length];
        byte[] keyArray = keyWord.getBytes();
        for(int i= 0; i < text.length; i++)
        {
            result[i] = (byte) (text[i] ^ keyArray[i % keyArray.length]);

        }
        return result;
    }

        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String s = reader.readLine();

        File file1 = new File("E:/" + reader.readLine() + ".txt");
        File file2 = new File("E:/" + reader.readLine() + ".txt");
        File file3 = new File("E:/" + reader.readLine() + ".txt");
        reader.close();

        FileInputStream in = new FileInputStream(file1);
        FileOutputStream out = new FileOutputStream(file2);
        FileOutputStream out2 = new FileOutputStream(file3);

       // if(args.length < 3) return;

       /* FileInputStream in = new FileInputStream(args[1]);
        FileOutputStream out = new FileOutputStream(args[2]);*/

      /*  while (in.available() > 0){
            byte[] data = new byte[in.available()];
            in.read(data);
            System.out.println(Arrays.toString(crypt(data)));
            System.out.println(Arrays.toString(crypt2(data)));
            out.write(crypt(data));
            out2.write(crypt2(data));
        }

        in.close();
        out.close();
    }
      /* private static byte[] crypt(byte[] data){


        StringBuilder builder = new StringBuilder();
        String[] s = new String(data).split(" ");
        byte[] res = new byte[s.length];

        for(int i = 0; i < s.length; i++){
            res[i] = (byte)(data[i] + key);
            // result[i] = (byte) (array[i] ^ keyArray[i % keyArray.length])
            //result[i] = (byte) (text[i] ^ keyArray[i % keyArray.length]);
        }

        for(byte i : res)
        {
            builder.append(i);
            builder.append(" ");
        }

        res = builder.toString().getBytes();

        return res;
    }*/


    /*private static byte[] crypt2(byte[] data){


        StringBuilder builder = new StringBuilder();
        String[] s = new String(data).split(" ");
        byte[] res = new byte[s.length];

        for(int i = 0; i < s.length; i++){
            res[i] = (byte)(data[i] - key);
            // result[i] = (byte) (array[i] ^ keyArray[i % keyArray.length])
            //result[i] = (byte) (text[i] ^ keyArray[i % keyArray.length]);
        }

        for(byte i : res)
        {
            builder.append(i);
            builder.append(" ");
        }

        res = builder.toString().getBytes();

        return res;
    }*/

    }
