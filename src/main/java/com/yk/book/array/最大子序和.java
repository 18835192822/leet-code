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
     * 计算极值，首先考虑使用动态规划来解决
     * 定义dp：dp(n)表示长度为n的数组，最大连续子数组
     * 状态转移方程，简单思考过后：dp(n) = max((dp(n - 1) + n), dp(n - 1))
     * 定义完成后发现不对，dp(n)代表的是长度为n的数组最大连续子数组，他不能和n直接相加，因为他可能与n不连续
     *
     * 重新定义dp：dp(n)表示长度为n的数组，"以n结尾"的最大连续子数组，以n结尾的意思是这个最大连续子数组必须包含n
     * 状态转移方程：dp(n) = max((dp(n - 1) + n), n)，既然必须包含n，那么最大值就是要么把n连进去，要么n单独一个
     * 那么问题又来了，这个动态规划仅仅得到了以n结尾的最大子序和，如果真正的最大子序和不是以n结尾呢？
     * 从dp(1) -> dp(n)有n个数，从中取最大的即是「真正的最大自序和」
     *
     * 所以这道题的解法使用了：动态规划 + 穷举
     *
     * 从这道题得到的经验是：当单独使用动态规划不能解决问题时，可以将问题降级，组合其他方式解决问题。
     *
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
