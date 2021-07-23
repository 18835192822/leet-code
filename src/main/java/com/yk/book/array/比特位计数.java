package com.yk.book.array;

import java.util.Arrays;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * @author: yangkun
 * @create: 2021-07-22 16:23
 */
public class 比特位计数 {


    public static void main(String[] args) {

        int num = 13;

        int[] ints = countBits2(num);

        System.out.println(Arrays.toString(ints));

    }

    /**
     * 最容易想到的方法，从0遍历数据，每个数据判断最小位是否为1，之后右移一位，直到值等于0
     *
     * 空间复杂度：O(1)
     * 时间复杂度：O(n*sizeof(integer))
     *
     * @param n
     * @return
     */
    public static int[] countBits(int n) {
        int[] arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {

            //当前数据i中含有1的个数
            int count = 0;
            for (int copy = i; copy > 0; copy >>= 1) {
                if (((copy & 1) == 1)) {
                    count++;
                }
            }
            arr[i] = count;
        }

        return arr;
    }

    /**
     * 动态规划解决
     *
     * 要使用动态规划，先要了解一个公式：f((n - 1) & n) + 1 =  f(n)
     * 意思是，n & (n-1) 相当于把n 的最小一位的1置为0，思考一下，n-1在二进制的本质是：把n最小的一位1变为0
     * 后面的所有0变为1，再与n做&操作，相当于是把那个1变为0
     *
     * 如14、13
     * 14：1110
     * 13：1101
     * 与运算后，变为1100，
     *
     * 定义dp：dp[i] 表示i这个值二进制所含有的1的数目
     * 最优子结构：f(n) = f((n - 1) & n) + 1
     *
     * 空间复杂度：O(1)
     * 时间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public static int[] countBits2(int n) {
        if(n == 0){
            return new int[]{0};
        }

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for( int i = 2 ; i<= n;i++){
            arr[i] = arr[(i-1) & i] + 1;
        }
        return arr;
    }
}
