package com.yk.book.array;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @author: yangkun
 * @create: 2021-07-22 20:31
 */
public class 爬楼梯 {

    public static void main(String[] args) {
        int num = 2;
        int count = climbStairs(num);

        System.out.println(count);
    }


    /**
     * f(n) = f(n-1) + f(n-2)
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }

        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }
}
