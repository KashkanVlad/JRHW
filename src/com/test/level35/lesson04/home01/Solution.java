package com.test.level35.lesson04.home01;
/* Вызов статического метода
Измените статический метод в классе GenericStatic так, чтобы он стал дженериком.
Пример вызова дан в методе main.
*/
public class Solution {
    public static void main(String[] args) {

        Object number = GenericStatic.<Number>someStaticMethod(new Integer(3));
    }
}
