package com.yk.book.array;

/**
 * 最小路径和.
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * @author: yangkun
 * @create: 2020-07-28 20:15
 */
public class 最小路径和 {


    public static void main(String[] args) {
        int[][] array = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int maxSubArray = minPathSum3(array);

        System.out.println(maxSubArray);
    }

    /**
     * 动态规划
     * <p>
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m * n)
     *
     * @param array
     * @return
     */
    public static int minPathSum(int[][] array) {
        int m = array.length;
        int n = array[0].length;

        //临时数组保存到达每个位置的最优路径值
        int[][] temp = new int[m][n];

        //初始值：起始位置路径和、第一列各位置路径和、第一行各位置路径和
        temp[0][0] = array[0][0];

        for (int i = 1; i < array.length; i++) {
            temp[i][0] = temp[i - 1][0] + array[i][0];
        }

        for (int j = 1; j < array[0].length; j++) {
            temp[0][j] = temp[0][j - 1] + array[0][j];
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                //从上一格移动到当前位置的路径和
                int up = temp[i - 1][j] + array[i][j];
                //从左一格移动到当前位置的路径和
                int left = temp[i][j - 1] + array[i][j];
                //取两者最小值放在当前位置缓存
                temp[i][j] = Math.min(up, left);
            }
        }

        return temp[m - 1][n - 1];
    }

    /**
     * 动态规划，使用原数组作为最小路径和数组
     * <p>
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(1)
     *
     * @param array
     * @return
     */
    public static int minPathSum2(int[][] array) {
        for (int i = 1; i < array.length; i++) {
            array[i][0] = array[i - 1][0] + array[i][0];
        }

        for (int j = 1; j < array[0].length; j++) {
            array[0][j] = array[0][j - 1] + array[0][j];
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {

                //从上一格移动到当前位置的路径和从左一格移动到当前位置的路径和
                array[i][j] = Math.min(array[i - 1][j], array[i][j - 1]) + array[i][j];
            }
        }

        return array[array.length - 1][array[0].length - 1];
    }

    /**
     * 动态规划。
     * 不修改原数组的情况，使用一维数组来承接遍历过程中需要的临时值。
     * 因为是按行遍历，所以在遍历过程中，要求下一行的最小路径和，只需要上一行的路径和即可（求的结果后替换）；求右侧格子的路径和只需要知道左边一个格子的路径和即可。
     * <p>
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m)
     *
     * @param array
     * @return
     */
    public static int minPathSum3(int[][] array) {
        int[] temp = new int[array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                //起始位置
                if (i == 0 && j == 0) {
                    temp[j] = array[i][j];
                }
                //第一行各个格子的路径和
                else if (i == 0) {
                    temp[j] = temp[j - 1] + array[i][j];
                }
                //第一列各个格子的路径和
                else if (j == 0) {
                    temp[j] = temp[j] + array[i][j];
                }
                //当前位置的路径最小路径和等于：上一个格子和左一个格子的最小值 + 当前权值
                else {
                    temp[j] = Math.min(temp[j - 1], temp[j]) + array[i][j];
                }
            }
        }
        return temp[array[0].length - 1];
    }
}
