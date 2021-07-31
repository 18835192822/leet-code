package com.yk.book.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 哈希表
 *
 * @author: Yangk
 * @create: 2020-07-11
 */
public class 两数之和 {

    public static void main(String[] args) {
        int[] array = {2, 7, 11, 2086};
        int target = 2666;

        int[] ints = twoSum(array, target);

        System.out.println(Arrays.toString(ints));
    }

    /**
     * 使用哈希表解决，循环一次，将目标值target和当前值value的差存入哈希表中，接着只用去找这个值后续是否出现即可
     *
     * @param array
     * @param target
     * @return
     */
    private static int[] twoSum(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (map.containsKey(value)) {
                result[0] = map.get(value);
                result[1] = i;
            }

            map.put(target - value, i);
        }

        return result;
    }
}
