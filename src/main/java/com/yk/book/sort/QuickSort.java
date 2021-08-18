package com.yk.book.sort;


import java.util.Arrays;

/**
 *
 * 快速排序
 * 首先快速排序使用了分治法 + 递归
 * 他的思想主要是先选取一个数，先粗略的将比这个数大的和小的数各自放在两侧，这个数的值在过程中也随之确定，这个位置就定死了，接着再对这个位置两边的数据进行同样操作
 * <p>
 * 此种写法为原始写法，选取数组第一位为标志位，在输入数组为顺序或逆序时效率最低，退化为选择排序。
 *
 * @author: yangkun
 * @create: 2021-08-03 21:04
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] numbers = {1, 5, 3, 9, 7, 4, 6};

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println(Arrays.toString(numbers));
    }

    public static void quickSort(int[] numbers, int start, int end) {
        if (end <= start) {
            return;
        }

        //左右两个游标
        int left = start;
        int right = end;
        //标志位
        int pivot = numbers[left];

        while (left != right) {
            //从右开始，碰到小于标志位才停止，但同时右游标不可越过左游标
            while (pivot <= numbers[right] && left < right) {
                right--;
            }

            //从左开始，碰到大于标志位才停止，但同时右游标不可越过左游标
            while (pivot >= numbers[left] && left < right) {
                left++;
            }

            //如果此时左还是小于右，则说明凑齐了一对可以交换的数。交换
            if (left < right) {
                swap(numbers, left, right);
            }
        }

        //走到此处，left 一定等于right，也就是标志位的真正位置，交换。
        swap(numbers, start, left);

        //左右两块区域各自递归
        quickSort(numbers, start, left - 1);
        quickSort(numbers, left + 1, end);
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
