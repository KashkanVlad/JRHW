package com.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;

public final class CurrencyManipulatorFactory
{
    private CurrencyManipulatorFactory()
    {

    }

    private static HashMap<String, CurrencyManipulator> map = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if (map.get(currencyCode) == null)
        {
            map.put(currencyCode, new CurrencyManipulator(currencyCode));
        }
        return map.get(currencyCode);
        }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
    {

        return map.values();
    }

}
