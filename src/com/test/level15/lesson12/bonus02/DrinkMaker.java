package com.test.level15.lesson12.bonus02;

/**
 * Created by Vladislav on 09.02.2016.
 */
public abstract class DrinkMaker
{
     abstract void getRightCup(); //выбрать подходящую чашку
     abstract void putIngredient(); //положить ингредиенты
     abstract void pour(); //залить жидкость
    void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
