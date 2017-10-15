package com.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

import java.util.Objects;

public class Solution {
    public Solution(Objects prim1){}
    public Solution(Integer prim2){}
    public Solution(String prim3){}

    private Solution(Character pram1){}
    private Solution(Double pram2){}
    private Solution(Exception pram3){}

    protected Solution(Number priv1){}
    protected Solution(Boolean priv2){}
    protected Solution(Float priv3){}

    Solution(char a){}
    Solution(short b){}
    Solution(int c){}
}

