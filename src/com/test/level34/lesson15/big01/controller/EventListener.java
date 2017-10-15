package com.test.level34.lesson15.big01.controller;

/**
 * Created by Acer on 15.12.2016.
 */
import com.javarush.test.level34.lesson15.big01.model.Direction;

public interface EventListener {

    void move(Direction direction);
    void restart();
    void startNextLevel();
    void levelCompleted(int level);


}