package com.test.level15.lesson12.home04;

/**
 * Created by Vladislav on 10.02.2016.
 */
public class Sun implements Planet
{
    private static Sun instance;

    private Sun()
    {}

    public static Sun getInstance()
    {
        if(instance == null)
        {
            instance = new Sun();
        }
        return instance;
    }
}
