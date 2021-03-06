package com.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(Map<Integer, Integer> denominations)
    {
        this.denominations = denominations;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()

    {
        return currencyCode;
    }


    public void addAmount(int denomination, int count)
    {
        if (denominations==null)
            denominations= new HashMap<>();
        if (denominations.keySet().contains(denomination))
        {
            denominations.put(denomination,denominations.get(denomination)+count);
        }
        else
            denominations.put(denomination,count);
    }

    public int getTotalAmount()
    {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet())
        {
            sum += (entry.getKey() * entry.getValue());
        }
        return sum;
    }

    public boolean hasMoney()
    {
        boolean result=true;
        if (denominations.isEmpty()) result = false;
        else {
            int zerosCount=0;
            for (Map.Entry<Integer,Integer> pair : denominations.entrySet()){
                if (pair.getValue()==0) zerosCount++;
            }
            if (zerosCount==denominations.size()) result=false;
        }
        return result;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return expectedAmount <= getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        //Жадный алгоритм
            int sum = expectedAmount;
            HashMap<Integer, Integer> temp = new HashMap<>();
            temp.putAll(denominations);
            ArrayList<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> pair : temp.entrySet())
                list.add(pair.getKey());

            Collections.sort(list);
            Collections.reverse(list);

            TreeMap<Integer, Integer> result = new TreeMap<>(new Comparator<Integer>()
            {
                @Override
                public int compare(Integer o1, Integer o2)
                {
                    return o2.compareTo(o1);
                }
            });

            for (Integer aList : list) {
                int key = aList;
                int value = temp.get(key);
                while (true) {
                    if (sum < key || value <= 0) {
                        temp.put(key, value);
                        break;
                    }
                    sum -= key;
                    value--;

                    if (result.containsKey(key))
                        result.put(key, result.get(key) + 1);
                    else
                        result.put(key, 1);
                }
            }

            if (sum > 0)
                throw new NotEnoughMoneyException();
            else
            {
                for (Map.Entry<Integer, Integer> pair : result.entrySet())
                    ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());

                denominations.clear();
                denominations.putAll(temp);
                ConsoleHelper.writeMessage("Транзакция выполнена успешно!");
            }
            return result;
        }

    }
