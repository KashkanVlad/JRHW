package com.test.level14.lesson08.bonus03;

/**
 * Created by Vladislav on 09.02.2016.
 */
public class Singleton
{
    static Singleton AIM = null;
    private  Singleton()
    {}
    static Singleton getInstance()
    {
        if(AIM == null)
        {
            AIM=new Singleton();
        }
        return AIM;
    }
}
