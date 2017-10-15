package com.test.level13.lesson11.bonus02;

public class Person implements RepkaItem
{
    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh)
    {
        this.name = name;
        this.namePadezh = namePadezh;
    }


    @Override
    public String getNamePadezh()
    {
        return namePadezh;
    }


    public String pull(Person person)
    {
      /* return "Person{" +
                "name='" + name + '\'' +
                ", namePadezh='" + namePadezh + '\'' +
                '}';*/
        System.out.println(person.name + " за " + this.namePadezh);
        return "";
    }
}
