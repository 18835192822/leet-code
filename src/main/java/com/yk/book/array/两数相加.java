package com.yk.book.array;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * @author: yangkun
 * @create: 2021-07-30 19:34
 */
public class 两数相加 {


    public static void main(String[] args) {

        int[] arr1 = {2, 4, 3};
        int[] arr2 = {5, 6, 6, 4};
        ListNode l1 = buildList(arr1);
        ListNode l2 = buildList(arr2);

        System.out.println(listNodeToString(addTwoNumbers(l1, l2)));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 输出链表
     * @param listNode
     * @return
     */
    private static String listNodeToString(ListNode listNode) {
        StringBuilder sb = new StringBuilder("[");

        while (listNode != null) {
            sb.append(listNode.val).append(",");
            listNode = listNode.next;
        }

        return sb.deleteCharAt(sb.length() - 1).append("]").toString();
    }

    /**
     * 根据数组构建链表
     * @param nums
     * @return
     */
    private static ListNode buildList(int[] nums) {
        ListNode first = new ListNode();
        ListNode now = first;

        for (int num : nums) {
            ListNode node = new ListNode(num);
            now.next = node;
            now = node;
        }
        return first.next;
    }

    /**
     * 因为节点数最多100个，所以不能将链表转换成数字后计算
     *
     * 思想是：逐个计算两个链表对应位置节点的和，注意考虑进位、链表长度不一致两个因素即可
     *
     *
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //进位值
        int carry = 0;

        //结果的头节点
        ListNode first = new ListNode();

        //当前节点
        ListNode now = first;

        while (l1 != null || l2 != null || carry != 0) {

            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int value = v1 + v2 + carry;

            //进位值，如果大于10就为1，反之则被归0
            carry = value / 10;

            //链表尾部插入新节点
            ListNode node = new ListNode(value % 10);
            now.next = node;
            now = node;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        return first.next;
    }
}
