package com.yk.book.array;

/**
 * @description: 题目一：找出数组中重复数字。(剑指 Offer 03. )
 * 在一个长度为 n的数组里的所有数字都在 0 ~ n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次
 * 请找出数组中任意一个重复的数字，例如，如果输入长度为 7 的数组｛ 2 , 3 , 1 , 0 , 2 , 5 , 3 } ，那么对应的输出是重复的数字 2 或者 3 。
 * @author: Yangk
 * @create: 2020-07-11
 */
public class 数组中重复的数字 {

    public static void main(String[] args) {
        int[] array = {2 , 3 , 1 , 0 , 2 , 5 , 3 , 3};
        findRepeatNumber2(array);

    }

    /**
     * 利用临时数组存储数据，各个数值的数都存在相应位置，遍历数组，如果位置已有数据则是重复数字。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param array
     */
    private static int findRepeatNumber1(int[] array){
        Integer[] arrayTemp = new Integer[array.length];

        for (int i : array) {
            if(arrayTemp[i] == null){
                arrayTemp[i] = i;
            }else {
                return i;
            }
        }

        return -1;
    }

    /**
     * 不借助临时数组，仅在原数组上操作。
     * 遍历数组，如果当前数值和下标不等，且数值与以当前数值作为下标处的数值也不等，则交换彼此，重复以上步骤.否则，该数值就是一个重复数字。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param array
     */
    private static int findRepeatNumber2(int[] array){
        for (int i = 0; i < array.length; i++) {
            int value = array[i];

            if(value != i){
                if(array[value] != value){
                    array[i] = array[value];
                    array[value] = value;
                    i--;
                }else {
                    return value;
                }
            }
        }

        return -1;
    }

}
