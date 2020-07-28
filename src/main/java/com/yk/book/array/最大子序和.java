package com.yk.book.array;

/**
 * @description: 最大子序和.
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author: Yangk
 * @create: 2020-07-11
 */
public class 最大子序和 {

    public static void main(String[] args) {
        int[] array = {2, 1, -6, 4, -1, 2, 1, -5, 4};

        int maxSubArray = maxSubArray(array);

        System.out.println(maxSubArray);
    }

    /**
     *
     * 使用动态规划解决，以 n-1 元素结尾的最大子序和用f(n-1)表示，则 f(n-1) = max((f(n-2) + num[n-1]), num[n-1])，
     * 也就是在f(n-2) + num[n-1] 和 num[n-1]之间求最大值，这两种结果都有可能，也就是这个数本身，或者从以上一个数为结尾的最大自序和 + 数本身。
     *
     * 思考方向是倒序，但是做法是正序。
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        //存储上一个子数组的最大子序和
        int preSum = nums[0];
        //存储最大值
        int max = nums[0];

        if (nums.length <= 1) {
            return max;
        }

        for (int i = 1; i < nums.length; i++) {
            //存储本次循环（也就是当前子数组）的最大子序和
            int sum = Math.max(preSum + nums[i], nums[i]);
            //与之前的max比较
            max = Math.max(sum, max);

            preSum = sum;
        }
        return max;
    }

    /**
     * 先遍历一次判断是否数组中全是负数，如果是的话，直接返回数组中最大值
     * 再遍历一次，寻找起点和终点
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if(num > max){
                max = num;
            }

            if(num > 0){
                break;
            }
        }

        if(max < 0){
            return max;
        }

        int start = 0;

        int end = 0;

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            //如果sum是0，则代表是刚开始遍历、或者之前的子序和为负数，被强制归0了。此时初始化起点和终点
            if(sum == 0){
                start = i;
                end = i;
            }

            sum += num;

            //如果和小于0，则把sum归0
            if(sum <= 0){
                start = i;
                end = i;
                sum = 0;
                continue;
            }

            //如果和大于max，则替换，并把终点移动到当前位置
            if(sum > max){
                end = i;
                max = sum;
            }
        }

        System.out.println(start + "->" + end);
        return max;
    }
}
