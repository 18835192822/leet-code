package com.yk.book.array;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 * [7,1,5,3,6,4]
 *
 * @author: yangkun
 * @create: 2020-08-21 17:40
 */
public class 买卖股票的最佳时机 {

    public static void main(String[] args) {

        int[] array = {7,1,5,3,6,4};
//        int[] array = {7,6,5,4,3,2,1};

        int maxSubArray = maxProfit3(array);

        System.out.println(maxSubArray);

    }

    /**
     *
     * 和最大子序和类似，都是使用动态规划解决 + 穷举来完成
     * 最佳时机是股票价值最高 - 价值最低
     *
     * 穷举：f(n) = max(f(2) ~ f(n))
     * 动态规划
     * dp：dp(n)代表长度为n的数组最小值
     * 最优子结构：dp(n) = v(n) - min(1 ~ n-1)
     *
     * 定义dp：dp(n)表示在第n天卖出股票的最大收益
     * 最优子结构：dp(n) = max(dp(1) ~ dp(n))
     *
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = prices.length - 1; i > 0; i--) {
            int element = prices[i];

            for (int j = 0; j < i; j++) {
                max = Math.max(element - prices[j],max);
            }
        }
        return max;
    }


    public static int maxProfit3(int[] prices) {
        int max = 0;
        int a = 0;

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];

            int thisTimeMax = 0;

            for (int j = a; j < i; j++) {
                int price1 = prices[j];

                thisTimeMax = Math.max(thisTimeMax, price - price1);
            }

            if(thisTimeMax > 0){
                a = i;
                max += thisTimeMax;
            }
        }
        return max;
    }

    public static int maxProfit2(int[] prices) {
        int max = 0;
        int preMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];

            max = Math.max(price - preMin, max);
            preMin = Math.min(preMin, price);
        }

        return max;
    }
}
