package com.yk.book.array;

/**
 * @description: 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author: Yangk
 * @create: 2020-07-11
 */
public class FindNumberIn2DArray {

    public static void main(String[] args) {

        int[][] array = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        boolean result = findNumberIn2DArray(array,20);
        System.out.println(result);

    }

    private static boolean findNumberIn2DArray(int[][] array, int target) {
        for (int[] ints : array) {
            for (int j = ints.length - 1; j >= 0; j--) {
                int anInt = ints[j];
                if (anInt > target) {
                    continue;
                } else if (anInt == target) {
                    return true;
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
