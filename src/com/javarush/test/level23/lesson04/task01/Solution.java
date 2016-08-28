package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution first = new Solution();
        Solution second = new Solution();

        first.innerClasses[0] = new Solution().new InnerClass();
        first.innerClasses[1] = new Solution().new InnerClass();

        second.innerClasses[0] = new Solution().new InnerClass();
        second.innerClasses[1] = new Solution().new InnerClass();

        Solution[] sol = new Solution[2];
        sol[0] = first;
        sol[1] = second;

        return null;
    }
}
