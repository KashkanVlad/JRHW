package com.test.level31.lesson02.home01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {

    private static List<File> lessThan50BytesFiles = new ArrayList<>();
    public static void main(String[] args) throws IOException
    {
        String directoryPath = args[0];
        String resultFileAbsolutePath = args[1];

        String allFilesContent = "allFilesContent.txt";

        saveFilesLessThan50Bytes(directoryPath);

        Path source = Paths.get(resultFileAbsolutePath);
        Path newResPath = Files.move(source, source.resolveSibling(allFilesContent));


        lessThan50BytesFiles.remove(new File(resultFileAbsolutePath));

        Collections.sort(lessThan50BytesFiles, new Comparator<File>()
        {
            @Override
            public int compare(File o1, File o2)
            {
                String file1 = o1.getName();
                String file2 = o2.getName();
                return file1.compareTo(file2);
            }
        });

        BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(newResPath.toFile()));
        for(File file: lessThan50BytesFiles)
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.ready())
            {
                bufferWriter.write(reader.readLine());
                bufferWriter.newLine();
            }
            reader.close();
        }
        bufferWriter.close();
    }

    private static void saveFilesLessThan50Bytes(String directory)
    {
        File direct = new File(directory);
        File[] files = direct.listFiles();

        if(files == null)
        {
            return;
        }
        else if(files.length == 0)
        {
            direct.delete();
        }
        else
        {
            for (File file : files)
            {
                if(file.isDirectory())
                {
                    saveFilesLessThan50Bytes(file.getAbsolutePath());
                }
                else
                {
                    if(file.length() > 50)
                    {
                        file.delete();
                    }
                    else
                    {
                        lessThan50BytesFiles.add(file);
                    }
                }
            }
        }
    }
}
