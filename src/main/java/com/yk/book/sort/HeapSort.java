package com.yk.book.sort;

/**
 * 堆排序
 * 主要分两步去完成，
 * 1、将数据构建成大顶堆（或小顶堆，取决于排序结果要求）
 * 2、将堆顶与最后一个节点交换位置，重复此过程，
 * 最后得到从小到大的数组。
 *
 * @author: yangkun
 * @create: 2021-08-03 19:12
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] numbers = {1, 5, 3, 9, 7, 4, 6};

        //构建大顶堆
        heapBuild(numbers);
        print(numbers);

        //循环将根节点和最后一个节点交换，去掉最后一个节点，并重新调整堆。
        for (int i = numbers.length - 1; i >= 0; i--) {
            exchange(numbers, i, 0);
            heapify(numbers, i - 1, 0);
        }

        print(numbers);
    }

    /**
     * 初始化构建堆
     *
     * @param tree
     */
    private static void heapBuild(int[] tree) {
        //最后一个节点下标
        int lastNode = tree.length - 1;

        //最后一个父节点，也就是最后一个非叶子结点。这里为啥不需要判断最后一个子节点是左孩子(奇数)还是右孩子(偶数)呢？
        //是因为无论奇数偶数，减一后除2都会舍去小数，所以结果一样。
        int lastParent = (lastNode - 1) / 2;

        //从最后一个父节点开始往前推，所有的父节点都要进行堆调整。
        for (int i = lastParent; i >= 0; i--) {
            heapify(tree, tree.length - 1, i);
        }
    }

    /**
     * 递归的调整堆结构，
     *
     * @param tree   堆数组
     * @param n      可供用来做堆调整的数组最大下标（数组中不是所有元素都要做堆调整）
     * @param parent 此次要调整的堆的父节点
     */
    private static void heapify(int[] tree, int n, int parent) {
        //递归结束条件，要调整的堆节点下标 >= 最大下标
        if (parent >= n) {
            return;
        }

        //要调整节点的左孩子下标
        int c1 = parent * 2 + 1;
        //要调整节点的右孩子下标
        int c2 = parent * 2 + 2;

        //假定最大值即是父节点
        int max = parent;
        //首先左孩子对此次堆调整可见，其次如果左孩子值大于父节点，则交换
        if (c1 <= n && tree[c1] > tree[max]) {
            max = c1;
        }

        //同上
        if (c2 <= n && tree[c2] > tree[max]) {
            max = c2;
        }

        //如果最大值不是父节点，则交换，并接着对交换的孩子节点进行堆调整。
        //因为子节点交换后值就变了，所以自己所在的堆也就不符合堆的规则，所以要递归调整，此时max是子节点的下标
        if (max != parent) {
            exchange(tree, max, parent);
            heapify(tree, n, max);
        }
    }

    private static void exchange(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private static void print(int[] numbers) {
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}