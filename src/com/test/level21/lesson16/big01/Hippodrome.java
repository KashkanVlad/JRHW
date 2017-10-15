package com.test.level21.lesson16.big01;


import java.util.ArrayList;


public class Hippodrome
{
    public static Hippodrome game;



    private static ArrayList<Horse> horses = new ArrayList<>();
    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws InterruptedException
    {
        for(int i=0; i<100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move()
    {
        for(Horse horse:getHorses())

            horse.move();


    }

    public void print()
    {
        for (Horse horse : getHorses())

            horse.print();
            System.out.println();
            System.out.println();


    }

    public Horse getWinner()
    {
        Horse winner = new Horse("winner", 0,0);
                for(Horse h:getHorses())
                {
                    if (h.getDistance() > winner.getDistance())
                    {
                        winner = h;
                    }
                }
return winner;
    }

    public void printWinner()
    {
        System.out.println("Winner is "+ getWinner().getName()+"!");
    }

    public static void main(String[] args) throws InterruptedException
    {   game = new Hippodrome();
        game.horses.add(new Horse("Kit",3,0));
        game.horses.add(new Horse("Nash",3,0));
        game.horses.add(new Horse("Dunn",3,0));
        game.run();
        game.printWinner();
    }

}
