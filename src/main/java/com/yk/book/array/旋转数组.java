package com.yk.book.array;

import java.util.Arrays;

/**
 * 旋转数组
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 进阶：
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * <p>
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * @author: yangkun
 * @create: 2021-07-23 17:21
 */
public class 旋转数组 {


    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(rotate4(nums, 3)));

    }

    /**
     * 最简单的做法，循环k次，每次循环一次数组，将第一位数分别和后面的数交换，相当于完成了一次所有数字后移一位，循环k次
     * <p>
     * 时间复杂度：O(k * n)
     * 空间复杂度：1
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] rotate(int[] nums, int k) {
        if (nums.length <= 1) {
            return nums;
        }

        k %= nums.length;
        if (k <= 0) {
            return nums;
        }

        for (int i = 0; i < k; i++) {
            for (int j = 1; j < nums.length; j++) {
                int copy = nums[0];
                nums[0] = nums[j];
                nums[j] = copy;
            }
        }
        return nums;
    }

    /**
     * 和上面的思路类似，每次后移一位，循环k次，只是后移的方式换成了逐个替换
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] rotate2(int[] nums, int k) {
        if (nums.length <= 1) {
            return nums;
        }

        k %= nums.length;
        if (k <= 0) {
            return nums;
        }

        for (int i = 0; i < k; i++) {
            int copy = nums[0];
            for (int j = 1; j < nums.length; j++) {
                int a = nums[j];
                nums[j] = copy;
                copy = a;
            }
            nums[0] = copy;
        }
        return nums;
    }

    /**
     * 使用额外的数组来存储数据，直接将指定位置的数据赋值给第k位
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] rotate3(int[] nums, int k) {
        if (nums.length <= 1) {
            return nums;
        }

        k %= nums.length;
        if (k <= 0) {
            return nums;
        }

        int[] copy = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            copy[(j + k) % nums.length] = nums[j];
        }
        System.arraycopy(copy, 0, nums, 0, nums.length);
        return nums;
    }

    /**
     * 使用反转数组完成，逻辑如下：
     *
     * nums = "----->-->"; k =3
     * result = "-->----->";
     *
     * reverse "----->-->" we can get "<--<-----"
     * reverse "<--" we can get "--><-----"
     * reverse "<-----" we can get "-->----->"
     *
     * 先将所有数据反转，在将0到k-1的数据反转，再将k到n-1的数据反转
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] rotate4(int[] nums, int k) {
        if (nums.length <= 1) {
            return nums;
        }

        k %= nums.length;
        if (k <= 0) {
            return nums;
        }

        revert(nums, 0, nums.length - 1);
        revert(nums, 0, k - 1);
        revert(nums, k, nums.length - 1);
        return nums;
    }

    private static void revert(int[] nums, int start, int end){

        while (start < end){
            int copy = nums[start];
            nums[start] = nums[end];
            nums[end] = copy;

            start += 1;
            end -= 1;
        }
    }
}
