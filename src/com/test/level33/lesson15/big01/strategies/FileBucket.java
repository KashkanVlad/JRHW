package com.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket
{

    private Path path;

    public FileBucket()
    {
        try
        {
            path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
        this.path.toFile().deleteOnExit();
    }

    public long getFileSize()
    {
        Long size = 0L;
        try
        {
            size = Files.size(path);
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
        return size;
    }

    public void putEntry(Entry entry)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path)))
        {
            oos.writeObject(entry);
            oos.flush();
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry()
    {
        Entry entry = null;
        if (getFileSize() == 0)
            return entry;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path)))
        {
            entry = (Entry) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e)
        {
            ExceptionHandler.log(e);
        }
        return entry;
    }

    public void remove()
    {
        try
        {
            Files.delete(path);
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
    }
}