package com.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

import java.util.TreeSet;

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество


    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o)
    {
        int distParam = (int) (distance - o.getDistance());
        int qualParam = quality - o.getQuality();
        return 10000 * name.compareTo(o.getName()) + 100 * distParam + qualParam;
    }

    public static void main(String[] args)
    {
        TreeSet<Beach> beachSet = new TreeSet<Beach>();


        beachSet.add(new Beach("1", 123.1f,7));
        beachSet.add(new Beach("2", 125.1f,7));
        beachSet.add(new Beach("3", 124.1f,5));
        beachSet.add(new Beach("4", 127.1f,2));
        beachSet.add(new Beach("5", 128.1f,4));
        beachSet.add(new Beach("6", 121.1f,2));

        for(Beach x: beachSet)
        {
            System.out.println(x.getName()+ " " + x.getDistance()+ " " + x.getQuality());
        }
    }
}
