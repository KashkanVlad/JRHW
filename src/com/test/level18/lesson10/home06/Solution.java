package com.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length == 0)
        {
            throw new IllegalArgumentException();
        }

        File fileOne = new File(args[0]);
        FileInputStream inputStream = new FileInputStream(fileOne);
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        byte[] data;
        char[] c = new char[0];

        while (inputStream.available() > 0)
        {
            data = new byte[inputStream.available()];
            inputStream.read(data);
            c = new String(data).toCharArray();
        }

        for (char newKey : c)
        {
            if(treeMap.containsKey(newKey))
            {
                int value = treeMap.get(newKey) + 1;
                treeMap.put(newKey, value);
            }
            else
            {
                treeMap.put(newKey, 1);
            }
        }

        for(Map.Entry<Character, Integer> entry : treeMap.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


        inputStream.close();
    }
}
