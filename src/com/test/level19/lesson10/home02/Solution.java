package com.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{

        TreeMap<String, Double> treeMap = new TreeMap<>();
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] symbols;
        String line1;
        Double currentValue2;


        while((line1 = reader.readLine())!=null)
        {
            symbols = line1.split(" ");
            if(treeMap.containsKey(symbols[0]))
            {
                currentValue2 = treeMap.get(symbols[0]);
                //treeMap.put(symbols[0],Double.parseDouble(symbols[1]) + currentValue2);
            }
            else
            {
                treeMap.put(symbols[0],Double.parseDouble(symbols[1]));
            }
        }

        reader.close();
        fileReader.close();


        Double max = Double.MIN_VALUE;
        Double value;
        for(String s : treeMap.keySet())
        {
            value = treeMap.get(s);
            if(value > max)
            {
                max = value;
            }
        }

        for(String key : treeMap.keySet())
        {
            value = treeMap.get(key);

            if(value == max)
            {
                System.out.println(key);
            }
        }

    }
}
