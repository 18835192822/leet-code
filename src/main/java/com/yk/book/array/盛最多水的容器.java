package com.yk.book.array;

/**
 * 盛最多水的容器
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 双指针
 *
 * @author: yangkun
 * @create: 2021-07-29 20:46
 */
public class 盛最多水的容器 {


    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(height));
    }


    /**
     * 利用双指针，分别代表头尾的两个节点，计算面积，接着将高度较小的指针向另一个方向移动，直到和另一个指针重合
     *
     * 已知面积s等于
     * s = min(arr[start], arr[end]) * (end - start)
     *
     * 为什么要移动较小的指针？
     * 因为从公式中可的，与面积有关的是值小的指针，值较大的指针无论如何移动，都不可能增大面积，因为上限已经被限制死。
     * 接着因为我们是从数组的两边开始向内移动，所以也不存在长度上导致面积变大的情况出现。
     *
     *
     * 时间复杂度：O(N)，双指针总计最多遍历整个数组一次。
     *
     * 空间复杂度：O(1)，只需要额外的常数级别的空间。
     *
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if (height.length == 1) {
            return 0;
        }

        int start = 0;
        int end = height.length - 1;

        int max = 0;

        while (start < end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            max = Math.max(area, max);
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return max;
    }

}
