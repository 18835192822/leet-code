package com.yk.book.array;

/**
 * @description: 题目二：不修改数组找出重复的数字。
 * 在一个长度为 n+1的数组里的所有数字都在1〜n的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7},
 * 那么对应的输出是重复的数字2或者3。
 *
 * 与RepeatNumber比较类似，但有两处不同，
 * 1.数组长度比数值范围长度大1，所以至少有一个重复数字。
 * 2.不可修改原数组
 * @author: Yangk
 * @create: 2020-07-11
 */
public class RepeatNumber2 {

    public static void main(String[] args) {
        int[] array = {2, 3, 5, 4, 3, 2, 6, 7};
        int value = findRepeatNumber1(array, 1, 7);
        System.out.println(value);
    }

    /**
     * 利用二分法将数值范围拆分，计算每次落在范围内的数字个数是否大于数值范围长度，如果大于，说明重复数组在这之间，递归
     * 时间复杂度：O(n * logn)
     * 空间复杂度：O(1)
     * @param array
     * @param p
     * @param q     数值分布在 p ~ q
     */
    private static int findRepeatNumber1(int[] array, int p , int q){
        if(q < p){
            return -2;
        }

        //最终取值范围剩一个数的时候就是重复数字了
        if(q == p){
            return p;
        }

        int mid = (q + p) / 2;
        //计算取值范围的长度
        int lowSize = mid - p + 1;
        int highSize = q - mid;

        //存储落在取值范围内数字的个数
        int low = 0;
        int high = 0;
        for (int i : array) {
            if(i >= p && i <= mid){
                low++;
            }else if(i > mid && i <= q){
                high++;
            }
        }

        //如果大于则一定有重复数字。这里可能出现小范围和大范围均超过的情况，但是题目只要求找到一个即可，所以使用if-else-if来做。
        if(low > lowSize){
            return findRepeatNumber1(array, p, mid);
        }else if(high > highSize){
            return findRepeatNumber1(array, mid + 1, q);
        }else {
            return -1;
        }
    }

}
