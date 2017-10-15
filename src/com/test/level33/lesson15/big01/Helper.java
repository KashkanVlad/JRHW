package com.test.level33.lesson15.big01;


import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Vladislav on 02.12.2016.
 */
public class Helper
{
    public static String generateRandomString()
    {
        SecureRandom secureRandom = new SecureRandom();
        return new BigInteger(100, secureRandom).toString(32);
    }

    public static void printMessage(String message)
    {
        System.out.println(message);
    }
}
