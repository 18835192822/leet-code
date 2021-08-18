package com.yk.book.array;

import com.yk.book.sort.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和.
 * <p>
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 *
 * @author: yangkun
 * @create: 2021-07-31 16:58
 */
public class 三数之和 {


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4, -1};
//        int[] nums = {0, 0, 0};

        System.out.println(threeSum(nums));
    }


    /**
     * 先将数组排序，接着选择基准点，并以基准点后一位为左指针，数组最后一元素为右指针，计算和
     * 如果等于0：则保存到结果数组，并将左右指针各移动一位
     * 小于0：则左指针右移
     * 大于0：则右指针左移
     *
     * 注意：不允许有重复结果集
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }

        QuickSort.quickSort(nums, 0, nums.length - 1);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int last = nums[0];
        //从0开始循环，到倒数第3个元素为止；如果基准点元素大于0，则和不可能等于0，退出循环
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            //保留上一次的基准点，相等则直接跳过
            if (nums[i] == last && i != 0) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //判断左节点有几个相等的数，右移全部跳过
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    //判断右节点有几个相等的数，左移全部跳过
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
            last = nums[i];
        }
        return result;
    }
}
