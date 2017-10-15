package com.test.level15.lesson12.home05;

import java.util.Objects;

/**
 * Created by Vladislav on 10.02.2016.
 */
public class SubSolution extends Solution
{
    public SubSolution(Objects prim1)
    {
        super(prim1);
    }

    public SubSolution(Integer prim2)
    {
        super(prim2);
    }

    public SubSolution(String prim3)
    {
        super(prim3);
    }

    private SubSolution(Character pram1){super(pram1);}
    private SubSolution(Double pram2){super( pram2);}
    private SubSolution(Exception pram3){super (String.valueOf(pram3));}

    protected SubSolution(Number priv1)
    {
        super(priv1);
    }

    protected SubSolution(Boolean priv2)
    {
        super(priv2);
    }

    protected SubSolution(Float priv3)
    {
        super(priv3);
    }

    SubSolution(char a)
    {
        super(a);
    }

    SubSolution(short b)
    {
        super(b);
    }

    SubSolution(int c)
    {
        super(c);
    }
}
