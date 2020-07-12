package com.yk.book.array;

/**
 * @description: 剪绳子.
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1]。
 * 请问 k[0] * k[1] *...* k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
 * 此时得到的最大乘积是18。
 *
 * @author: Yangk
 * @create: 2020-07-12
 */
public class 剪绳子 {

    public static void main(String[] args) {
        int product = cuttingRope(10);
        System.out.println(product);
    }

    /**
     * 动态规划解决
     * 把大问题的最优解拆分分解为求小问题的最优解，再使用动态规划中最常用的，从小结果算起，每种小结果存储，以减少重复计算，最后得出最优解。
     *
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        //如果长度是2米，则只能剪为 1 * 1。ps：必须至少剪一次
        if(n == 2){
            return 1;
        }

        //如果长度是3米，则只能剪为 1 * 2
        if(n == 3){
            return 2;
        }

        //这个数组用来存储各种长度下乘积的最大值，但对于0、1、2、3例外
        int[] product = new int[n+1];

        //这里为什么要定义这四个值呢，是因为程序运行到此处说明长度一定大于等于4，那么对于1、2、3来说，他们就可以不剪，因为剪了乘积反而会降低
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;

        //从长度为4开始算起，最大是n
        for (int i = 4; i <= n; i++) {
            //记录不同长度下乘积最大值
            int max = 0;

            //这里循环意思是对于不同的长度，遍历所有裁剪方式来求最大值。为什么要小于等于i/2，是因为对于乘积来说，1 * (i-1) == (i-1) * 1
            for(int j = 1 ; j <= i/2 ; j++){
                int temp = product[j] * product[i - j];
                if(temp > max){
                    max = temp;
                }
            }
            //存储不同长度绳子的最大值
            product[i] = max;
        }
        //返回长度为n时的值即可。
        return product[n];
    }
}
